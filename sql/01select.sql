# sql 주석
# 실생 되지 않는 코드
# 설명용으로 사용
# ctrl /  주석단축키

SELECT *
FROM Customers;

#ctrl 엔터 =
# 쿼리(명령문)(sql) 실행
# 한 명령문(쿼리)는 ; 으로 끝남

SELECT *
FROM Employees;

# 쿼리 대소문자 구분안함
SELECT *
FROM Employees;

select *
from Employees;

#키워드는 대문자,
# 테이블, 컬럼명은 소문자
SELECT *
FROM Employees;

# SELECT , FROM
SELECT *
FROM Employees;

SELECT *
FROM Categories;

SELECT *
FROM Suppliers;

# 데이터들은 행과 열의 조합으로 저장되어 있다.
# 테이블 : 행과 열의 조합으로 데이터를 저장한 곳

# Employees
# 9행 6열
SELECT *
FROM Employees;
#Categories
# 8행 3열
SELECT *
FROM Categories;
# Shippers
# 3행, 3열
SELECT *
FROM Shippers;
# SELECT : 열을 선택
# FROM : 테이블 지정
# WHERE :  행을 선택(filter)
SELECT *
FROM Shippers;
SELECT *
FROM Customers;
SELECT *
From Employees;

SELECT *
FROM Products
limit 1;




