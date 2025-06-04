#OR
SELECT *
FROM Customers
WHERE City = 'Barcelona'
   OR City = 'Bern'
   OR City = 'Lisboa';

#IN
SELECT *
FROM Customers
WHERE City IN ('Barcelona', 'Bern', 'Lisboa');
# 연습IN
# 미국 영국 스웨덴에 있는 고개들 조회
SELECT *
FROM Customers
WHERE Country IN ('USA', 'UK', 'sweden');
# 카테고리 ID가 1,2,5인 상품 조회
SELECT *
FROM Products
WHERE CategoryID IN (1, 2, 5);
#일본, 독일에 있는 공급자 조회
SELECT *
FROM Suppliers
WHERE Country IN ('JAPAN', 'GERMANY');
# And
SELECT *
FROM Products
WHERE Price >= 50
  AND Price <= 60;

#BETWEEN AND
SELECT *
FROM Products
WHERE Price BETWEEN 50 AND 60;
#비트윈은 두값을 모두 포함

#연습 : 1950년대에 태어난 직원조회
SELECT *
FROM Employees
WHERE BirthDate BETWEEN '1950-01-01' AND '1959-12-31';
#1997년7월에 주문한 주문 데이터 조회
SELECT *
FROM Orders
WHERE OrderDate BETWEEN '1997-07-01' AND '1997-07-31';










