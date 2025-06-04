#distinct : 조회 결과에서 중복 제거
SELECT Country
FROM Customers;

SELECT distinct Country
FROM Customers
ORDER BY Country;

SELECT distinct Country, City
FROM Customers
ORDER BY Country, City;

#공급자가 있는 국가들 중복없이abc순으로 조회
SELECT distinct Country
FROM Suppliers
ORDER BY Country;

#고객이 있는 도시들을 중복없이 abc순으로 조회
SELECT distinct City
FROM Customers
ORDER BY City;












