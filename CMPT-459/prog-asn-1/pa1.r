library(cluster)

#Read CSV file
wine <- read.csv("C:/Users/chanr/Downloads/wine.csv")

#Normalization
m <- apply(wine, 2, mean)
s <- apply(wine, 2, sd)
z <- scale(wine,m,s)

#K-means
kc <- kmeans(wine, 4)
s <- silhouette(kc$cluster, distance)

plot(s)

#Euclidean Distance
distance <- dist(z)

#Cluster Dendrogram with Complete Linkage
hc.c <- hclust(distance)
plot(hc.c)

#Cluster Dendrogram with Average Linkage
hc.a <- hclust(distance, method = "average")
plot(hc.a)

#Cluster Dendrogram with Single Linkage
hc.s <- hclust(distance, method = "single")
plot(hc.s)

#Silhouette Plot
plot(silhouette(cutree(hc.c, 4), distance))
     