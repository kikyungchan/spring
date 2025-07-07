package com.example.spring.controller;

import com.example.spring.dto.MyBean291;
import com.example.spring.dto.MyBean292;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/main29")
@ResponseBody
public class Controller29 {

    @PostMapping("sub1")
    public String sub1() {
        System.out.println("Controller29.sub1");
        return null;
    }

    @PostMapping("sub2")
    public String sub2() {
        System.out.println("Controller29.sub2");
        return null;
    }

    @PostMapping("sub3")
    public String sub3() {
        System.out.println("Controller29.sub3");
        return null;
    }

    @PostMapping("sub4")
    public String sub4(@RequestBody Map<String, Object> map) {
        //@리퀘스트바디 : JSON을 해당 타입(Map)으로 역직렬화(디코딩,파싱)
        System.out.println("Controller29.sub4");
        System.out.println("map = " + map);
        return null;
    }

    @PostMapping("sub5")
    public String sub5(@RequestBody Map<String, Object> map) {
        System.out.println("Controller29.sub5");
        System.out.println("map = " + map); // address:seoul score:88.12 country:korea
        return null;
    }

    @PostMapping("sub6")
    public String sub6(@RequestBody Map<String, Object> map) {
        Object var1 = map.get("var1"); // "신촌" string
        Object var2 = map.get("var2"); // 66 number
        Object var3 = map.get("var3"); // 77.12 number
        Object var4 = map.get("var4"); // true boolean
        Object var5 = map.get("var5"); // null

        System.out.println("var1 = " + var1.getClass().getSimpleName()); // String
        System.out.println("var2 = " + var2.getClass().getSimpleName()); // Integer
        System.out.println("var3 = " + var3.getClass().getSimpleName()); // Double
        System.out.println("var4 = " + var4.getClass().getSimpleName()); // Boolean
        System.out.println("var5 = " + var5); // null
        return null;
    }

    @PostMapping("sub7")
    public String sub7(@RequestBody Map<String, Object> map) {
        Object address = map.get("address");
        Object score = map.get("score");
        Object age = map.get("age");
        Object married = map.get("married");
        System.out.println("address = " + address.getClass().getSimpleName());
        System.out.println("score = " + score.getClass().getSimpleName());
        System.out.println("age = " + age.getClass().getSimpleName());
        System.out.println("married = " + married.getClass().getSimpleName());
        System.out.println();
        return null;
    }

    @PostMapping("sub8")
    public String sub8(@RequestBody Map<String, Object> map) {
        Object address = map.get("address");
        Object age = map.get("age");
        Object fruits = map.get("fruits");
        System.out.println("address = " + address.getClass().getSimpleName());
        System.out.println("age = " + age.getClass().getSimpleName());

        // JSON의 array 타입은 JAVA의 ArrayList로 파싱됨
        System.out.println("fruits = " + fruits.getClass().getSimpleName());
        System.out.println("fruits = " + fruits);
        return null;
    }

    @PostMapping("sub9")
    public String sub9(@RequestBody Map<String, Object> map) {
        Object name = map.get("name");
        Object teams = map.get("teams");
        Object person = map.get("person");
        System.out.println("person.getClass().getSimpleName() = " + person.getClass().getSimpleName());

        System.out.println("person = " + person);
        return null;
    }

    @PostMapping("sub10")
    public String sub10(@RequestBody Map<String, Object> map) {
        Object cityList = map.get("cityList");
        Object team = map.get("team");
        System.out.println("cityList = " + cityList.getClass().getSimpleName());
        System.out.println("team = " + team.getClass().getSimpleName());
        System.out.println("team = " + team);
        System.out.println("cityList = " + cityList);
        return null;
    }

    @PostMapping("sub11")
    public String sub11(@RequestBody List<Object> data) {
        System.out.println("data = " + data);
        return null;
    }

    @PostMapping("sub12")
    public String sub12(@RequestBody List<Map<String, Object>> map) {
        for (Map<String, Object> map1 : map) {
            System.out.println("map1 = " + map1);
        }
//        Object name0 = map.get(0).get("name");
//        Object age0 = map.get(0).get("age");
//        Object address0 = map.get(0).get("address");
//        Object name1 = map.get(1).get("name");
//        Object age1 = map.get(1).get("age");
//        Object address1 = map.get(1).get("address");
//        Object name2 = map.get(2).get("name");
//        Object age2 = map.get(2).get("age");
//        Object address2 = map.get(2).get("address");
//        System.out.println("name0 = " + name0);
//        System.out.println("age0 = " + age0);
//        System.out.println("address0 = " + address0);
//        System.out.println("name1 = " + name1);
//        System.out.println("age1 = " + age1);
//        System.out.println("address1 = " + address1);
//        System.out.println("name2 = " + name2);
//        System.out.println("age2 = " + age2);
//        System.out.println("address2 = " + address2);
//        System.out.println("name0 = " + name0.getClass().getSimpleName());
//        System.out.println("map = " + map);
        return null;
    }

    @PostMapping("sub13")
    public String sub13(@RequestBody MyBean291 dto) {
        System.out.println("dto = " + dto.getNickName());
        System.out.println("dto = " + dto.getAge());
        System.out.println("dto = " + dto.getMarried());
        System.out.println("dto = " + dto.getAddress());
        System.out.println("dto = " + dto.getTeam());

        return null;
    }

    @PostMapping("sub14")
    public String sub14(@RequestBody MyBean292 dto) {
        System.out.println(dto.getPerson());
        System.out.println(dto.getCity());
        System.out.println(dto.getScore());
        System.out.println(dto.getFruits());
        System.out.println(dto.getChecked());

        return null;
    }

}
