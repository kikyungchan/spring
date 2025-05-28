package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

@Controller
public class Controller02 {

    // /main2/sub1?name
    @RequestMapping(value = "/main2/sub1", params = "name")
    public void sub1(WebRequest request) {
        // header정보
        request.getHeader("User-Agent");

        System.out.println("Controller02.sub1");
    }

    // /maine2/sub2?name&address
    // ?:쿼리 스트링
    // 쿼리 스트링 = name1=value1&name2=value2
    @RequestMapping(value = "/main2/sub2", params = {"name", "address"})
    public void sub2(WebRequest request) {
        // header정보
        request.getHeader("User-Agent");

        System.out.println("Controller02.sub2");
    }

    // /main2/sub3?name=musk
    @RequestMapping(value = "/main2/sub3", params = "name")
    public void sub3(WebRequest request) {
        String name = request.getParameter("name");
        System.out.println("name = " + name);
        System.out.println("Controller02.sub3");
    }

    // /main2/sub3?address=seoul
    // /main2/sub3?address=jejo
    @RequestMapping(value = "/main2/sub3", params = "address")
    public void sub4(WebRequest request) {
        String address = request.getParameter("address");
        System.out.println("address = " + address);
        System.out.println("Controller02.sub4");
        // @RequestParam : 해당 이름의 request parameter를 method parameter 에 binding 해준다
    }

    // /main2/sub5?email=gmail
    @RequestMapping(value = "/main2/sub5", params = "email")
    public void sub5(@RequestParam("email") String str) {
        System.out.println("str = " + str);
    }

    // /main2/sub6?email=yahoo&age=55
    @RequestMapping(value = "/main2/sub6", params = {"email", "age"})
    public void sub6(@RequestParam("email") String str,
                     @RequestParam("age") String v) {
        System.out.println("str = " + str);
        System.out.println("v = " + v);
    }

    @RequestMapping(value = "/main2/sub7")
    public void sub7(@RequestParam("email") String str,
                     @RequestParam("age") String v) {
        System.out.println("str = " + str);
        System.out.println("v = " + v);
    }

    //연습 :
    // /main2/sub8?address=jeju&country=korea&city=gangnam
    @RequestMapping(value = "/main2/sub8")
    public void sub8(@RequestParam("address") String address,
                     @RequestParam("country") String country,
                     @RequestParam("city") String city) {
        System.out.println("city = " + city);
        System.out.println("country = " + country);
        System.out.println("address = " + address);
    }

    // /main2/sub9?city=seoul&age=44
    @RequestMapping("/main2/sub9")
    public void sub9(@RequestParam("city") String city,
                     @RequestParam("age") String age) {
        System.out.println("city = " + city);
        System.out.println("age = " + age);
        int i = Integer.parseInt(age);
        System.out.println("i = " + i);
    }

    // /main2/sub10?city=seoul&age=44
    @RequestMapping("/main2/sub10")
    public void sub10(@RequestParam("city") String city,
                      @RequestParam("age") int age) {
        System.out.println("city = " + city);
        System.out.println("age = " + age);

    }

    // request 파라미터의 이름이 메소드 파라미터와 같으면
    // 리퀘스트 파람의 밸류 속성을 생략 해도됌/
    // 걍 두개 이름같으면 생략가능
    // /main2/sub11?city=seoul&age=44
    @RequestMapping("/main2/sub11")
    public void sub11(@RequestParam String city,
                      @RequestParam int age) {
        System.out.println("city = " + city);
        System.out.println("age = " + age);
    }

    //리퀘스트 파람 생략가능
    // /main2/sub12?city=seoul&age=44
    @RequestMapping("/main2/sub12")
    public void sub12(String city, int age) {
        System.out.println("city = " + city);
        System.out.println("age = " + age);
    }

