use store_front;

/*Create a view displaying the order information 
(Id, Title, Price, Shopper’s name, Email, Orderdate, Status)
with latest ordered items should be displayed first for last 60 days.*/

CREATE OR REPLACE VIEW DisplayOrderInformation
AS
SELECT o.Id, op.ProductId, p.Name, (p.Price * op.Quantity ) AS bill, u.FirstName, u.LastName, u.EmailId, o.PlacedDate, op.Status
FROM Orders AS o, Product AS p, User AS u, OrderProduct op
   WHERE op.OrderId = o.Id 
   AND o.UserId = u.Id 
   AND op.ProductId = p.Id 
   AND o.PlacedDate > (DATE_SUB(CURDATE(), INTERVAL 2 MONTH))
   ORDER BY op.OrderId DESC LIMIT 60;
       
       
SELECT * FROM DisplayOrderInformation;

#Use the above view to display the Products(Items) which are in ‘shipped’ state.
SELECT Name
FROM DisplayOrderInformation
WHERE Status= "Shipped";

#Use the above view to display the top 5 most selling products
SELECT Name , COUNT(ProductId) AS productcount
FROM DisplayOrderInformation
GROUP BY ProductId
ORDER BY productcount
LIMIT 5;