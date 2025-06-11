USE mydatabase;

# NORMALIZATION : 정규화 정규형 규형이형

# FIRST NORMAL FORM (1NF) : 1정규형 정규화
# SECOND NORMAL FORM (2NF) : 2정규형
# THIRD NORMAL FORM (3NF) : 3정규형

# 1NF
# 모든 레코드가 유일해야하고
    #->PRIMARY KEY(UNIQUE NOT NULL) 컬럼이 적어도 하나 이써야함
    #유일한 정보를 저장할 수 있는 컬럼을 만들어서 추가.
# 모든 데이터는 atomic(원자적)해야한다.

CREATE TABLE table25
(
    name  varchar(10),
    phone varchar(200)
);
INSERT INTO table25
    (name, phone)
VALUES ('son', '01099998888');
INSERT INTO table25
(name, phone)
VALUES ('lee', '01099997777,01088886666');
select *
from table25;

CREATE TABLE table26
(
    name   varchar(10),
    phone1 varchar(11),
    phone2 varchar(11)
);

INSERT INTO table26
    (name, phone1)
VALUES ('son', '01099998888');
INSERT INTO table26
    (name, phone1, phone2)
VALUES ('kim', '01088888777', '01055553333');

SELECT *
FROM table26;

ALTER TABLE table26
    ADD COLUMN address varchar(10) after name;
UPDATE table26
SET address = 'seoul'
WHERE name = 'son';
UPDATE table26
SET address = 'busan'
WHERE name = 'kim';

CREATE TABLE table27
(
    name  varchar(10),
    phone varchar(11)
);
INSERT INTO table27
    (name, phone)
VALUES ('son', '01099998888'),
       ('kim', '01088888777'),
       ('kim', '01055553333');

SELECT *
FROM table27;
SELECT *
FROM table26;
ALTER TABLE table26
    DROP column phone1;
ALTER TABLE table26
    DROP column phone2;
SELECT *
FROM table26;

CREATE TABLE table28
(
    name    varchar(10),
    address varchar(10),
    work    varchar(10)
);

INSERT INTO table28
    (name, address, work)
VALUES ('kim', 'seoul', 'intel');
INSERT INTO table28
(name, address, work)
VALUES ('lee', 'busan', 'intel');
INSERT INTO table28
(name, address, work)
VALUES ('choi', 'seoul', 'tesla');
INSERT INTO table28
(name, address, work)
VALUES ('kim', 'jeju', 'google');
INSERT INTO table28
(name, address, work)
VALUES ('kim', 'jeju', 'google');

ALTER TABLE table28
ADD COLUMN id INT NOT NULL UNIQUE;

SELECT *
FROM table28;

CREATE TABLE table29
(
    id      INT NOT NULL UNIQUE,
    name    varchar(20),
    address varchar(20),
    work    varchar(20)
);

DESC table29;