    //연습 : 아래 URL로 요청 올 때 적절히 처리하는 메소드 작성
    // /main2/sub13?email=gmail&score=88.8&married=true
    @RequestMapping("/main2/sub13")
    public void sub13(String email, double score, boolean married) {
        System.out.println("email = " + email);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }

    // /main2/sub14?email=gmail&score=88.8&married=true
    // /main2/sub14?score=88.8&married=true
    // /main2/sub14?married=true
    @RequestMapping("/main2/sub14")
    public void sub14(@RequestParam(required = false) String email,
                      @RequestParam(required = false) Double score,
                      Boolean married) {
        System.out.println("email = " + email);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }

    //값이 존재하지 않을 떄 기본 값을 줄 수 있음
    @RequestMapping("/main2/sub15")
    public void sub15(@RequestParam(required = false, defaultValue = "") String email,
                      @RequestParam(required = false, defaultValue = "0") Double score,
                      @RequestParam(required = false, defaultValue = "false") Boolean married) {
        System.out.println("email = " + email);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }

    //기본값이 있으면 required 는 false로 세팅됌.
    @RequestMapping("/main2/sub16")
    public void sub16(@RequestParam(defaultValue = "") String email,
                      @RequestParam(defaultValue = "0") Double score,
                      @RequestParam(defaultValue = "false") Boolean married) {
        System.out.println("email = " + email);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }


    //연습 :
    // /main2/sub17?city=seoul&home=jeju&age=33
    // /main2/sub17?&home=jeju&age=33
    // /main2/sub17?&age=33
    // /main2/sub17
    //city 기본값 ""
    //home 기본값 ""
    //home 기본값 "0"
    @RequestMapping("/main2/sub17")
    public void sub17(@RequestParam(defaultValue = "") String city,
                      @RequestParam(defaultValue = "") String home,
                      @RequestParam(defaultValue = "0") int age) {
        System.out.println("city = " + city);
        System.out.println("home = " + home);
        System.out.println("age = " + age);
    }

    // 하나의 request parameter(요청 파라미터), 요청 변수)가 여러 값일 때
    // /main2/sub18?city=seoul&city=jeju&city=busan
    @RequestMapping("/main2/sub18")
    public void method18(String[] city) {
        System.out.println("Arrays.toString(city) = " + Arrays.toString(city));
    }

    // /main2/sub19?city=seoul&city=jeju&city=busan
    @RequestMapping("/main2/sub19")
    public void method19(@RequestParam(value = "city", defaultValue = "") ArrayList<String> city) {
        System.out.println(city);
    }

    // /main2/sub20?country=korea&score=90&score=80&score=70
    @RequestMapping("/main2/sub20")
    public void method20(String country,
                         @RequestParam(value = "score", defaultValue = "0")
                         ArrayList<Integer> score) {
        System.out.println("country = " + country);
        System.out.println("score = " + score);
    }

    // /main2/sub21?city=서울&email=gmail&address=신촌&age=88&score=98&married=true
    @RequestMapping("/main2/sub21")
    public void method21(
            String city,
            String email,
            String address,
            Integer age,
            Double score,
            Boolean married) {
        System.out.println("city = " + city);
        System.out.println("email = " + email);
        System.out.println("address = " + address);
        System.out.println("age = " + age);
        System.out.println("score = " + score);
        System.out.println("married = " + married);

    }


    // /main2/sub21?city=서울&email=gmail&address=신촌&age=88&score=98&married=true
    @RequestMapping("/main2/sub22")
    public void method22(@RequestParam Map<String, Objects> params) {
        for (var entry : params.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }


    // /main2/sub23?city=서울&email=gmail&address=신촌&age=88&score=98&score=87&score=85&married=true
    @RequestMapping("/main2/sub23")
    public void method23(@RequestParam MultiValueMap<String, Objects> params) {
        System.out.println();
        for (var entry : params.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    @RequestMapping("/main2/sub24")
    public void method24(WebRequest request) {
        Class<? extends WebRequest> a = request.getClass();
        System.out.println("a = " + a);
    }

}
