# 어그리게이트펑션 (그룹펑션) aggregate function(group function) : 집계함수 (그룹함수) 계산할때 사용하는ㅅ함수

#SUM(), COUNT(), MIN(), MAX(), AVG()

# SUM():합계

# 모든 상품의 가격의 합계
SELECT SUM(Price)
FROM Products;


#1번카테고리상품의 가격의 합계
SELECT SUM(Price)
FROM Products
WHERE CategoryID = 1;

#특정 주문 ID에 대해 주문된 상품 수
SELECT SUM(Quantity)
FROM OrderDetails
WHERE OrderID = 10248;

# 특정 상품의 주문 갯수
SELECT SUM(Quantity)
FROM OrderDetails
WHERE ProductID = 11;

#연습 : 3번 카테고리의 상품가격의 합
SELECT SUM(Price)
FROM Products
WHERE CategoryID = 3;

# COUNT(): 특정 컬럼의 데이터가 몇 개 인지
SELECT COUNT(Country)
FROM Customers
WHERE Country = 'uk';

#COUNT : 조회 결과 수
SELECT COUNT(*)
FROM Customers
WHERE Country = 'uk';

#ㅇ연습 : 미국에 사는 고객 수 조회
SELECT COUNT(*)
FROM Customers
WHERE Country = 'usa';
 #1950년대에 태어난 직원 수 조회
SELECT COUNT(*)
FROM Employees
WHERE BirthDate BETWEEN '1950-01-01' AND '1959-12-31';
# 2번 카테고리의 상품 수
SELECT COUNT(*)
FROM Products
WHERE CategoryID = 2;

SELECT COUNT(Country)
FROM Customers;

SELECT COUNT(DISTINCT Customers.Country)
FROM Customers;



SELECT Country
FROM Customers;


#MIN(): 특정 컬럼에서 가장 작은 값
#MAX(): 특정 컬럼에서 가장 큰 값

SELECT MIN(Price)
FROM Products;
SELECT MAX(Price)
FROM Products;
SELECT MIN(Employees.BirthDate)
FROM Employees;
SELECT MAX(Employees.BirthDate)
FROM Employees;
SELECT MIN(CustomerName)
FROM Customers;
SELECT MAX(CustomerName)
FROM Customers;

#1번 카테고리에서 가자 비싼 상품의 가격
SELECT MAX(Price)
FROM Products
WHERE CategoryID = 1;

#2번 카테고리에서 가장 저렴한 상품의 가격
SELECT MIN(Price)
FROM Products
WHERE CategoryID = 2;

(SELECT *
 FROM Products
 WHERE CategoryID = 1);


#AVG = 평균
SELECT AVG(Price)
FROM Products;


#2번카테고리 ㅏㅇ품 가격의 평균
SELECT AVG(Price)
FROM Products
WHERE CategoryID = 2;







