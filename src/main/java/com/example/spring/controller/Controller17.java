package com.example.spring.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Controller
@RequestMapping("main17")
public class Controller17 {

    @GetMapping("sub1")
    public String sub1() throws Exception {
        String sql = """
                INSERT INTO table12
                    (col1, col2, col3, col4, col5, col6, col7)
                VALUES (?, ?, ?, ?, ?, ?, ?);
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connetion = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connetion.prepareStatement(sql);
        statement.setString(1, "한글");
        statement.setString(2, "243242");
        statement.setString(3, "984919198");
        statement.setString(4, "987561.12");
        statement.setString(5, "1950-06-25");
        statement.setString(6, "16:21:34");
        statement.setString(7, "2009-01-31 16:21:34");

        statement.executeUpdate();
        return null;
    }

    @GetMapping("sub2")
    public String sub2() throws Exception {
        String sql = """
                INSERT INTO table12
                    (col1, col2, col3, col4, col5, col6, col7)
                VALUES (?, ?, ?, ?, ?, ?, ?);
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connetion = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connetion.prepareStatement(sql);
        statement.setString(1, "한글");
        statement.setInt(2, 34534);
        statement.setLong(3, 979899899);
        statement.setDouble(4, 62347.34);
        statement.setDate(5, Date.valueOf("1950-06-25"));
        statement.setTime(6, Time.valueOf("16:21:34"));
        statement.setTimestamp(7, Timestamp.valueOf("2009-01-31 16:21:34"));

        statement.executeUpdate();
        return null;
    }

    @GetMapping("sub3")
    public String sub3() throws Exception {
        String sql = """
                SELECT *
                FROM table12
                LIMIT 1
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connetion = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connetion.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("col1"));
            System.out.println(resultSet.getString("col2"));
            System.out.println(resultSet.getString("col3"));
            System.out.println(resultSet.getString("col4"));
            System.out.println(resultSet.getString("col5"));
            System.out.println(resultSet.getString("col6"));
            System.out.println(resultSet.getString("col7"));
            System.out.println();
        }
        return null;
    }

    @GetMapping("sub4")
    public String sub4() throws Exception {
        String sql = """
                SELECT *
                FROM table12
                LIMIT 1
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connetion = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connetion.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("col1"));
            System.out.println(resultSet.getInt("col2"));
            System.out.println(resultSet.getLong("col3"));
            System.out.println(resultSet.getDouble("col4"));
            System.out.println(resultSet.getDate("col5"));
            System.out.println(resultSet.getTime("col6"));
            System.out.println(resultSet.getTimestamp("col7"));
            System.out.println();
        }
        return null;
    }

    @Data
    static class Dto5 {
        private String col1;
        private Integer col2;
        private Long col3;
        private Double col4;
        private LocalDate col5;
        private LocalTime col6;
        private LocalDateTime col7;
    }

    @GetMapping("sub5")
    public String sub5(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM table12
                LIMIT 1
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connetion = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connetion.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            Dto5 dto5 = new Dto5();
            dto5.setCol1(resultSet.getString("col1"));
            dto5.setCol2(resultSet.getInt("col2"));
            dto5.setCol3(resultSet.getLong("col3"));
            dto5.setCol4(resultSet.getDouble("col4"));
            dto5.setCol5(resultSet.getDate("col5").toLocalDate());
            dto5.setCol6(resultSet.getTime("col6").toLocalTime());
            dto5.setCol7(resultSet.getTimestamp("col7").toLocalDateTime());
            model.addAttribute("data", dto5);
        }
        return "main17/sub5";
    }

    @GetMapping("sub6")
    public String sub6(Model model) throws Exception {
        return "main17/sub6";
    }

    @PostMapping("sub6")
    public String process6(Dto5 dto5) throws Exception {
        String sql = """
                INSERT INTO table12
                    (col1, col2, col3, col4, col5, col6, col7)
                VALUES (?, ?, ?, ?, ?, ?, ?);
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connetion = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connetion.prepareStatement(sql);
        statement.setString(1, dto5.getCol1());
        statement.setInt(2, dto5.getCol2());
        statement.setLong(3, dto5.getCol3());
        statement.setDouble(4, dto5.getCol4());
        statement.setDate(5, Date.valueOf(dto5.getCol5()));
        statement.setTime(6, Time.valueOf(dto5.getCol6()));
        statement.setTimestamp(7, Timestamp.valueOf(dto5.getCol7()));

        statement.executeUpdate();
        return "redirect:/main17/sub6";
    }

    //연습
    //name(텍스트), birth_date(날짜), score(소숫점 2까지), born_at table13 만들고
    //form(html),
    //dto만들기
    @Data
    static class Dto6 {
        private String name;
        private LocalDate birth_date;
        private Double score;
        private LocalDateTime born_at;
    }
    //request handler method (2개)
    @GetMapping("sub7")
    public String sub7(Model model) throws Exception {

        return "main17/sub7";
    }

    @PostMapping("sub7")
    public String process7(Dto6 dto6) throws Exception {
        String sql = """
                INSERT INTO table13
                    (name, birth_date, score, born_at)
                VALUES (?, ?, ?, ?);
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connetion = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connetion.prepareStatement(sql);
        statement.setString(1, dto6.name);
        statement.setDate(2, Date.valueOf(dto6.birth_date));
        statement.setDouble(3, dto6.score);
        statement.setTimestamp(4, Timestamp.valueOf(dto6.born_at));

        statement.executeUpdate();


        return "redirect:/main17/sub7";
    }
}
