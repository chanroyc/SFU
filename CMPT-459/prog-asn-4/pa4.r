install.packages('arules')
install.packages('arulesViz')
library(arules)
library(arulesViz)

data(Groceries)
summary(Groceries)

#Plot Item Frequency Histogram
itemFrequencyPlot(Groceries, topN=20, type="relative")

#Minimum support=0.001
rules2 <- apriori(Groceries, parameter=list(support=0.001))
summary(rules2)

#Minimum support=0.01
rules3 <- apriori(Groceries, parameter=list(support=0.01))
summary(rules3)

#10 Itemsets with Highest Support
inspect(rules2[1:10])
inspect(rules3) #0 Rules

#Minimum Support=0.01, Confidence=0.9
rules6 <- apriori(Groceries, parameter=list(support=0.01, confidence=0.9))
summary(rules6) #0 Rules

#Minimum Support=0.01, Confidence=0.5174
#Confidence<0.5174 to produce strictly more than 10 rules
rules6 <- apriori(Groceries, parameter=list(support=0.01, confidence=0.5174))
summary(rules6) #10 rules

#Minimum Support=0.01, Confidence=0.5, Plot Whole Milk only
rules7<- apriori(Groceries, parameter=list(support=0.01, confidence=0.5))
summary(rules7)
wholemilkrules <- subset(rules7, rhs %pin% "whole milk")
inspect(wholemilkrules)
plot(wholemilkrules)
