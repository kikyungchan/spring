USE mydatabase;

#STRING
#VARCHAR(길이)
CREATE TABLE table4
(
    col1 varchar(1),
    col2 varchar(3),
    col3 varchar(5)
);

INSERT INTO table4
    (col1, col2, col3)
VALUES ('a', 'abc', 'abcde');

INSERT INTO table4
    (col1, col2, col3)
VALUES ('ab', 'abc', 'abcde');

INSERT INTO table4
    (col1, col2, col3)
VALUES ('한', 'abc', 'abcde');

INSERT INTO table4
    (col1, col2, col3)
VALUES ('한글', 'abc', 'abcde');

SELECT *
FROM table4;

#연습
#table 5만들기
# id(최대8글자),name(최대20글자)
# 두 개의 레코드 입력(성공)
# 두 개의 레코드 입력(실패)
CREATE TABLE table5
(
    id   varchar(8),
    name varchar(20)
);

INSERT INTO table5
    (id, name)
VALUES ('정확히여덟글자임', '스무글자는너무길어서다못채움');

INSERT INTO table5
    (id, name)
VALUES ('여덟글자임정확히', '다못채움스무글자는너무길어서');

#id 최대길이 초과/ 인설트안됌
INSERT INTO table5
    (id, name)
VALUES ('ㅇ여덟글자임정확히', '다못채움스무글자는너무길어서');
#name 최대길이 초과/ 인설트안됌
INSERT INTO table5
    (id, name)
VALUES ('여덟글자임정확히', '다못채움스무글자는너무길어ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ서');

SELECT *
FROM table5;

#NUMBER
#INTEGER(소수점없는)
#DECIMAL(소수점있는)
CREATE TABLE table6
(
    col1 INT,
    col2 BIGINT #2^63-1
);

INSERT INTO table6
    (col1, col2)
VALUES (234234, 456456);

SELECT *
FROM table6;

INSERT INTO table6
    (col1, col2)
VALUES (2147483647, 2147483647);

INSERT INTO table6
    (col1, col2)
VALUES (2147483648, 2147483647);

#연습
#score(정수),length(큰정수) table7
CREATE TABLE table7
(
    score  INT,
    length BIGINT
);

INSERT INTO table7
    (score, length)
VALUES ('80', '8,000,000,000,000,000,000');

INSERT INTO table7
    (score, length)
VALUES ('70', '1000000000000000000');

INSERT INTO table7
    (score, length)
VALUES ('70', '1000000000000000000000000000000000');

SELECT *
FROM table7;


#DECIMAL(총길이, 소숫점이하길이)
CREATE TABLE table8
(
    col1 INT,
    col2 DECIMAL(5, 1),
    col3 DECIMAL(10, 3),
    col4 DEC(5, 1),
    col5 DEC(10, 3)
);

INSERT INTO table8
    (col1, col2, col3, col4, col5)
VALUES (2342, 1234.5, 1234567.123, null, null);

INSERT INTO table8
    (col1, col2, col3, col4, col5)
VALUES (2342, 1234.56, 1234567.1234, null, null);

INSERT INTO table8
    (col1, col2, col3, col4, col5)
VALUES (2342, 12345.56, 12345678.1234, null, null);

SELECT *
FROM table8;

#연습
#score(총길이 4,소수점2),money(총길이10,소숫점이하3) (table9)
#두 개 레코드 입력 성공
# 한 개 레코드 실패
CREATE TABLE table9
(
    score DEC(4, 2),
    money DEC(10, 3)
);

INSERT INTO table9
    (score, money)
VALUES (12.30, 12345367.123);

INSERT INTO table9
    (score, money)
VALUES (13.20, 1234.789);


SELECT *
FROM table9;

#DATE ,TIME

#날짜시간
CREATE TABLE table10
(
    col1 DATE,
    col2 TIME,
    col3 DATETIME
);

INSERT INTO table10
    (col1, col2, col3)
VALUES ('2025-06-11', '10:26:01', '2025-06-11 10:26:01');

SELECT *
FROM table10;

#연습
#birth_date(날짜), work_time(시간), born(날짜시간) table 11
CREATE TABLE table11
(
    birth_date DATE,
    work_time  TIME,
    born       DATETIME
);

INSERT INTO table11
    (birth_date, work_time, born)
VALUES ('1995-04-17', '10:30:00', '1995-04-17 10:30:00');

INSERT INTO table11
(birth_date, work_time, born)
VALUES ('1960-06-25', '10:30:00', '1960-06-25 10:30:00');

SELECT *
FROM table11;

#STRING : VARCHAR(길이)
#NUMBER : INT, BIGINT ,DEC(총길이,소수점이하길이)
#날짜시간 : DATE , TIME, DATETIME

CREATE TABLE table12
(
    col1 VARCHAR(10),
    col2 INT,
    col3 BIGINT,
    col4 DEC(10, 2),
    col5 DATE,
    col6 TIME,
    col7 DATETIME
);

INSERT INTO table12
    (col1, col2, col3, col4, col5, col6, col7)
VALUES ();

SELECT *
FROM table12;

CREATE TABLE table13
(
    name       VARCHAR(10),
    birth_date DATE,
    score      DEC(5, 2),
    born_at    DATETIME
);

SELECT *
FROM table13




