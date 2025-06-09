package com.example.spring.controller;

import com.example.spring.dto.CustomerDto;
import com.example.spring.dto.EmployeeDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main14")
public class Controller14 {

    @GetMapping("sub1")
    public String sub1(String keyword, Model model) throws Exception {
        // 직원 설명의 특정 키워드가 있는 직원들 조회
        String sql = """
                SELECT *
                FROM Employees
                WHERE Notes LIKE ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connetion = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connetion.prepareStatement(sql);

        statement.setString(1, "%" + keyword + "%");

        List<EmployeeDto> list = new ArrayList<>();
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(rs.getInt("EmployeeId"));
            employeeDto.setLastName(rs.getString("Lastname"));
            employeeDto.setFirstName(rs.getString("Firstname"));
            employeeDto.setBirthDate(rs.getDate("BirthDate").toLocalDate());
            employeeDto.setNotes(rs.getString("Photo"));
            employeeDto.setNotes(rs.getString("Notes"));
            list.add(employeeDto);

        }
        model.addAttribute("list", list);


        return "main14/sub1";
    }

    //연습 :
    //고객명 조회하는 코드 완성
    @GetMapping("sub2")
    public String sub2(String keyword, Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Customers
                WHERE CustomerName LIKE ?
                OR ContactName LIKE ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connetion = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connetion.prepareStatement(sql);
        statement.setString(1, "%" + keyword + "%");
        statement.setString(2, "%" + keyword + "%");
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
        model.addAttribute("list", list);
        return "main14/sub2";
    }
}
