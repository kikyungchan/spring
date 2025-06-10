SELECT COUNT(*)
FROM Customers;

#INSERT INTO : # 새 데이터(record, row)입력
INSERT INTO Customers
(CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country)
Values ('92', 'donald', 'trump', 'new york', 'CA', '1234', 'USA');

INSERT INTO Customers
(CustomerID, CustomerName, ContactName, Address, PostalCode, Country, City)
Values ('93', 'elon', 'musk', 'LA', 'texas', '5678', 'USA');

INSERT INTO Customers
(CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country)
Values (94, 'park', 'jisung', 'suwon', 'suwon', '9090', 'korea');

SELECT *
FROM Customers
ORDER BY CustomerID DESC;

#Categories 테이블에 새 레코드 2개 입력해보기
INSERT INTO Categories
    (CategoryID, CategoryName, Description)
values ('9', 'son', 'cake');

INSERT INTO Categories
    (CategoryID, CategoryName, Description)
values ('10', 'park', 'cheese');



#Products 테이블에 새 레이드 2개 입력해보기
INSERT INTO Products
    (ProductID, ProductName, SupplierID, CategoryID, Unit, Price)
VALUES ('78', 'son', '5', '3', '35', '500');
INSERT INTO Products
    (ProductID, ProductName, SupplierID, CategoryID, Unit, Price)
VALUES ('79', 'park', '3', '5', '53', '300');

SELECT *
FROM Products
ORDER BY ProductID DESC;

INSERT INTO Customers
    (CustomerName)
VALUES ('손');

INSERT INTO Customers
    (CustomerName, ContactName)
VALUES ('트럼프', NULL);

INSERT INTO Customers
    (CustomerName, ContactName, Address)
VALUES ('트럼프', NULL, '');

SELECT *
FROM Customers
ORDER BY CustomerID DESC;

INSERT INTO Categories
    (CategoryName)
VALUES ('소능민');

INSERT INTO Categories
(CategoryName,Description)
VALUES ('소능민','');

SELECT *
FROM Categories
ORDER BY CategoryID DESC;

#DELETE : 기존 데이터(record, row) 삭제

#UPDATE : 기존 데이터 (record, row) 수정
