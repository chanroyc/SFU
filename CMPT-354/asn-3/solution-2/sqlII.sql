use chanroyc354
go
CREATE PROCEDURE AvgStandardCost
AS
BEGIN
	SELECT AVG(StandardCost) as Average_StandardCost
	FROM AdventureWorksLT.SalesLT.Product
	WHERE color = 'red'
END