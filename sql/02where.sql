#WHERE : 행(레코드, 데이터, record, row)을 선택(filter) 한

SELECT *
FROM Employees;

SELECT *
FROM Employees
WHERE EmployeeID = 3;

SELECT *
FROM Employees
WHERE EmployeeID < 4;

SELECT *
FROM Employees
WHERE BirthDate BETWEEN '1950-01-01' AND '1959-12-31';

SELECT *
FROM Employees
WHERE Notes LIKE '%BA%';

SELECT *
FROm Customers;

#연산자
# = : 같다
SELECT *
FROM Customers
WHERE Country = 'UK';

# 연습 미국 인 고객들 조회
SELECT *
FROM Customers
WHERE Country = 'USA';

#연습 특정 도시에 있는 고개들 조회
SELECT *
FROM Customers
WHERE City = 'São Paulo';

#비교 연산자
# != 같지 않다, <>
# >, >=, <, <=
SELECT *
FROM Customers
WHERE City != 'london';

SELECT *
FROM Customers
WHERE City <> 'london';

# 연습: 미국에 있지 않는 고객들 조회
SELECT *
FROM Customers
WHERE Country != 'USA';
# 스웨덴에 있지 않는 고객들 조회
SELECT *
FROM Customers
WHERE Country != 'sweden';

#>, >=, <, <=
SELECT *
FROM Customers
WHERE CustomerID < 5;

SELECT *
FROM Customers
WHERE CustomerID <= 5;

SELECT *
FROM Customers
WHERE CustomerID > 88;
SELECT *
FROM Customers
WHERE CustomerID >= 88;

SELECT *
FROM Customers
WHERE CustomerName >= 'T';

SELECT *
FROM Customers
WHERE CustomerName >= 't';

SELECT *
FROM Customers
WHERE CustomerName < 'D';

#연습:
#Products(상품) 테이블 조회
SELECT *
FROM Products;
#Price(가격)이 50미만인 상품들
#Price(가격)이 80 이상인상품도 조히
SELECT *
FROM Products
WHERE Price < 50 || Price >= 80 ;

# 주문 테이블 조회
SELECT *
FROM Orders;
#주문날짜가 1998년1월1일이후포함 인 데이터 조회
SELECT *
FROM Orders
WHERE OrderDate >= '1998-01-01' || OrderDate <= '1996-12-31';

# 논리 연산자
# AND, OR, NOT

#NOT
SELECT *
FROM Customers
WHERE City = 'berlin';

SELECT *
FROM Customers
WHERE City != 'berlin';

SELECT *
FROM Customers
WHERE NOT(City = 'berlin');

SELECT *
FROM Customers
WHERE NOT City = 'berlin';

# 연습 : 미국에 살지 않는 고객들 조회

SELECT *
FROM Customers
WHERE NOT (Country = 'USA');

# OR
SELECT *
FROM Customers
WHERE CustomerID = 1
   OR CustomerID = 2;

SELECT *
FROM Customers
WHERE CustomerID = 1
   || CustomerID = 2;

SELECT *
FROM Customers
WHERE Country = 'usa' || Country = 'UK';

#연습: CategoryID가 1또는 7인 상품들 ㅈ회
SELECT *
FROM Products
WHERE CategoryID = 1 || CategoryID = 7;
# 도시 Madrid 또는 Lisboa 에 있는 고객들 조회
SELECT *
FROM Customers
WHERE City = 'Madrid' || City = 'Lisboa';

#AND
SELECT *
FROM Customers
WHERE CustomerID >= 10 && CustomerID < 20;

#연습 : 1950=01-01 ~1959=12=31 사이의 태어난 직원들 조회
SELECT *
FROM Employees
WHERE BirthDate >= '1950-01-01' && BirthDate <= '1959-12-31';

#50.00~59.99 가격인 상품들 조회
SELECT *
FROM Products
WHERE Price >= 50 && Price < 60;
#B로 시작하는 이름인 고객들
SELECT *
FROM Customers
WHERE CustomerName >= 'B' && CustomerName < 'C';

SELECT *
FROM Customers
WHERE CustomerName >= 'B' && CustomerName < 'C' && Country = 'France';













#주문날짜가 199512얼31일 이전 포함인 데이터 조히









