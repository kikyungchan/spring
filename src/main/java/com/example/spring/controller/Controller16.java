package com.example.spring.controller;

import com.example.spring.dto.CustomerDto;
import com.example.spring.dto.SupplierDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main16")
public class Controller16 {

    @GetMapping("sub1")
    public String form1(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Customers
                ORDER BY CustomerId DESC
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connetion = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connetion.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        List<CustomerDto> customerDtoList = new ArrayList<>();
        while (rs.next()) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(rs.getInt("CustomerId"));
            customerDto.setName(rs.getString("CustomerName"));
            customerDto.setAddress(rs.getString("Address"));
            customerDto.setCity(rs.getString("City"));
            customerDto.setContactName(rs.getString("ContactName"));
            customerDto.setCountry(rs.getString("Country"));
            customerDto.setPostalCode(rs.getString("PostalCode"));
            customerDtoList.add(customerDto);
        }
        model.addAttribute("customerDtoList", customerDtoList);
        return "main16/sub1";
    }

    @PostMapping("sub1")
    public String process(CustomerDto customer) throws Exception {
//        System.out.println(customer);
        String sql = """
                INSERT INTO Customers
                (CustomerName, ContactName, Address, City, PostalCode, Country)
                VALUES(?,?,?,?,?,?)
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connetion = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connetion.prepareStatement(sql);
        statement.setString(1, customer.getName());
        statement.setString(2, customer.getContactName());
        statement.setString(3, customer.getAddress());
        statement.setString(4, customer.getAddress());
        statement.setString(5, customer.getPostalCode());
        statement.setString(6, customer.getCountry());

//        statement.executeQuery(); //select
        statement.executeUpdate(); // insert, delete, update


        return "redirect:/main16/sub1";

    }

    @GetMapping("sub2")
    public String form2(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Suppliers
                ORDER BY SupplierId DESC
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connetion = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connetion.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        List<SupplierDto> DtoList = new ArrayList<>();
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
            DtoList.add(dto);
            DtoList.add(dto);
        }
        model.addAttribute("dtoList", DtoList);
        return "main16/sub2";
    }

    @PostMapping("sub2")
    public String process2(SupplierDto supplier) throws Exception {
        String sql = """
                INSERT INTO Suppliers
                 (SupplierName, ContactName, Address, City, PostalCode, Country, Phone) 
                 VALUES(?,?,?,?,?,?,?)
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connetion = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connetion.prepareStatement(sql);
        statement.setString(1, supplier.getSupplierName());
        statement.setString(2, supplier.getContactName());
        statement.setString(3, supplier.getAddress());
        statement.setString(4, supplier.getCity());
        statement.setString(5, supplier.getPost());
        statement.setString(6, supplier.getCountry());
        statement.setString(7, supplier.getPhone());
        statement.executeUpdate();
        return "redirect:/main16/sub2";
    }
}
