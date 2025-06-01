package com.example.spring.controller;


import com.example.spring.dto.MyBean053;
import com.example.spring.dto.MyBean057;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("main8")
public class Controller08 {
    @RequestMapping("sub1")
    public String sub1(Model model) {

        model.addAttribute("students",
                List.of(new MyBean053(10, 3.0, "trump", true),
                        new MyBean053(20, 44.0, "donal", false),
                        new MyBean053(30, 55.0, "musk", true),
                        new MyBean053(40, 66.0, "elvis", false),
                        new MyBean053(50, 77.0, "elon", true)));
        return "main8/sub1";
    }

    @RequestMapping("sub2")
    public String sub2(Model model) {

        /*
        가격은 italic 체로 출력
        5000원 이상은 굵은 글씨로

        |이름|생일|가격|
        |lee|01-01|5000|
         */

        model.addAttribute("myList",
                List.of(new MyBean057("lee", "01-01", 5000),
                        new MyBean057("kim", "02-02", 4000),
                        new MyBean057("son", "03-03", 6000),
                        new MyBean057("park", "04-04", 3000),
                        new MyBean057("choi", "05-05", 7000)));

        return "main8/sub2";
    }

    @RequestMapping("sub3")
    public String sub3(Model model, HttpSession session) {

        return "main8/sub3";
    }

    @RequestMapping("sub4")
    public String sub4(Model model, String animal) {

        model.addAttribute("animal", animal);

        return "main8/sub4";
    }

    @RequestMapping("sub5")
    public String sub5(Model model) {

        return "main8/sub5";
    }

    @RequestMapping("sub6")
    public String sub6(Model model) {

        return "main8/sub6";
    }

}
