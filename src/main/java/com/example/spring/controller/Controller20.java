package com.example.spring.controller;

import com.example.spring.entity.Entity14;
import com.example.spring.service.Service2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("main20")
@RequiredArgsConstructor
public class Controller20 {

    private final Service2 service2;

    @GetMapping("sub1")
    public String sub1(Model model) {

        String result = service2.process1();
        model.addAttribute("result", result);

        return "main20/sub1";
    }

    @GetMapping("sub2")
    public String sub2(Model model) {
        service2.process2();

        return "main20/sub2";
    }

    @GetMapping("sub3")
    public String sub3(Model model) {
        service2.process3();

        return "main20/sub3";
    }

    @GetMapping("sub4")
    public String sub4(Model model) {
        service2.process4();

        return "main20/sub4";
    }

    @GetMapping("sub5")
    public String sub5(Model model) {
        service2.process5();

        return "main20/sub5";
    }

    @GetMapping("sub6")
    public String sub6(Model model) {
        service2.process6();
        return "main20/sub6";
    }

    @GetMapping("sub7")
    public String sub7(Model model) {
        service2.process7();
        return "main20/sub7";
    }

    @GetMapping("sub10")
    public String sub10(Model model) {
        // Spring Data JPA
        // Entity : 테이블과 매핑되는 클래스(객체_
        // Repository : Entity를 이용한 CRUD 메소드 제공(클래스,인터페이스)
        // SELECT : find ..., get...,
        // UPDATE : save ...
        // DELETE : delete...
        // INSERTE : save

        // JpaRepository<T,ID> 인터페이스를 상속해서 만들면 됨
        // 타입 파라미터 T : crud 대상 테이블의 매핑되는 Entity
        // 타입 파라미터 ID : Entity의 PK 자료형

        // Spring은
        // Repository 인터페이스에 있는 메소드를 활용해서
        // 연결,statement,ResultSet 처리하는 구현 코드를 생성
        service2.process7();
        return "main20/sub10";
    }

    @GetMapping("sub11")
    public String sub11(Model model) {
        service2.process8();
        return "main20/sub11";
    }

    @GetMapping("sub12")
    public String sub12(Model model) {
        service2.process9();
        return "main20/sub12";
    }

    @GetMapping("sub13")
    public String sub13(Model model) {
        service2.process10();
        return "main20/sub13";
    }

    @GetMapping("sub14")
    public String sub14(Integer id, Model model) {
        Entity14 data = service2.process11(id);

        model.addAttribute("data", data);
        System.out.println("data = " + data);
        return "main20/sub14";
    }

    // /main20/sub15?name=choi&score=99.9&city=dokdo
    @GetMapping("sub15")
    public String sub15(String name, Double score, String city) {
        service2.process12(name, score, city);

        return "main20/sub15";
    }

    // /main20/sub16?address=shibuya&price=100&insertedAt=1995-04-17T12:13:14
    @GetMapping("sub16")
    public String sub16(String address, Integer price, LocalDateTime insertedAt, Model model) {
        service2.process13(address, price, insertedAt);
        return "main20/sub16";

    }

    // /main20/sub17?id=2&score=12.34
    @GetMapping("sub17")
    public String sub17(Integer id, Double score) {
        service2.process14(id, score);
        return "main20/sub17";
    }

    // /main20/sub18?id=1&address=강남
    @GetMapping("sub18")
    public String sub18(Integer id, String address) {
        service2.process15(id, address);
        return "main20/sub18";
    }

    // /main20/sub19?id=1
    @GetMapping("sub19")
    public String sub19(Integer id) {
        service2.process16(id);

        return "main20/sub19";
    }

    // /main20/sub20?id=1
    @GetMapping("sub20")
    public String sub20(Integer id) {
        service2.process17(id);
        return "main20/sub20";
    }
}
