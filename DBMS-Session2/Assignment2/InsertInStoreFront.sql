use store_front;

#1
INSERT INTO User(EmailId, FirstName, LastName, Password, Phone) VALUES 
("deekshika.sharma@gmail.com", "Deekshika", "Sharma", "deekshika", "1234567893");

INSERT INTO User(EmailId, FirstName, LastName, Password, Phone) VALUES 
("deekshika.sharma19@gmail.com", "Deekshika", "Sharma", "deekshika123", "7489246555");

INSERT INTO Address(Street, Landmark, City, State, PinCode, UserId) VALUES 
("house no. 10, thakur wala kua", "Ashoka", "Alwar", "Rajasthan", "301001", 1);

INSERT INTO Address(Street, Landmark, City, State, PinCode, UserId) VALUES 
("flat no. 16, ring road", "near jail circle", "Alwar", "Rajasthan", "301001", 1);

INSERT INTO Address(Street, Landmark, City, State, PinCode, UserId) VALUES 
("flat no. 8, india gate", "near global circle", "Jaipur", "Rajasthan", "301002", 2);

INSERT INTO Address(Street, Landmark, City, State, PinCode, UserId) VALUES 
("flat no. 8, bohra hostel", "malviya nagar", "Jaipur", "Rajasthan", "301002", 2);

INSERT INTO Role(Name) VALUES("Administrator");

INSERT INTO Role(Name) VALUES("User");

INSERT INTO RoleRelation(UserId, RoleId) VALUES(1, 1);

INSERT INTO RoleRelation(UserId, RoleId) VALUES(2, 2);

INSERT INTO Product(Name, Price, Description, Stock) VALUES
("Redmi 5", 10000.0, "A phone with nice camera", 100);

INSERT INTO Product(Name, Price, Description, Stock) VALUES
("Mi y2", 12099.99, "A phone with nice camera and music system", 100);

INSERT INTO Category(Name, ParentCategoryId) VALUES
("Electronics", 0);

INSERT INTO Category(Name, ParentCategoryId) VALUES
("Mobiles", 1);

INSERT INTO Category(Name, ParentCategoryId) VALUES
("Laptop", 1);

INSERT INTO Category(Name, ParentCategoryId) VALUES
("Home Appliances", 0);

INSERT INTO Category(Name, ParentCategoryId) VALUES
("Televisions", 4);

INSERT INTO Category(Name, ParentCategoryId) VALUES
("Air conditioners", 4);

INSERT INTO Image(URL, Text, ProductId) VALUES
("www.imageMobile1.bnj.in", "Mobile image1", 1);

INSERT INTO Image(URL, Text, ProductId) VALUES
("www.imageMobile2.bnj.in", "Mobile image2", 1);

INSERT INTO ProductCategoryRelation(CategoryId, ProductId) VALUES
(2, 1);

INSERT INTO ProductCategoryRelation(CategoryId, ProductId) VALUES
(2, 2);

INSERT INTO Orders(PlacedDate, UserId, AddressId) VALUES
(CURDATE(), 1, 1);

INSERT INTO Orders(PlacedDate, UserId, AddressId) VALUES
(CURDATE(), 1, 2);

INSERT INTO Orders(PlacedDate, UserId, AddressId) VALUES
("2018-07-15", 2, 1);

INSERT INTO Orders(PlacedDate, UserId, AddressId) VALUES
("2018-08-5", 2, 1);

INSERT INTO OrderProductRelation(OrderId, ProductId, Status, DeliveryDate, ShipDate, Quantity) VALUES
(4, 1, "Order Placed", "2018-08-20", "2018-08-18", 2);

INSERT INTO OrderProductRelation(OrderId, ProductId, Status, DeliveryDate, ShipDate, Quantity) VALUES
(4, 2, "Order Placed", "2018-08-20", "2018-08-18", 3);

INSERT INTO OrderProductRelation(OrderId, ProductId, Status, DeliveryDate, ShipDate, Quantity) VALUES
(1, 1, "Shipped", "2018-08-20", "2018-08-16", 2);

INSERT INTO OrderProductRelation(OrderId, ProductId, Status, DeliveryDate, ShipDate, Quantity) VALUES
(1, 2, "Shipped", "2018-08-20", "2018-08-16", 3);

INSERT INTO OrderProductRelation(OrderId, ProductId, Status, DeliveryDate, ShipDate, Quantity) VALUES
(2, 2, "Order Placed", "2018-08-22", "2018-08-19", 1);

INSERT INTO OrderProductRelation(OrderId, ProductId, Status, DeliveryDate, ShipDate, Quantity) VALUES
(2, 1, "Order Placed", "2018-08-26", "2018-08-23", 2);

INSERT INTO OrderProductRelation(OrderId, ProductId, Status, DeliveryDate, ShipDate, Quantity) VALUES
(3, 2, "Order Placed", "2018-08-22", "2018-08-19", 1);

INSERT INTO OrderProductRelation(OrderId, ProductId, Status, DeliveryDate, ShipDate, Quantity) VALUES
(3, 1, "Order Placed", "2018-08-26", "2018-08-23", 2);