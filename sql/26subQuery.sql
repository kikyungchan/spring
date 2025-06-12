#sub query : 쿼리 안의 쿼리
USE mydatabase;

# 한 번도 주문된 적 없는 상품 목록
SELECT p.ProductID, p.ProductName
FROM w3schools.Products p
         LEFT JOIN w3schools.OrderDetails od ON p.ProductID = od.ProductID
WHERE od.ProductID IS NULL;

# 1.주문된 적 있는 상품 목로ㄱID
SELECT DISTINCT ProductID
FROM w3schools.OrderDetails;

# 2. 위 커리 결과에 없는 상품 ID 들
SELECT ProductID, ProductName
FROM w3schools.Products
WHERE ProductID NOT IN (SELECT DISTINCT ProductID
                        FROM w3schools.OrderDetails);

#  상품가 카테고리 정보 조회
SELECT Products.ProductID, ProductName, CategoryName
FROM w3schools.Products
         JOIN w3schools.Categories c on Products.CategoryID = c.CategoryID;

SELECT ProductID,
       ProductName,
       (SELECT CategoryName
        FROM w3schools.Categories c
        WHERE c.CategoryID = p.CategoryID) CategoryName
FROM w3schools.Products p;

# 연습 1996-08-01 에 주문을 처리한 직원명
SELECT o.OrderDate, e.FirstName, e.LastName
FROM w3schools.Employees e
         JOIN w3schools.Orders o
              ON e.EmployeeID = o.EmployeeID
WHERE OrderDate = '1996-08-01';

SELECT FirstName, LastName
FROM w3schools.Employees
WHERE EmployeeID IN (SELECT EmployeeID
                     FROM w3schools.Orders
                     WHERE OrderDate = '1996-08-01');

#연습
#상품의 평균가격보다 높은 상품들 조회
SELECT AVG(Price)
FROM w3schools.Products;

SELECT *
FROM w3schools.Products
WHERE Price > (SELECT AVG(Price)
               FROM w3schools.Products)
ORDER BY Price;


# 상품의 평균 가격이 50 이상인 카테고리 번호를 조회한다.
SELECT CategoryID, AVG(Price)
FROM w3schools.Products
GROUP BY CategoryID
HAVING AVG(Price) >= 50;

SELECT *
FROM (SELECT CategoryID, AVG(Price) avg
      FROM w3schools.Products
      GROUP BY CategoryID) p
WHERE avg >= 50;

#연습
#1996-09 월 평균 처리 금액 보다 높은 금액을 처리한 직원 목록

# 1996년 09월 평균 처리금액
SELECT e.LastName,e.FirstName
FROM w3schools.Employees e
         JOIN w3schools.Orders o
              ON e.EmployeeID = o.EmployeeID
         JOIN w3schools.OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN w3schools.Products p
              ON p.ProductID = od.ProductID
WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30'
GROUP BY e.EmployeeID
HAVING SUM(od.Quantity * p.Price) > (SELECT AVG(od.Quantity * p.Price)
                                     FROM w3schools.Orders o
                                              JOIN w3schools.OrderDetails od on o.OrderID = od.OrderID
                                              JOIN w3schools.Products p on od.ProductID = p.ProductID
                                     WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30')
ORDER BY e.EmployeeID;





















