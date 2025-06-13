#포린키 외국키 외국열쇠
USE w3schools;

create table w3schools.Products
(
    ProductID   int auto_increment
        primary key,
    ProductName varchar(255)   null,
    SupplierID  int            null,
    CategoryID  int            null,
    Unit        varchar(255)   null,
    Price       decimal(10, 2) null
);

ALTER TABLE Products
    ADD FOREIGN KEY (CategoryID) REFERENCES Categories (CategoryID);


create table w3schools.Products
(
    ProductID   int auto_increment
        primary key,
    ProductName varchar(255)   null,
    SupplierID  int            null,
    CategoryID  int            null,
    Unit        varchar(255)   null,
    Price       decimal(10, 2) null,
    constraint Products_ibfk_1
        foreign key (CategoryID) references w3schools.Categories (CategoryID)
);

create index CategoryID
    on w3schools.Products (CategoryID);

#products 테이블 supplierid가 suppliers의 supplierid를
# 참조하는 외래키가 되도록 alter table실행
# 다이어그램보기\
ALTER TABLE w3schools.Products
    ADD FOREIGN KEY (SupplierID) REFERENCES Suppliers (SupplierID);

create table w3schools.Products
(
    ProductID   int auto_increment
        primary key,
    ProductName varchar(255)   null,
    SupplierID  int            null,
    CategoryID  int            null,
    Unit        varchar(255)   null,
    Price       decimal(10, 2) null,
    constraint Products_ibfk_1
        foreign key (CategoryID) references w3schools.Categories (CategoryID),
    constraint Products_ibfk_2
        foreign key (SupplierID) references w3schools.Suppliers (SupplierID)
);

create index CategoryID
    on w3schools.Products (CategoryID);

create index SupplierID
    on w3schools.Products (SupplierID);

ALTER TABLE OrderDetails
    ADD FOREIGN KEY (OrderID) REFERENCES Orders (OrderID);

ALTER TABLE OrderDetails
    ADD FOREIGN KEY (ProductID) REFERENCES w3schools.Products (ProductID);

ALTER TABLE Orders
    ADD FOREIGN KEY (CustomerID) REFERENCES Customers (CustomerID);

ALTER TABLE Orders
    ADD FOREIGN KEY (EmployeeID) REFERENCES Employees (EmployeeID);

ALTER TABLE Orders
    ADD FOREIGN KEY (ShipperID) REFERENCES Shippers (ShipperID);




