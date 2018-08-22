use store_front;

#1
SELECT o.Id, o.PlacedDate, SUM(p.Price * opr.Quantity)
FROM Orders AS o, Product AS p, OrderProduct AS opr
WHERE o.Id = opr.OrderId AND p.Id = opr.ProductId
GROUP BY o.Id
ORDER BY o.PlacedDate DESC
LIMIT 50;

#2
SELECT o.Id, o.PlacedDate, SUM(p.Price * opr.Quantity) AS TotalBill
FROM Orders AS o, Product AS p, OrderProduct AS opr
WHERE o.Id = opr.OrderId AND p.Id = opr.ProductId
GROUP BY o.Id
ORDER BY TotalBill DESC; 

#3
SELECT opr.OrderId, opr.ProductId
FROM OrderProduct AS opr, Orders As o
WHERE opr.OrderId = o.Id AND opr.Status != "Shipped" AND DATEDIFF(CURDATE(), o.PlacedDate) > 10;

#4
SELECT u.Id
FROM User AS u, Orders As o
WHERE DATEDIFF(CURDATE(), o.PlacedDate) > 30 AND u.Id = o.UserId;

#5
SELECT u.Id, o.Id
FROM User AS u, Orders As o
WHERE DATEDIFF(CURDATE(), o.PlacedDate) < 15 AND u.Id = o.UserId;

#6
SELECT opr.ProductId, p.Name
FROM OrderProduct AS opr, Orders AS o, Product AS p
WHERE opr.Status = "Shipped" AND o.Id = "1" AND p.Id = opr.ProductId;

#7
SELECT o.PlacedDate, opr.ProductId, o.Id, p.Name
FROM OrderProduct AS opr, Orders AS o, Product AS p
WHERE p.Price < 50 AND p.Price > 20 AND p.Id = opr.ProductId AND o.Id = opr.OrderId
GROUP BY o.Id;

#8
SET SQL_SAFE_UPDATES = 0;
UPDATE OrderProduct
SET Status = "Shipped"
WHERE OrderId IN (SELECT Id FROM Orders WHERE PlacedDate = CURDATE())
LIMIT 20;
