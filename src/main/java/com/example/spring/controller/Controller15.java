package com.example.spring.controller;

import com.example.spring.dto.CustomerDto;
import com.example.spring.dto.ProductDto;
import com.example.spring.dto.SupplierDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main15")
public class Controller15 {
    //paging

    @GetMapping("sub1")
    //한 페이지에 10개씪
    public String sub1(@RequestParam(defaultValue = "1") Integer page, Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Customers
                ORDER BY CustomerID
                LIMIT ?, ?
                """;
        //총 고객수
        String countSql = """
                select count(*) AS count 
                from Customers
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connetion = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connetion.prepareStatement(sql);
        //offset : (page-1)*10
//        statement.setInt(1, 0); // 1page
//        statement.setInt(1, 10); // 2page
//        statement.setInt(1, 20); // 3page
        int offset = (page - 1) * 10;
        statement.setInt(1, offset);
        statement.setInt(2, 10);

        ResultSet rs2 = connetion.prepareStatement(countSql).executeQuery();
        rs2.next();
        int count = rs2.getInt("count"); // 총고객수
        int lastPage = (count - 1) / 10 + 1;
        model.addAttribute("lastPage", lastPage);

        ResultSet rs = statement.executeQuery();
        List<CustomerDto> list = new ArrayList<>();
        while (rs.next()) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(rs.getInt("CustomerId"));
            customerDto.setAddress(rs.getString("Address"));
            customerDto.setName(rs.getString("CustomerName"));
            customerDto.setContactName(rs.getString("ContactName"));
            customerDto.setCity(rs.getString("City"));
            customerDto.setCountry(rs.getString("Country"));
            customerDto.setPostalCode(rs.getString("PostalCode"));
            list.add(customerDto);
        }
        model.addAttribute("customerList", list);
        return "main15/sub1";
    }


    //연습:
    //한페이지에 5개의 공급자가 출력되도록 코드 작성.
    //request handler method, html
    @GetMapping("sub2")
    public String sub2(@RequestParam(defaultValue = "1") Integer page, Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Suppliers
                ORDER BY SupplierID
                LIMIT ?, ?
                """;
        //총 공급자 수
        String countSql = """
                select count(*) AS count 
                from Suppliers
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        int offset = (page - 1) * 5;
        statement.setInt(1, offset);
        statement.setInt(2, 5);

        ResultSet rs2 = connection.prepareStatement(countSql).executeQuery();
        rs2.next();
        int count = rs2.getInt("count"); // 총공급자 수
        int lastPage = (count - 1) / 5 + 1;
        model.addAttribute("lastPage", lastPage);

        ResultSet rs = statement.executeQuery();
        List<SupplierDto> Supplierlist = new ArrayList<>();
        while (rs.next()) {
            SupplierDto dto = new SupplierDto();
            dto.setSupplierId(rs.getInt("SupplierId"));
            dto.setSupplierName(rs.getString("SupplierName"));
            dto.setContactName(rs.getString("ContactName"));
            dto.setAddress(rs.getString("Address"));
            dto.setCity(rs.getString("City"));
            dto.setPost(rs.getString("PostalCode"));
            dto.setCountry(rs.getString("Country"));
            dto.setPhone(rs.getString("Phone"));
            Supplierlist.add(dto);
        }
        model.addAttribute("supplierList", Supplierlist);


        return "main15/sub2";
    }

    //검색 + 페이징
    @GetMapping("sub3")
    public String sub3(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "") String keyword,
                       Model model) throws Exception {
        String countSql = """
                SELECT COUNT(*) AS count
                FROM Customers
                WHERE CustomerName LIKE ?
                OR ContactName LIKE ?
                """;
        String sql = """
                SELECT *
                FROM Customers
                WHERE CustomerName LIKE ?
                OR ContactName LIKE ?
                ORDER BY CustomerID
                LIMIT ?, ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connetion = DriverManager.getConnection(url, username, password);
        PreparedStatement countStmt = connetion.prepareStatement(countSql);
        countStmt.setString(1, "%" + keyword + "%");
        countStmt.setString(2, "%" + keyword + "%");
        PreparedStatement selectStmt = connetion.prepareStatement(sql);
        selectStmt.setString(1, "%" + keyword + "%");
        selectStmt.setString(2, "%" + keyword + "%");

        int offset = (page - 1) * 5;
        selectStmt.setInt(3, offset);
        selectStmt.setInt(4, 5);

        ResultSet rs1 = countStmt.executeQuery();
        rs1.next();
        int count = rs1.getInt("count");//총레코드수
        int lastPage = (count - 1) / 5 + 1;//마지막페이지
        int rightPage = ((page - 1) / 10 + 1) * 10;// 오른쪽 페이지번호
        int leftPage = rightPage - 9;
        int prevPage = leftPage - 10;
        int nextPage = rightPage + 1;
        rightPage = Math.min(rightPage, lastPage); // 오른쪽 페이지번호는 마지막보다 클 수 없다
        model.addAttribute("lastPage", lastPage);//마지막페이지
        model.addAttribute("rightPage", rightPage);
        model.addAttribute("leftPage", leftPage);
        model.addAttribute("prevPage", prevPage);
        model.addAttribute("nextPage", nextPage);

        ResultSet rs2 = selectStmt.executeQuery();
        List<CustomerDto> list = new ArrayList<>();
        while (rs2.next()) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(rs2.getInt("CustomerId"));
            customerDto.setAddress(rs2.getString("Address"));
            customerDto.setName(rs2.getString("CustomerName"));
            customerDto.setContactName(rs2.getString("ContactName"));
            customerDto.setCity(rs2.getString("City"));
            customerDto.setCountry(rs2.getString("Country"));
            customerDto.setPostalCode(rs2.getString("PostalCode"));
            list.add(customerDto);

        }
        model.addAttribute("customerList", list);

        return "main15/sub3";
    }

    //연습 //
    // 상품명 조회 로직 작성
    @GetMapping("sub4")
    public String sub4(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "") String keyword,
                       Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Products
                WHERE ProductName LIKE ?
                ORDER BY ProductID
                LIMIT ?, ?
                """;
        String countSql = """
                SELECT COUNT(*) AS count
                FROM Products
                WHERE ProductName LIKE ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connetion = DriverManager.getConnection(url, username, password);


        PreparedStatement select = connetion.prepareStatement(sql);
        select.setString(1, "%" + keyword + "%");
        int offset = (page - 1) * 5;
        select.setInt(2, offset);
        select.setInt(3, 5);

        PreparedStatement counts = connetion.prepareStatement(countSql);
        counts.setString(1, "%" + keyword + "%");
        ResultSet rs1 = counts.executeQuery();
        rs1.next();
        int count = rs1.getInt("count");
        int lastPage = (count - 1) / 5 + 1;
        int rightPage = ((page - 1) / 10 + 1) * 10;// 오른쪽 페이지번호
        int leftPage = rightPage - 9;
        int prevPage = leftPage - 10;
        int nextPage = rightPage + 1;
        int FirstPage = 1;
        int Lastpage = (count - 1) / 5 + 1;
        rightPage = Math.min(rightPage, lastPage); // 오른쪽 페이지번호는 마지막보다 클 수 없다
        model.addAttribute("lastPage", lastPage);
        model.addAttribute("rightPage", rightPage);
        model.addAttribute("leftPage", leftPage);
        model.addAttribute("prevPage", prevPage);
        model.addAttribute("nextPage", nextPage);
        model.addAttribute("FirstPage", FirstPage);
        model.addAttribute("Lastpage", Lastpage);

        ResultSet rs2 = select.executeQuery();
        List<ProductDto> list = new ArrayList<>();
        while (rs2.next()) {
            ProductDto dto = new ProductDto();
            dto.setId(rs2.getInt("ProductId"));
            dto.setName(rs2.getString("ProductName"));
            dto.setSupplier(rs2.getInt("SupplierID"));
            dto.setCategory(rs2.getInt("CategoryID"));
            dto.setUnit(rs2.getString("Unit"));
            dto.setPrice(rs2.getDouble("Price"));
            list.add(dto);
        }
        model.addAttribute("productList", list);


        return "main15/sub4";

    }
}
