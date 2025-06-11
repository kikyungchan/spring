USE mydatabase;

# 제약사항(Constraint) : 컬럼에 입력 가능한 값을 제한 하는 키워드

# NOT NULL : null 허용 않함

    # NOT NULL

# Primary Key : 주요 키.(PK)
# Foreign Key : 외래 키(FK) 참조키
CREATE TABLE table14
(
    col1 INT,
    col2 INT NOT NULL #null 허용안됨
);

INSERT INTO table14
    (col1,col2)
VALUES (1,null);

SELECT *
FROM table14;

#연습
#(name varchar), (address varchar)table 15 만들기

CREATE TABLE table15
(
    name    varchar(255) NOT NULL,
    address varchar(255)

);

INSERT INTO table15
    (name,address)
VALUES ('안널','주소123');

SELECT *
FROM table15;

# DEFAULT: 값 안주면 기본값
CREATE TABLE table16
(
    col1 varchar(10),
    col2 varchar(10) DEFAULT 'anonymous'
);

INSERT INTO table16
    (col1, col2)
VALUES ('abc', 'def');

INSERT INTO table16
(col1, col2)
VALUES ('abc', NULL);



SELECT *
FROM table16;

CREATE TABLE table17
(
    col1 varchar(10)          default 'val1',
    col2 varchar(10) NOT NULL default 'var2'
);

INSERT INTO table17
    (col1, col2)
VALUES ('abc', 'def');

INSERT INTO table17
(col1, col2)
VALUES (NULL, 'def');

INSERT INTO table17
(col1, col2)
VALUES ('abc', NULL);

INSERT INTO table17
(col2)
VALUES ('zxc');

INSERT INTO table17
(col1)
VALUES ('pipu');

SELECT *
FROM table17;

#연습
    #table18
CREATE TABLE table188
(
    name  varchar(200) NOT NULL DEFAULT 'anonymous',
    score INT          NOT NULL DEFAULT 0
);

INSERT INTO table18
    (name, score)
VALUES ('asd', 2);

INSERT INTO table18
(name)
VALUES ('asd');

INSERT INTO table18
(score)
VALUES (0);

INSERT INTO table188
(score)
VALUES (0);

SELECT *
FROM table18;

SELECT *
FROM table188;

# UNIQUE : 중복허용 않함

CREATE TABLE table19
(
    col1 varchar(10),
    col2 varchar(10) UNIQUE);

INSERT INTO table19
    (col1, col2)
VALUES ('abd', 'def');

INSERT INTO table19
(col1, col2)
VALUES ('abd', 'qwe');

INSERT INTO table19
(col1, col2)
VALUES ('iup', 'qwe');
#듑났다듑났다듑났다듑나(중복됐다)
INSERT INTO table19
(col1)
VALUES ('iup');

INSERT INTO table19
(col1)
VALUES ('ㅁㄴㅇ');

SELECT *
FROM table19;

CREATE TABLE table20
(
    col1 varchar(3),
    col2 varchar(3) NOT NULL UNIQUE
);

INSERT INTO table20
    (col1, col2)
VALUES ('abc', 'def');

INSERT INTO table20
(col1, col2)
VALUES ('abc', 'qwe');

INSERT INTO table20
(col2)
VALUES ('def');

INSERT INTO table20
(col1)
VALUES ('adsa');

INSERT INTO table20
(col2)
VALUES ('qwe');

SELECT *
FROM table19;

CREATE TABLE table21
(
    name  varchar(200) NOT NULL UNIQUE,
    score INT          NOT NULL default 0
);

INSERT INTO table21
    (name, score)
VALUES ('ㅁㄴ대', 1234);

INSERT INTO table21
(name)
VALUES ('개졸려');

select *
FROM table21;

# 테이블의 구조 보기
DESCRIBE table21;

DESC w3schools.Products;

SHOW CREATE TABLE w3schools.Products;



