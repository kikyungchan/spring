#SELECT:조회할 열(columns) 지정
#FROM : 테이블명 ㅈㅓ장
# WHERE : 행(Records)를 필터링

# * : 모든 컬럼
SELECT *
FROM Customers;
# 지정된 컬럼
SELECT CustomerName
FROM Customers;

SELECT Customers.CustomerName, City, Country
FROM Customers;

#나열된 컬럼의 순서가 조회된 결과 순서와 같음.
SELECT Customers.Country, City, Customers.CustomerName
FROM Customers;

# 미국에 사는 고객 이름.국가.도시 조회
SELECT CustomerName, Country, City
FROM Customers
WHERE Country = 'USA';

# 연습 : 멕시코와 미국에 사는 고객들의 이름과 국가 도시 주소 조회
SELECT Customers.CustomerName, Customers.Country, Customers.City, Customers.Address
FROM Customers
WHERE Country = 'USA' || Country = 'Mexico';
#60년대 태어난 직워늘 생일, 이름(lastname,firstname) 조회
SELECT BirthDate, LastName, FirstName
FROM Employees
WHERE BirthDate BETWEEN '1960-01-01' AND '1969-12-31';
#가격 10에서 19까지 사이인 상품의 가격,상품명,카테고리번호 조회
SELECT Price, ProductName, CategoryID
FROM Products
WHERE Price BETWEEN 10 AND 19;








