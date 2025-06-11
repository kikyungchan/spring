USE mydatabase;
#Key: 각 레코드를 구분하는 컬럼들
#Primary Key : 대표키 주요키
## UNIQUE
## NOT NULL
## 변경되지 말아야함
## INSERT 할 떄 결정되어야 함
## 대부분의 테이블에 의미없는 id컬럼 (INT PRIMARY NOT NULL UNIQUE AUTO_INCREMENT)으로 추가 됨

CREATE TABLE table30
(
    name    varchar(20),
    address varchar(20),
#     phone   varchar(20) UNIQUE NOT NULL
     phone   varchar(20) PRIMARY KEY
);
DROP TABLE table30;
DESC table30;

CREATE TABLE table31
(
    name    varchar(20),
    address varchar(20),
    phone   varchar(20),
    primary key (phone)
);
DESC table31;


CREATE TABLE table32
(
    name    varchar(20),
    address varchar(20),
    notes   varchar(20),
    PRIMARY KEY (name, address)
);

DESC table32;

CREATE TABLE table33
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    number  varchar(13) NOT NULL UNIQUE ,
    name    varchar(20),
    address varchar(30)
);
INSERT INTO table33
    (number, name, address)
VALUES ( '3-3', 'son', 'seoul');
INSERT INTO table33
(number, name, address)
VALUES ('4-4', 'lee', 'seoul');
INSERT INTO table33
(number, name, address)
VALUES ('5-4', 'lee', 'seoul');

SELECT *
FROM table33;


DROP TABLE table33;






