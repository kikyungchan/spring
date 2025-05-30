package com.example.spring.controller;


import com.example.spring.dto.MyBean053;
import com.example.spring.dto.MyBean055;
import com.example.spring.dto.MyBean057;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main7")
public class Controller07 {

    @RequestMapping("sub1")
    public String sub1(Model model) {

        model.addAttribute("aiList", List.of("gpt", "gemini", "grok", "deep"));


        return "main7/sub1";
    }

    @RequestMapping("sub2")
    public String sub2(Model model) {
        //테이블 형식으로
        // |번호|이름|생일|가격
        //|1 | | |
        model.addAttribute("myList", List.of(new MyBean057("lee", "01-01", 5000), new MyBean057("kim", "02-02", 4000), new MyBean057("son", "03-03", 6000), new MyBean057("park", "04-04", 3000), new MyBean057("choi", "05-05", 7000)));
        return "main7/sub2";
    }

    @RequestMapping("sub3")
    public String sub3(Model model) {
        model.addAttribute("myList", List.of("java", "spring", "react", "gpt", "grok"));
        return "main7/sub3";
    }

    @RequestMapping("sub4")
    public String sub4(Model model) {
        model.addAttribute("item", new MyBean057("trump", "09-09", 1000));
        model.addAttribute("person", new MyBean055(98, List.of("tesla", "apple"), List.of("seoul", "jeju")));
        return "main7/sub4";
    }

    @RequestMapping("sub5")
    public String sub5(Model model) {
        model.addAttribute("person", new MyBean055(98, List.of("tesla", "apple"), List.of("seoul", "jeju")));
        return "main7/sub5";
    }

    @RequestMapping("sub6")
    public String sub6(Model model) {
        model.addAttribute("person", new MyBean055(98, List.of("tesla", "apple"), List.of("seoul", "jeju")));
        return "main7/sub6";
    }

    @RequestMapping("sub7")
    public String sub7(Model model) {
        model.addAttribute("person", new MyBean055(98, List.of("tesla", "apple"), List.of("seoul", "jeju")));
        return "main7/sub7";
    }

    @RequestMapping("sub8")
    public String sub8(Model model) {
        List<String> company = new ArrayList<>();
        company.add("tesla");
        company.add("apple");
        company.add(null);
        model.addAttribute("person", new MyBean055(98, List.of(), List.of("seoul", "jeju")));
        return "main7/sub8";
    }

    //번호 무게 이름 결혼
    //번호 33.3 musk ♥️
    //              💔

//    @RequestMapping("sub9")
//    public String sub9(Model model) {
//        model.addAttribute("name", "son");
//        model.addAttribute("married", "false");
//        model.addAttribute("working", "true");
//        model.addAttribute("age", 55);
//        model.addAttribute("city", null);
//        model.addAttribute("students",
//                List.of(new MyBean053(10.0, 3, true, "trump"),
//                        new MyBean053(20.1, 44, false, "donal"),
//                        new MyBean053(30.1, 55, true, "musk"),
//                        new MyBean053(40.1, 66, false, "elvis"),
//                        new MyBean053(50.1, 77, true, "elon")));
//        return "main7/sub9";
//    }


}
