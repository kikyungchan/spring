# Like (~같은)
# % _ : wildcard 와일드카드

# %: 0개이상 아무거나
# _ : 1개 아무거나

# u로 시작하는 국가에 있는 고객들 조회
SELECT *
FROM Customers
WHERE Country Like 'u%'; #u로 시작하는 아무거나;

# a로 시작하는
SELECT *
FROM Customers
WHERE CustomerName LIKE 'a%';

# a로 시작하고 a로 끝남
SELECT *
FROM Customers
WHERE CustomerName LIKE 'a%a';

# 고객명에 to를 "포함"
SELECT *
FROM Customers
WHERE CustomerName LIKE '%to%';

# 10번대 고객들
SELECT *
FROM Customers
WHERE CustomerID LIKE '1_';

#1997년 12월에 주문한 주문들
SELECT *
FROM Orders
WHERE OrderDate LIKE '1997-12-__';

# 직원 설명(노트)에 college가 "포함"(%머시기%)된 직원들 조회
SELECT *
FROM Employees
WHERE Notes LIKE '%college%';

# "C로 시작"(C%)하는 직원이름 조회
SELECT *
FROM Products
WHERE ProductName LIKE 'C%'









