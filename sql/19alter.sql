USE mydatabase;
CREATE TABLE table22
(
    col1 INT         NOT NULL,
    col2 varchar(10) NOT NULL
);

INSERT INTO table22
    (col1, col2)
VALUES (3, 'son');

INSERT INTO table22
    (col1, col2)
VALUES (5, 'lee');

SELECT *
FROM table22;

#ALTER TABLE : 테이블 수정
# 컬럼 추가
# 컬럼 TYPE 제약사항 변경
# 컬럼명 변경

ALTER TABLE table22
    ADD COLUMN col3 DATETIME NOT NULL DEFAULT NOW();

ALTER TABLE table22
    ADD COLUMN col4 INT;

ALTER TABLE table22
    ADD COLUMN col5 INT NOT NULL;

ALTER TABLE table22
    ADD COLUMN col6 varchar(10) NOT NULL;

ALTER TABLE table22
    ADD COLUMN col7 varchar(10) NOT NULL UNIQUE;

ALTER TABLE table22
    ADD COLUMN col8 INT;

ALTER TABLE table22
    ADD COLUMN col9 INT
        AFTER col1;

ALTER TABLE table22
    ADD COLUMN col10 INT
        FIRST;

SELECT *
FROM table22;

DESC table22;

#연습
#table22에 새로운 컬럼 2개 추가

ALTER TABLE table22
    ADD COLUMN col11 varchar(255) NOT NULL;

ALTER TABLE table22
    ADD COLUMN col12 INT NOT NULL
        First;

# 컬럼명 변경
CREATE TABLE table23
(
    col1 INT,
    col2 varchar(10)
);

ALTER TABLE table23
    CHANGE COLUMN col1 col11 INT;

ALTER TABLE table23
    CHANGE COLUMN col11 col21 INT NOT NULL;

ALTER TABLE table23
    CHANGE COLUMN col21 col31 varchar(10) NOT NULL;

ALTER TABLE table23
    MODIFY COLUMN col31 INT NOT NULL UNIQUE;

#연습
# table23 col2 의 타입을 DEC(10,2) . NOT NULL UNIQUE 로
ALTER TABLE table23
    MODIFY COLUMN col2 DEC(10, 2) NOT NULL UNIQUE;

CREATE TABLE table24
(
    col1 varchar(5),
    col2 bigint
);

INSERT INTO table24
    (col1, col2)
VALUES ('abcde', 40000000000);
INSERT INTO table24
    (col1, col2)
VALUES ('abcde', 40000000000);


ALTER TABLE table24
    MODIFY Column col1 varchar(3);
ALTER TABLE table24
    MODIFY Column col1 varchar(10);
ALTER TABLE table24
    MODIFY Column col1 varchar(10) unique ;
ALTER TABLE table24
    MODIFY Column col2 INT;

DESC table24;

SELECT *
FROM table24;

