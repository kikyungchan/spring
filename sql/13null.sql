#NULL : 값이 없다

SELECT *
FROM Customers
ORDER BY CustomerID DESC;

#SUM, COUNT, MIN, MAX, AVG
#집계함수는 NULL을 집계에 포함하지 않음
SELECT COUNT(CustomerName)
FROM Customers;

SELECT COUNT(CustomerID)
FROM Customers;

SELECT COUNT(Customers.ContactName)
FROM Customers;

SELECT COUNT(Address)
FROM Customers;



INSERT INTO Products
    (ProductName)
VALUES ('커피');

INSERT INTO Products
    (ProductName)
VALUES ('컴퓨터');

#NULL인 컬럼 조회
SELECT *
FROM Customers
WHERE ContactName = 'musk'
ORDER BY CustomerID DESC;

SELECT *
FROM Customers
# WHERE ContactName=NULL
WHERE ContactName IS NULL
ORDER BY CustomerID DESC;

SELECT *
FROM Customers
# WHERE ContactName != NULL
WHERE ContactName IS NOT NULL
ORDER BY CustomerID DESC;

SELECT *
FROM Categories
WHERE Description IS NULL;

SELECT *
FROM Categories
WHERE Description IS NOT NULL;


SELECT *
FROM Products
ORDER BY ProductID DESC;

#3022.71
SELECT SUM(Price)
FROM Products;

#38.262152
SELECT AVG(Price)
FROM Products;

#37.317407
SELECT AVG(IFNULL(Price, 0))
FROM Products;

#IFNULL : 널인경우 다른 값으로 표기
SELECT ProductID,
       ProductName,
       SupplierID,
       IFNULL(CategoryID, '미정') CategoryID,
       IFNULL(Unit, '없다')       Unit,
       IFNULL(Price, 0)         Price
FROM Products
ORDER BY ProductID DESC;

#연습

#카테고리 테이블 조회, description이 null이면 '정해지지 않음'
SELECT CategoryID, CategoryName, IFNULL(Description, '정해지지 않음') Description
FROM Categories
ORDER BY CategoryID DESC ;

SELECT COUNT(IFNULL(Description,0))
FROM Categories;

# INSERT INTO Customers
# (CustomerName, ContactName, Address, City, PostalCode, Country)
# VALUES
#  INSERT INTO Suppliers
#  (SupplierName, ContactName, Address, City, PostalCode, Country, Phone) VALUES






