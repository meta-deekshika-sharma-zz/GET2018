#2
SELECT p.Id, p.Name, c.Name, p.Price
FROM Product AS p, Category AS C, ProductCategory AS cpr
WHERE p.Id = cpr.ProductId AND c.Id = cpr.CategoryId
ORDER BY ProductId DESC;

#3
SELECT p.Id, p.Name, p.Description, p.Price
FROM Product AS p
WHERE p.Id IN (SELECT i.ProductId FROM Image as i);

#4
SELECT c.Id, c.Name, ca.Name
FROM Category AS c, Category AS ca
WHERE c.ParentCategoryId = ca.Id
ORDER BY ca.name, c.name;

#5
SELECT c.Id, c.Name, ca.Name
FROM Category AS c, Category AS ca
WHERE c.ParentCategoryId = ca.Id AND c.Id NOT IN (SELECT ParentCategoryId FROM Category);

#6
SELECT p.Name, p.Description, p.Price
FROM Product AS p, Category AS c, ProductCategory AS cpr
WHERE c.Name = "Mobiles" AND p.Id = cpr.ProductId AND c.Id = cpr.CategoryId;

#7
SELECT Name
FROM Product
WHERE Stock < 50;

#8
SET SQL_SAFE_UPDATES = 0;
UPDATE Product SET Stock = Stock + 100;
