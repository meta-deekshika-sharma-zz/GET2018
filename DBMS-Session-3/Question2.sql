use store_front;

#Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.
SELECT p.Id , p.Name , COUNT(pc.ProductId) AS countcategories
FROM Product p INNER JOIN ProductCategory pc
ON pc.ProductId = p.Id
GROUP BY pc.ProductId
HAVING countcategories > 1;

#Display Count of products as per price range
SELECT pnew.rangeofprice , count(*) 
FROM (SELECT CASE
       WHEN Price > 0 AND Price < 100 THEN "0-100"
       WHEN Price > 100 AND Price < 500 THEN "100-500"
       ELSE "Above 500" END AS rangeofprice
   FROM Product) pnew
GROUP BY pnew.rangeofprice;

#Display the Categories along with number of products under each category.
SELECT c.Id , c.Name , COUNT(pc.CategoryId)
FROM category c INNER JOIN ProductCategory pc
ON c.Id = pc.CategoryId
GROUP BY pc.CategoryId;