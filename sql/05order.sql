#ORDER BY : 조회 결과 순서 결정

# 고객번호 이름 오름차순.
SELECT *
from Customers
ORDER BY CustomerName;

#연습 : 상품 가격 오름차순으로 조회
SELECT *
FROM Products
ORDER BY Price;

SELECT CustomerName, City, Country
FROM Customers
ORDER BY Country, City;

# 연습 : 카테고리별,가격별 오름차순 상품 조회
SELECT *
FROM Products
ORDER BY Products.CategoryID, price;

#기본은 오름차순(ASCENDING, ASC)이고
SELECT *
FROM Products
ORDER BY CategoryID ASC, price ASC;

# 내림차순으로 조회하고싶으면 ?ㅇ
SELECT *
FROM Products
ORDER BY CategoryID DESC, price DESC;

# 연습 : 생일 역순 직원 조회
SELECT *
FROM Employees
ORDER BY BirthDate DESC;

#카테고리 오름차순,가격내림차순 순서로 상품조회
SELECT *
FROM Products
ORDER BY CategoryID, Price DESC;

#
SELECT Country, City, CustomerName
FROM Customers;

# 컬럼의 순서 사용
SELECT Country, City, CustomerName
FROM Customers
ORDER BY 1, 2;

SELECT Products.ProductName, CategoryID, Price
FROM Products
ORDER BY Price DESC;

SELECT Products.ProductName, CategoryID, Price
FROM Products
ORDER BY 3 DESC;





