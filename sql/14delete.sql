# DELETE : 특정 행(row,record)를 삭제
DELETE
FROM Customers
WHERE CustomerID = 107;

SELECT *
FROM Customers
WHERE Country IS NULL;

DELETE
FROM Customers
WHERE Country IS NULL;

# 명심 : 지우기 전에 꼭 같은 WHERE절로 SELECT 해보기 #

SELECT *
FROM Customers
WHERE CustomerID = 103;

DELETE
FROM Customers
WHERE CustomerID = 103;

SELECT *
From Customers
ORDER BY CustomerID DESC;

# WHERE 절 없이 삭제하면 모든 레코드가 삭제됨
SELECT *
FROM Customers;

DELETE
FROM Customers;

#연습
#공급자 테이블에서
#28번 29번 공급자 삭제하기
DELETE
FROM Suppliers
WHERE SupplierID = 29;

DELETE
FROM Suppliers
WHERE SupplierID = 28;

DELETE
FROM Suppliers;

SELECT *
FROM Suppliers;
