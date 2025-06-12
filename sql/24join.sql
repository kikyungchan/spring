USE mydatabase;

CREATE TABLE table38
(
    id INT
);

INSERT INTO table38
    (id)
values (9),
       (8),
       (7);

SELECT *
FROM table34;
SELECT *
FROM table35;
SELECT *
FROM table38;

SELECT *
FROM table34
         JOIN table35
         JOIN table38;

SELECT *
FROM w3schools.Products p
         JOIN w3schools.Categories c
         JOIN w3schools.Suppliers s
WHERE p.CategoryID = c.CategoryID
  AND p.SupplierID = s.SupplierID;

SELECT *
FROM w3schools.Products p
         JOIN w3schools.Categories c
              ON p.CategoryID = c.CategoryID
         JOIN w3schools.Suppliers s
              ON p.SupplierID = s.SupplierID;

#카테고리별 공급자 정보
SELECT c.CategoryName, s.SupplierName
FROM w3schools.Products p
         JOIN w3schools.Categories c
              ON p.CategoryID = c.CategoryID
         JOIN w3schools.Suppliers s
              ON p.SupplierID = s.SupplierID
ORDER BY c.CategoryName;

# 공급자별 공급하는 상품 카테고리

SELECT DISTINCT s.SupplierName, c.CategoryName
FROM w3schools.Products p
         JOIN w3schools.Categories c
              ON p.CategoryID = c.CategoryID
         JOIN w3schools.Suppliers s
              ON p.SupplierID = s.SupplierID
ORDER BY s.SupplierName;

SELECT DISTINCT s.ShipperName, c.CustomerName
FROM w3schools.Orders o
         JOIN w3schools.Customers c
              ON o.CustomerID = c.CustomerID
         JOIN w3schools.Shippers s
              ON o.ShipperID = s.ShipperID
ORDER BY s.ShipperName, c.CustomerName;

#1996-07-05에 주문된 상품명 목록
SELECT o.OrderDate, p.ProductName
FROM w3schools.Orders o
         JOIN w3schools.OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN w3schools.Products p
              ON od.ProductID = p.ProductID
WHERE o.OrderDate = '1996-07-05';

#연습
#Tofu 상품을 언제 누가주문했는지 조회 (프로덕트,오더즈,커스터머,오더디테일즈)
SELECT p.ProductName, o.OrderDate, c.CustomerName, od.Quantity
FROM w3schools.Products p
         JOIN w3schools.OrderDetails od
              ON p.ProductID = od.ProductID
         JOIN w3schools.Orders o
              ON od.OrderID = o.OrderID
         JOIN w3schools.Customers c
              ON o.CustomerID = c.CustomerID
WHERE p.ProductID = 14;
#조건에 사용되는 컬럼들은 PK 사용할 수록 성능이 좋음.
# WHERE p.ProductName = 'Tofu';

#연습
#우수고객 선정 조회
#고객별(customers) 주문(orders) 금액(price) orderdetail
SELECT c.CustomerName, SUM(od.Quantity * p.Price) 합
FROM w3schools.Orders o
         JOIN w3schools.OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN w3schools.Products p
              ON p.ProductID = od.ProductID
         JOIN w3schools.Customers c
              ON o.CustomerID = c.CustomerID
GROUP BY c.CustomerID
ORDER BY 합 DESC;

#이번달 우수직원
#1997-09 월에 가장 많은 주문(가격기준)을 처리한 직원 조회
# 임플로이 가격? 프로덕트 오더즈 오더디테일
SELECT e.LastName, e.FirstName, SUM(od.Quantity * p.Price) 합
FROM w3schools.Employees e
         JOIN w3schools.Orders o
              ON e.EmployeeID = o.EmployeeID
         JOIN w3schools.OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN w3schools.Products p
              ON od.ProductID = p.ProductID
WHERE o.OrderDate BETWEEN '1997-09-01' AND '1997-09-30'
GROUP BY e.EmployeeID, e.LastName, e.FirstName
ORDER BY 합 DESC;















