# ALIAS ((AS) : 별칭 주기
SELECT CustomerName, ContactName
FROM Customers;

SELECT CustomerName AS Name, ContactName AS Contact
FROM Customers;

#AS : 생략 가능
SELECT CustomerName Name, ContactName Contact
FROM Customers;

#컬럼에 병칭 주기
SELECT AVG(Price)
FROM Products;

SELECT AVG(Price) AS 평균
FROM Products;

SELECT AVG(Price) 평균
FROM Products;

SELECT AVG(Price) '평균 가격'
FROM Products;

SELECT AVG(Price) `평균 가격`
FROM Products;

# 테이블에 별칭 주기
SELECT p.ProductName, c.CategoryName
FROM Products AS p,
     Categories AS c;

SELECT p.ProductName, c.CategoryName
FROM Products p,
     Categories c;

#############################
#페이징연습용 쿼리
#############################
#대량의 고객 정보 입력
INSERT INTO Customers
(CustomerName, ContactName, Address, City, PostalCode, Country)
SELECT CustomerName, ContactName,
       Address, City, PostalCode, Country
FROM Customers;
SELECT COUNT(*)
FROm Customers;

#대량의 상품 정보 입력
INSERT INTO Products
    (ProductName, SupplierID, CategoryID, Unit, Price)
SELECT ProductName, SupplierID, CategoryID, Unit, Price
FROM Products;

SELECT COUNT(*)
FROM Products;
























