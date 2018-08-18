#Display Shopper’s information along with number of orders he/she placed during last 30 days.
SELECT u.Id, u.FirstName, u.Phone, COUNT(o.Id)
FROM User AS u, Orders AS o
WHERE u.Id = o.UserId AND DATEDIFF(CURDATE(), o.PlacedDate) <= 30;

#Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
SELECT u.Id, u.FirstName, SUM(opr.Quantity * p.Price) AS sum
FROM User AS u, Orders AS o, OrderProductRelation AS opr, Product AS p
WHERE u.Id = o.UserId AND o.Id = opr.OrderId AND p.Id = opr.ProductId
GROUP BY o.Id
ORDER BY sum DESC
LIMIT 10;

#Display top 20 Products which are ordered most in last 60 days along with numbers.
SELECT p.Id, p.Name, COUNT(p.Id) AS count
FROM Product AS p, Orders AS o, OrderProductRelation AS opr
WHERE p.Id = opr.ProductId AND opr.OrderId = o.Id AND DATEDIFF(CURDATE(), o.PlacedDate) <= 60
GROUP BY p.Id
ORDER BY count DESC
LIMIT 20;

