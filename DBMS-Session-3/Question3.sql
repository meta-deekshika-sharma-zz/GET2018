use store_front;

#Display Shopper’s information along with number of orders he/she placed during last 30 days.
SELECT u.Id, u.FirstName, u.Phone, COUNT(o.Id)
FROM User AS u, Orders AS o
WHERE u.Id = o.UserId AND DATEDIFF(CURDATE(), o.PlacedDate) <= 30;

#Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
SELECT u.Id, u.FirstName, SUM(op.Quantity * p.Price) AS sum
FROM User AS u, Orders AS o, OrderProduct AS op, Product AS p
WHERE u.Id = o.UserId AND o.Id = op.OrderId AND p.Id = op.ProductId
GROUP BY o.Id
ORDER BY sum DESC
LIMIT 10;

#Display top 20 Products which are ordered most in last 60 days along with numbers.
SELECT p.Id, p.Name, COUNT(p.Id) AS count
FROM Product AS p, Orders AS o, OrderProduct AS op
WHERE p.Id = op.ProductId AND op.OrderId = o.Id AND DATEDIFF(CURDATE(), o.PlacedDate) <= 60
GROUP BY p.Id
ORDER BY count DESC
LIMIT 20;

#Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale
SELECT EXTRACT(MONTH FROM o.PlacedDate) AS month , SUM(op.Quantity * p.Price) AS totalorder
FROM Orders AS o, Product AS p, OrderProductRelation AS op
WHERE o.Id = op.OrderId AND p.Id = op.ProductId AND o.PlacedDate > (DATE_SUB(CURDATE(), INTERVAL 6 MONTH))
GROUP BY MONTH(o.PlacedDate);

#Mark the products as Inactive which are not ordered in last 90 days.
SET SQL_SAFE_UPDATES = 0;
UPDATE Product
SET ProductState = "Inactive"
WHERE Product.Id IN 
                    (SELECT op.ProductId
                     FROM orders o INNER JOIN OrderProduct op
                     ON o.Id = op.OrderId
                     WHERE o.PlacedDate < (DATE_SUB(CURDATE(), INTERVAL 3 MONTH))
                     );
                     
                     SELECT * FROM Product;
                     
#Given a category search keyword, display all the Products present in this category/categories
SELECT p.Name
FROM Product p INNER JOIN ProductCategory pc  
ON p.Id = pc.ProductId
INNER JOIN category c
ON c.Id = pc.CategoryId
WHERE c.Name = "Mobiles";

#Display top 10 Items which were cancelled most.
SELECT p.Id , p.Name , COUNT(op.Status) AS cancelcount
FROM Product AS p INNER JOIN OrderProduct AS op
ON p.Id = op.ProductId
WHERE op.status = "Cancel"
GROUP BY op.ProductId
ORDER BY cancelcount DESC
LIMIT 10;
