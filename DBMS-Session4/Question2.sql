use store_front;

#Create a Stored procedure to retrieve average sales of each product in a month. Month and year will be input parameter to function.
DELIMITER **
CREATE PROCEDURE averageSales(month INT, year INT) 

BEGIN

    SELECT SUM(opr.Quantity * p.price) / DAY(LAST_DAY(o.PlacedDate)) AS productSum, p.Name
    FROM OrderProduct as opr
    INNER JOIN Product AS p ON opr.ProductID = p.Id
    INNER JOIN Orders AS o ON opr.OrderID = o.Id
    WHERE MONTH(o.PlacedDate) = month
    AND YEAR(o.PlacedDate) = year
    GROUP BY opr.ProductID;
    
END **

CALL averageSales(8, 2018);

#Create a stored procedure to retrieve table having order detail with status for a given period. 
#Start date and end date will be input parameter. 
#Put validation on input dates like start date is less than end date. 
#If start date is greater than end date take first date of month as start date.

#Checks if start date comes before end date. 
#If not the set start date to first day of the month.
DELIMITER $$ 
CREATE FUNCTION validateDate(startDate Date,endDate Date)
RETURNS DATE

BEGIN
  
    DECLARE setStartDate DATE;
  
    IF (startDate < endDate)
        THEN
        RETURN startDate;
                
    ELSE
        SET setStartDate = DATE_ADD(DATE_ADD(LAST_DAY(endDate), INTERVAL 1 DAY), INTERVAL - 1 MONTH);
        RETURN setStartDate;
    END IF;

END$$

DELIMITER $$
CREATE PROCEDURE ordersBetween(startDate DATE, endDate DATE) 

BEGIN

    SET startDate = validateDate(startDate, endDate);

    SELECT ID, UserID, PlacedDate
    FROM Orders 
    WHERE PlacedDate BETWEEN startDate AND endDate;


END $$

CALL ordersBetween('2018-08-21', '2018-08-18');
