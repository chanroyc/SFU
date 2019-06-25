#Read CSV
titanic <- read.csv("C:/Users/chanr/Downloads/CMPT459/PA2/titanic3.csv")

#Sample titanic3.csv with 80% training data split and 20% test data split
set.seed(1)
indexes = sample(1:nrow(titanic), size=0.8*nrow(titanic))

training.data.raw = titanic[indexes,]
test.data.raw = titanic[-indexes,]

#Number of missing values per attribute in the training dataset
sapply(training.data.raw ,function(x) sum(is.na(x)))


#Number of missing values per attribute in the test dataset
sapply(test.data.raw, function(x) sum(is.na(x)))



#----------------------------------- Feature Extraction--------------------------------------------

# Choose meaningful attributes as features which are relevant for the given data mining task
# Feature extraction is an "art" that is highly dependent on the skill of the data scientist

## pclass: Passenger class - Irrelevant
## survived: Survival - Relevant
## name: Name - Irrelevant
## sex: Sex - Relevant
## age: Age - Relevant
## sibsp: Number of Siblings/Spouses Aboard - Relevant
## parch: Number of Parents/Children Abaord - Relevant
## ticket: Ticket Number - Irrelvant
## fare: Passenger Fare - Irrelevant
## cabin: Cabin - Relevant
## embarked: Point of Embarkation - Relevant
## boat: Lifeboat the passenger took - Relevant
## body: Body Identification Number - Irrelevant
## home.dest : Home/Destination - Irrelevant

# Assuming that we want to predict the survival of a passenger at the time of the accident,
# the attributes I would choose as features are the following: 2, 4, 5, 6, 7, 10, 11, 12

#-------------------------------- How to deal with Missing Values -----------------------------------

# The typical approach is to replace the missing values with the average, the median, or the mode of the existing one
# I'll be using the average.

training.data.subset <- subset(training.data.raw, select=c(2, 4, 5, 6, 7, 12))
test.data.subset <- subset(test.data.raw, select=c(2, 4, 5, 6, 7, 12))

training.data.subset$age[is.na(training.data.subset$age)] <- mean(training.data.subset$age, na.rm=T)
test.data.subset$age[is.na(test.data.subset$age)] <- mean(test.data.subset$age, na.rm=T)

model <- glm(survived ~.,family=binomial(link='logit'),data=training.data.subset)

summary(model)

# boat < sex male < parch < sibsp < age

# ----------------------------- Linear Regression Confusion Matrix --------------------------------------

library("rpart")
training.data.subset.tree <- rpart(survived ~ ., data = training.data.subset, method = "class")
training.data.subset.pred <- predict(training.data.subset.tree, training.data.subset, type = "class")
training.data.subset.pred.t <- table(training.data.subset$survived, training.data.subset.pred)
plot(training.data.subset.pred.t)

training.data.subset.pred.accuracy <- (training.data.subset.pred.t[1, 1] + training.data.subset.pred.t[2, 2]) / sum(training.data.subset.pred.t)
cat("Model Accuracy on Sub sample on training data: ", training.data.subset.pred.accuracy)

test.data.subset.tree <- rpart(survived ~ ., data = test.data.subset, method = "class")
test.data.subset.pred <- predict(test.data.subset.tree, test.data.subset, type = "class")
test.data.subset.pred.t <- table(test.data.subset$survived, test.data.subset.pred)
plot(test.data.subset.pred.t)

test.data.subset.pred.accuracy <- (test.data.subset.pred.t[1, 1] + test.data.subset.pred.t[2, 2]) / sum(test.data.subset.pred.t)
cat("Model Accuracy on Sub sample on training data: ", test.data.subset.pred.accuracy)

# -------------------------------------------- ROC and AUC ----------------------------------------------

# ------------------------------------------- SVMModel Tune ---------------------------------------------

library("e1071")
training.data.subset.SVMModel.linear <- svm(survived ~., data = training.data.subset, kernel = "linear")
training.data.subset.SVMModel.linear.tune <- tune.svm(survived ~., data = training.data.subset, kernel = "linear", cost=2^(-5:5), gamma=c(.5,1,2))
# The best parameters for the linear kernel is cost = 32 and gamma = 0.5
training.data.subset.SVMModel.linear <- svm(survived ~., data = training.data.subset, kernel = "linear", cost = 32, gamma = 0.5)

training.data.subset.SVMModel.radial <- svm(survived ~., data = training.data.subset, kernel = "radial")
training.data.subset.SVMModel.radial.tune <- tune.svm(survived ~., data = training.data.subset, kernel = "radial", cost=2^(-5:5), gamma=c(.5,1,2))
# The best parameters for the radial kernel is cost = 2 and gamma = 0.5
training.data.subset.SVMModel.radial <- svm(survived ~., data = training.data.subset, kernel = "radial", cost = 2, gamma = 0.5)

test.data.subset.SVMModel.linear <- svm(survived ~., data = test.data.subset, kernel = "linear")
test.data.subset.SVMModel.linear.tune <- tune.svm(survived ~., data = test.data.subset, kernel = "linear", cost=2^(-5:5), gamma=c(.5,1,2))
# The best parameters for the linear kernel is cost = 32 and gamma = 0.5
test.data.subset.SVMModel.linear <- svm(survived ~., data = test.data.subset, kernel = "linear", cost = 32, gamma = 0.5)

test.data.subset.SVMModel.radial <- svm(survived ~., data = test.data.subset, kernel = "radial")
test.data.subset.SVMModel.radial.tune <- tune.svm(survived ~., data = test.data.subset, kernel = "radial", cost=2^(-5:5), gamma=c(.5,1,2))
# The best parameters for the radial kernel is cost = 2 and gamma = 0.5
test.data.subset.SVMModel.radial <- svm(survived ~., data = test.data.subset, kernel = "radial", cost = 2, gamma = 0.5)
# ---------------------------------------- SVMModel Confusion Matrix ------------------------------------

test.data.subset.SVMModel.linear.pred <- predict(test.data.subset.SVMModel.linear, test.data.subset, type = "class")
test.data.subset.SVMModel.linear.pred.t <- table(test.data.subset.SVMModel.linear.pred, test.data.subset$survived)
plot(test.data.subset.SVMModel.linear.pred.t)

cat("Model accuracy on sub sample on test data using linear kernel:")

test.data.subset.SVMModel.radial.pred <- predict(test.data.subset.SVMModel.radial, test.data.subset, type = "class")
test.data.subset.SVMModel.radial.pred.t <- table(test.data.subset.SVMModel.radial.pred, test.data.subset$survived)
plot(test.data.subset.SVMModel.radial.pred.t)

cat("Model accuracy on sub sample on test data using radial kernel:" )
