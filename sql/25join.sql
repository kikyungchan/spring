USE mydatabase;
CREATE TABLE table39
(
    col1 INT
);
CREATE TABLE table40
(
    col_a INT
);

INSERT INTO table39
    (col1)
values (1),
       (2),
       (3),
       (4),
       (5);
INSERT INTO table40
    (col_a)
values (3),
       (4),
       (5),
       (6),
       (7),
       (8),
       (9);

# cartesian product
SELECT *
FROM table39
         JOIN table40;


# INNER JOIN
SELECT *
FROM table39
         JOIN table40 ON table39.col1 = table40.col_a;

# LEFT JOIN
SELECT *
FROM table39
         LEFT JOIN table40 ON table39.col1 = table40.col_a;

# RIGHT JOIN
SELECT *
FROM table39
         RIGHT JOIN table40 ON table39.col1 = table40.col_a;

ALTER TABLE table39
    add column name varchar(10);

SELECT *
FROM table39;

ALTER TABLE table40
    ADD COLUMN toy VARCHAR(10);

SELECT *
FROM table40;

#장난감이 있는 사람들
# inner join

#장난감이 있는 사람들+ 장난감 없는 사람들
SELECT *
FROM table39
         LEFT JOIN table40 ON table39.col1 = table40.col_a;

#장난감 없는 사람들
SELECT *
FROM table39
         LEFT JOIN table40 ON table39.col1 = table40.col_a
WHERE col_a IS NULL;

#주인이 없는 장난감
SELECT *
FROM table39
         RIGHT JOIN table40 ON table39.col1 = table40.col_a
WHERE col1 IS NULL;

#주문한 적 없는 고객들
SELECT *
FROM w3schools.Customers c
         LEFT JOIN w3schools.Orders o on c.CustomerID = o.CustomerID
WHERE OrderID IS NULL;

DELETE
FROM w3schools.Orders
WHERE EmployeeID IN (2, 3);

#주문을 처리한 적 없는 직원들 조회
SELECT e.EmployeeID, e.LastName, e.FirstName
FROM w3schools.Employees e
         RIGHT JOIN w3schools.Orders o on e.EmployeeID = o.EmployeeID
WHERE o.OrderID IS NULL;

#합집합(UNION)
SELECT table39.col1
FROM table39
UNION
SELECT table40.col_a
FROM table40;

SELECT *
FROM table39
         LEFT JOIN table40
                   ON table39.col1 = col_a
UNION
SELECT *

FROM table39
         RIGHT JOIN table40
                    ON table39.col1 = col_a;


#연습
DELETE
FROM w3schools.OrderDetails
WHERE ProductID IN (10, 20, 30, 40);
# 한 번도 주문된 적 없는 상품들 이름 조회
SELECT p.ProductID, p.ProductName
FROM w3schools.Products p
         LEFT JOIN w3schools.OrderDetails od
                   ON p.ProductID = od.ProductID
WHERE od.ProductID IS NULL;


SELECT p.ProductID, p.ProductName
FROM w3schools.Products p
         LEFT JOIN w3schools.OrderDetails od ON p.ProductID = od.ProductID
WHERE od.ProductID IS NULL;



















