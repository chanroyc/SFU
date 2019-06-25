use chanroyc354
go
create view RedSpending as
SELECT C.CustomerID, C.FirstName, C.LastName, Max(S1.UnitPrice) as HighestPrice
FROM AdventureWorksLT.SalesLT.SalesOrderDetail S1, AdventureworksLT.SalesLT.Customer C, AdventureWorksLT.SalesLT.SalesOrderHeader S2, AdventureworksLT.SalesLT.Product P
WHERE S1.SalesOrderID = S2.SalesOrderID AND
S1.ProductID = P.ProductID AND
S1.SalesOrderID = S2.SalesOrderID AND
C.CustomerID = S2.CustomerID AND
P.color = 'red'
GROUP BY C.CustomerID, C.FirstName, C.LastName

go
Select * FROM RedSpending

go
Select DISTINCT P.color from AdventureWorksLT.SalesLT.Product P
ORDER BY P.color ASC
