use store_front;
#Consider a form where providing a Zip Code populates associated City and State.

CREATE TABLE Zipcode(
pin_code INT PRIMARY KEY,
city VARCHAR(25) NOT NULL ,
state VARCHAR(25) NOT NULL 
);
 INSERT INTO zipcode(pin_code,city,state)
VALUES(301001,"Alwar","Rajasthan"),
      (302001,"Jaipur","Rajasthan"),
      (400099,"Mumbai","Maharastra"),
      (380001, "Ahemdabad", "Gujrat");
      
SELECT pin_code , city , state
FROM Zipcode
ORDER BY state, city;
