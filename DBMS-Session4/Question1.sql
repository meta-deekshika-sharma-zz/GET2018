use store_front;

#Create a function to calculate number of orders in a month. Month and year will be input parameter to function.
DELIMITER *
CREATE FUNCTION no_Of_Order(month INT, year INT)
 RETURNS INT
 NOT DETERMINISTIC
 
 BEGIN
 DECLARE noOfOrders INT;
 
    SELECT COUNT(opr.OrderId) INTO noOfOrders
    FROM Orders AS o INNER JOIN OrderProductRelation AS opr ON o.Id = opr.OrderId
    WHERE MONTH(o.PlacedDate) = month AND YEAR(o.PlacedDate) = year;
    
RETURN (noOfOrders);
END *

SELECT no_of_order(08, 2018);

#Create a function to return month in a year having maximum orders. Year will be input parameter.
DELIMITER *
CREATE FUNCTION  max_orders(year INT)
RETURNS INT
NOT DETERMINISTIC

BEGIN
DECLARE monthHavingMaxOrder INT;

   SELECT MAX(a.monthHavingMaxOrder) INTO monthHavingMaxOrder
   FROM (SELECT MONTH(o.PlacedDate) monthHavingMaxOrder, COUNT(opr.OrderId)
         FROM Orders AS o INNER JOIN OrderProductRelation AS opr ON o.Id = opr.OrderId
         WHERE YEAR(o.PlacedDate) = year
         GROUP BY MONTH(o.PlacedDate)
   ) a;
   
RETURN (monthHavingMaxOrder);
END*


SELECT max_orders(2018);