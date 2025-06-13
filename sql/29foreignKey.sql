USE mydatabase;
# 게시물
# 제목, 본문, 작성일시,회원ID
CREATE TABLE table43
(
    id               INT PRIMARY KEY AUTO_INCREMENT,
    title            VARCHAR(255),
    content          VARCHAR(10000),
    create_at        DATETIME,
    table44_username VARCHAR(20),
    FOREIGN KEY (table44_username) REFERENCES table44 (username)
);

DROP TABLE table43;
DESC table43;

# 회원정보
# ID,PW,자기소개
CREATE TABLE table44
(
    username VARCHAR(20) PRIMARY KEY,
    password VARCHAR(20),
    notes    VARCHAR(5000)

);
# 1대1 n대1
# 1대1 (잘 보이진 않음)
# 직원정보
CREATE TABLE table45
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(20),
    hire_date DATE,
    school    VARCHAR(20),
    salary INT
);

#직언 연봉
CREATE TABLE table46
(
    id     INT PRIMARY KEY,
    salary INT,
    FOREIGN KEY (id) REFERENCES table45 (id)
);


#N대N 관계
#학생
CREATE TABLE table48
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20),
    info VARCHAR(20)

);
# n대n관계일땐 중간테이블이 있어야함.무적권
#수업정보
CREATE TABLE table47
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(20),
    schedule VARCHAR(20),
    info     VARCHAR(20)
);

#학생수업(연결,조인,중간 테이블)
CREATE TABLE table49
(
    table48_id INT,
    table47_id INT,
    PRIMARY KEY (table48_id, table47_id),
    FOREIGN KEY (table48_id) REFERENCES table46 (id),
    FOREIGN KEY (table47_id) REFERENCES table47 (id)
);

#작가정보 테이블
CREATE TABLE table50
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(20),
    age        INT,
    birth_date DATE
);


    #중간테이블(어떤책)
CREATE TABLE table51
(
    table50_id INT,
    table52_id INT,
    PRIMARY KEY (table50_id, table52_id),
    FOREIGN KEY (table50_id) REFERENCES table50 (id),
    FOREIGN KEY (table52_id) REFERENCES table52 (id)

);


        #책정보 테이블
CREATE TABLE table52
(
    id INt PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20),
    author VARCHAR(20),
    made_date DATE
)





