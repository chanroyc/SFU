install.packages('Amelia')
install.packages('tree')
install.packages('ROCR')
install.packages('randomForest')
library(Rcpp)
library(Amelia)
library(tree)
library(ROCR)
library(randomForest)

#---------------------------------------- Read Dataset --------------------------------------------

data <- read.csv("C:/Users/chanr/Downloads/CMPT459/PA2/titanic3.csv")

#Sample titanic3.csv with 80% training data split and 20% test data split
set.seed(1)
indexes = sample(1:nrow(data), size=0.8*nrow(data))

data$survived <- as.factor(data$survived)

training.data.raw = data[indexes,]
test.data.raw = data[-indexes,]

#Number of missing values per attribute in the training dataset
sapply(training.data.raw ,function(x) sum(is.na(x)))


#Number of missing values per attribute in the test dataset
sapply(test.data.raw, function(x) sum(is.na(x)))

#Map of missing values per attribute
missmap(training.data.raw, main = "Missing Values vs Observed")


#-------------------------------------- Feature Extraction------------------------------------------

# Choose meaningful attributes as features which are relevant for the given data mining task
# Feature extraction is an "art" that is highly dependent on the skill of the data scientist

# Body has too many missing values, we will not use it..

train <- subset(training.data.raw, select=c(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14))
test <- subset(test.data.raw, select=c(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14))

#---------------------------------------- Missing Values -------------------------------------------

# The typical approach is to replace the missing values with the average, the median, or the mode of the existing one
# I'll be using the average.

train$age[is.na(train$age)] <- mean(train$age, na.rm=T)
test$age[is.na(test$age)] <- mean(test$age, na.rm=T)

#----------------------------------------- Decision Tree -------------------------------------------

#Learn a decision tree from the training data
tree.model <- tree(survived ~ pclass + sex + age + sibsp + parch + fare + embarked,
            data = train,
            split=c("gini"))
summary(tree.model)

#Plot the resulting Tree
plot(tree.model)
text(tree.model, pretty=0)

#Perform Cross-validation to determine optimal level of tree complexity, employing cost complexity pruning
cv.model <- cv.tree(tree.model, FUN = prune.misclass)
plot(cv.model)

#Get best decision tree with the best size computed in previous task
best.size <- which.min(cv.model$size[which(cv.model$dev==min(cv.model$dev))])
cv.model.pruned <- prune.tree(tree.model, best=best.size)
summary(cv.model.pruned)
plot(cv.model.pruned)
text(cv.model.pruned, pretty=0)

#Apply tree model to predict class labels of test data. Print the confusion matrix
pruned.prediction <- predict(cv.model.pruned, newdata=test, type="class")
table(pruned.prediction, test$survived)

#Accuracy of the model
tree.misClasificError <- mean(pruned.prediction != test$survived)
print(paste('Accuracy:', 1-tree.misClasificError))

#Plot ROC curve
tree.prediction <- prediction(as.numeric(pruned.prediction), as.numeric(test$survived))
tree.roc <- performance(tree.prediction, measure="tpr", x.measure="fpr")
plot(tree.roc)

#Calculate auc
tree.auc <- performance(tree.prediction, measure="auc")
tree.auc <- tree.auc@y.values[[1]]
tree.auc

#------------------------------------------- Random Forest -------------------------------------------

#Learn a random forest from the training data with the number of trees initially set to 100
forest.model <- randomForest(survived~ pclass + sex + age + sibsp + parch + embarked,
                             data = train,
                             importance=TRUE,
                             ntree=1000)
#Apply random forest model to predict class labels of test data. Print out the confusion matrix.
forest.pred <- predict(forest.model, newdata=test, type="class")
table(forest.pred, test$survived)

#Accuracy of the model
forest.misClasificError <- mean(forest.pred != test$survived)
print(paste('Accuracy:', 1-forest.misClasificError))

#Plot ROC curve
forest.prediction <- prediction(as.numeric(forest.pred), as.numeric(test$survived))
forest.roc <- performance(forest.prediction, measure="tpr", x.measure="fpr")
plot(forest.roc)

#Calculate auc
forest.auc <- performance(forest.prediction, measure="auc")
forest.auc <- forest.auc@y.values[[1]]
forest.auc

#importance() and varImpPlot()
importance(forest.model)
varImpPlot(forest.model)
