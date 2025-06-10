package com.example.spring.controller;

import com.example.spring.dto.CustomerDto;
import com.example.spring.dto.SupplierDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
            dto.setPostalCode(rs.getString("PostalCode"));
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
        statement.setString(5, supplier.getPostalCode());
        statement.setString(6, supplier.getCountry());
        statement.setString(7, supplier.getPhone());
        statement.executeUpdate();
        return "redirect:/main16/sub2";
    }

    @GetMapping("sub3")
    public String form3(Integer id, Model model) throws Exception {
        if (id != null) {
            String sql = """
                    SELECT *
                    FROM Customers
                    WHERE CustomerId = ?
                    """;
            String url = "jdbc:mysql://localhost:3306/w3schools";
            String username = "root";
            String password = "1234";
            Connection connetion = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connetion.prepareStatement(sql);
            statement.setInt(1, id);

//        statement.executeUpdate(); // insert,update,delete
            ResultSet resultSet = statement.executeQuery(); // select
            if (resultSet.next()) {
                //조회 결과가 있을 떄만
                CustomerDto customerDto = new CustomerDto();
                customerDto.setId(resultSet.getInt("CustomerId"));
                customerDto.setName(resultSet.getString("CustomerName"));
                customerDto.setAddress(resultSet.getString("Address"));
                customerDto.setCity(resultSet.getString("City"));
                customerDto.setContactName(resultSet.getString("ContactName"));
                customerDto.setCountry(resultSet.getString("Country"));
                customerDto.setPostalCode(resultSet.getString("PostalCode"));
                model.addAttribute("customer", customerDto);
            }
        }
        return "main16/sub3";
    }

    @PostMapping("sub3")
    public String process3(Integer id, RedirectAttributes rttr) throws Exception {
        String sql = """
                DELETE
                FROM Customers
                WHERE CustomerId = ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connetion = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connetion.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
        rttr.addAttribute("id", id);
        return "redirect:/main16/sub3";
    }

    //연습:
    //공급자 조회 후 삭제 로직 완성
    @GetMapping("sub4")
    public String form4(Integer id, Model model) throws Exception {
        if (id != null) {
            String sql = """
                    SELECT *
                    FROM Suppliers
                    WHERE SupplierId = ?
                    """;
            String url = "jdbc:mysql://localhost:3306/w3schools";
            String username = "root";
            String password = "1234";
            Connection connetion = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connetion.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                SupplierDto supplierDto = new SupplierDto();
                supplierDto.setSupplierId(resultSet.getInt("SupplierId"));
                supplierDto.setSupplierName(resultSet.getString("SupplierName"));
                supplierDto.setContactName(resultSet.getString("ContactName"));
                supplierDto.setAddress(resultSet.getString("Address"));
                supplierDto.setCity(resultSet.getString("City"));
                supplierDto.setPostalCode(resultSet.getString("PostalCode"));
                supplierDto.setCountry(resultSet.getString("Country"));
                supplierDto.setPhone(resultSet.getString("Phone"));
                model.addAttribute("supplier", supplierDto);
            }
        }
        return "main16/sub4";
    }

    @PostMapping("sub4")
    public String process4(Integer id, RedirectAttributes rttr) throws Exception {
        String sql = """
                DELETE
                FROM Suppliers
                WHERE SupplierId = ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connetion = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connetion.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
        rttr.addAttribute("id", id);
        return "redirect:/main16/sub4";
    }

    @GetMapping("sub5")
    public String select1(Integer id, Model model) throws Exception {
        if (id != null) {
            String sql = """
                    SELECT *
                    FROM Customers
                    WHERE CustomerId = ?
                    """;
            String url = "jdbc:mysql://localhost:3306/w3schools";
            String username = "root";
            String password = "1234";
            Connection connetion = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connetion.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                CustomerDto customerDto = new CustomerDto();
                customerDto.setId(resultSet.getInt("CustomerId"));
                customerDto.setName(resultSet.getString("CustomerName"));
                customerDto.setAddress(resultSet.getString("Address"));
                customerDto.setCity(resultSet.getString("City"));
                customerDto.setContactName(resultSet.getString("ContactName"));
                customerDto.setCountry(resultSet.getString("Country"));
                customerDto.setPostalCode(resultSet.getString("PostalCode"));
                model.addAttribute("customer", customerDto);
            }
        }
        return "main16/sub5";
    }

    @PostMapping("sub5")
    public String update1(CustomerDto customer, RedirectAttributes rttr) throws Exception {
//        System.out.println("customer = " + customer);
        String sql = """
                UPDATE Customers
                SET CustomerName = ?,
                ContactName = ?,
                Address = ?,
                City = ?,
                PostalCode = ?,
                Country = ?
                WHERE CustomerId = ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connetion = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connetion.prepareStatement(sql);
        statement.setString(1, customer.getName());
        statement.setString(2, customer.getContactName());
        statement.setString(3, customer.getAddress());
        statement.setString(4, customer.getCity());
        statement.setString(5, customer.getPostalCode());
        statement.setString(6, customer.getCountry());
        statement.setInt(7, customer.getId());
        statement.executeUpdate(); // update
        rttr.addAttribute("id", customer.getId());
        return "redirect:/main16/sub5";
    }

    //연습 :
    // 공급자 정보 조회 수정
    @GetMapping("sub6")
    public String select2(Integer id, Model model) throws Exception {
        if (id != null) {
            String sql = """
                    SELECT *
                    FROM Suppliers
                    WHERE SupplierId = ?
                    """;
            String url = "jdbc:mysql://localhost:3306/w3schools";
            String username = "root";
            String password = "1234";
            Connection connetion = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connetion.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                SupplierDto supplierDto = new SupplierDto();
                supplierDto.setSupplierId(resultSet.getInt("SupplierId"));
                supplierDto.setSupplierName(resultSet.getString("SupplierName"));
                supplierDto.setContactName(resultSet.getString("ContactName"));
                supplierDto.setAddress(resultSet.getString("Address"));
                supplierDto.setCity(resultSet.getString("City"));
                supplierDto.setPostalCode(resultSet.getString("PostalCode"));
                supplierDto.setCountry(resultSet.getString("Country"));
                supplierDto.setPhone(resultSet.getString("Phone"));
                model.addAttribute("supplier", supplierDto);
            }
        }
        return "main16/sub6";
    }

    @PostMapping("sub6")
    public String update2(SupplierDto supplier, RedirectAttributes rttr) throws Exception {
        String sql = """
                UPDATE Suppliers
                SET SupplierId=?,
                SupplierName=?,
                ContactName=?,
                Address=?,
                City=?,
                PostalCode=?,
                Country=?,
                Phone=?
                WHERE SupplierId = ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connetion = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connetion.prepareStatement(sql);
        statement.setInt(1, supplier.getSupplierId());
        statement.setString(2, supplier.getSupplierName());
        statement.setString(3, supplier.getContactName());
        statement.setString(4, supplier.getAddress());
        statement.setString(5, supplier.getCity());
        statement.setString(6, supplier.getPostalCode());
        statement.setString(7, supplier.getCountry());
        statement.setString(8, supplier.getPhone());
        statement.setInt(9,supplier.getSupplierId());
        statement.executeUpdate();
        rttr.addAttribute("id", supplier.getSupplierId());
        return "redirect:/main16/sub6";
    }
}
