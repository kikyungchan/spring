package com.example.spring.controller;

import com.example.spring.dto.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main5")
public class Controller05 {
    @RequestMapping("sub1")
    public String sub1(Model model) {

        model.addAttribute("name", "son");

        // attribute 가 javaBeans(dto)
        MyBean051 m = new MyBean051();
        m.setAddress("seoul");
        m.setName("trump");
        m.setAge(22);
        model.addAttribute("obj", m);

        //forward to /templates/main5/sub1.html
        return "main5/sub1";
    }

    //연습: 아래 코드를 보고 나머지 코드들(dto,html)을 완성하세요.
    @RequestMapping("sub2")
    public String sub2(Model model) {

        MyBean052 obj = new MyBean052();
        obj.setHome("ny");
        obj.setScore(98.76);
        obj.setHeight(180.5);
        obj.setNickName("tiger");
        model.addAttribute("attr", obj);
        return "main5/sub2";
    }

    @RequestMapping("sub3")
    public String sub3(Model model) {
        MyBean053 mb = new MyBean053();
        mb.setWeight(86.3);
        mb.setStudentNumber(30);
        mb.setMarried(false);
        mb.setInfo("인포메이션?");
        model.addAttribute("val", mb);
        return "main5/sub3";
    }

    //model attribute type이 map
    @RequestMapping("sub4")
    public String sub4(Model model) {
        model.addAttribute("attr",
                Map.of("name", "tiger",
                        "age", 20,
                        "address", "seoul",
                        "1 my info", "my name is trump"));

        return "main5/sub4";
    }

    @RequestMapping("sub5")
    public String sub5(Model model) {
        model.addAttribute("values", Map.of(
                "home", "제주",
                "address", "애월",
                "birth date", "2010-01-01",
                "score", 98.76
        ));
        return "main5/sub5";
    }

    @RequestMapping("sub6")
    public String sub6(Model model) {
        model.addAttribute("car", Map.of(
                "model", "임팔라",
                "company", "쉐보레",
                "price", "5000만원",
                "used", "sometimes",
                "pre user", "ok"
        ));
        return "main5/sub6";
    }

    @RequestMapping("sub7")
    public String sub7(Model model) {
        model.addAttribute("list", new String[]{"java", "css", "react", "vue"});

        return "main5/sub7";
    }

    @RequestMapping("sub8")
    public String sub8(Model model) {
        model.addAttribute("skills", new String[]{"bootstrap", "thymeleaf", "react"});
        return "main5/sub8";
    }

    @RequestMapping("sub9")
    public String sub9(Model model) {
        model.addAttribute("list", List.of("tesla", "waymo", "volvo", "bmw"));
        return "main5/sub9";
    }

    @RequestMapping("sub10")
    public String sub10(Model model) {
        MyBean054 o = new MyBean054("trump", 77, List.of("1234", "5678", "0987"));

        model.addAttribute("president", o);

        return "main5/sub10";
    }

    @RequestMapping("sub11")
    public String sub11(Model model) {
        MyBean055 e = new MyBean055(33,
                List.of("seoul", "jeju", "ulsan"),
                List.of("삼성", "엘지", "카카오"));
        model.addAttribute("person", e);
        return "main5/sub11";
    }

    @RequestMapping("sub12")
    public String sub12(Model model) {
        model.addAttribute("people", List.of(
                new MyBean056("tesla", 66, true),
                new MyBean056("apple", 77, false),
                new MyBean056("uber", 55, true)
        ));

        return "main5/sub12";
    }

    @RequestMapping("sub13")
    public String sub13(Model model) {
        model.addAttribute("aiList",
                List.of(new MyBean057("gemini", "2020-01-01", 3000),
                        new MyBean057("chatgpt", "1919-12-12", 3500),
                        new MyBean057("claude", "1988-11-11", 6000)));
        return "main5/sub13";
    }
}
