#table을 만드는 방법.
#DATABASE : 테이블을 모아놓은 공간
    #CREATE DATABASE : 데이터베이스 만들기
CREATE DATABASE mydatabase;

# database(schema) 사용하기
USE mydatabase;


#CREATE TABLE : 테이블 만들기
CREATE TABLE table1
(
    id int
);

#DROP TABLE : 테이블 삭제하기(매우주의!!!!!)
DROP TABLE table1;

USE mydatabase;
USE w3schools;

SELECT *
FROM Customers;

SELECT *
FROM w3schools.Customers;

#테이블만들기
CREATE TABLE table2
(
    #둥근 괄호 안에서 컬럼명 나열.
    name    varchar(255),
    country varchar(255),
    phone   varchar(255)
);

INSERT INTO table2
    (name, country, phone)
values ('트럼프', '미국', '2323');

SELECT *
FROM table2;


# 테이블명과, 컬럼명 작성 규칙
# 소문자, _ 조합 (lower_snake_case) 로워 스네이크 케이스

CREATE TABLE my_table1
(
    name            VARCHAR(255),
    address         VARCHAR(255),
    last_name       VARCHAR(255),
    home_address    varchar(255),
    my_work_address varchar(255)
);

#연숩
#id,name,address, team, table3만들기
CREATE TABLE table3
(
    id      varchar(255),
    name    varchar(255),
    address varchar(255),
    team    varchar(255)
);

INSERT INTO table3
    (id, name, address, team)
values ('1', '손흥민', '런던', '토트넘');


INSERT INTO table3
    (id, name, address, team)
values ('2', '메시', '아르헨티나', 'FC바르셀로나');

SELECT *
FROM table3;

#DROP TABLE : 테이블 삭제하기
DROP TABLE my_table1;
DROP TABLE table3;











