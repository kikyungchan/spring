package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("main4")
public class Controller04 {

    // /main4/sub1
    @RequestMapping("sub1")
    @ResponseBody
    public String sub1() {
        // 1.요청 분석/가공
        // 2.요청 처리(business logic)

        // 3. 결과(html)응답

        String htmlCode = """
                <!DOCTYPE html>
                <html>
                <body>
                <h1>서버가 응답한 html코드</h1>
                <p>이렇게 html을 작성하는 것은 너무 고통스럽다</p>
                </body>
                </html>
                
                """;
        return htmlCode;

    }

    // /main4/sub2
    @RequestMapping("sub2")
    @ResponseBody
    public String sub2(String keyword) {
        String weather = switch (keyword) {
            case "서울" -> "날씨 맑음";
            case "울릉도" -> "바람 많이 붐";
            default -> "알 수 없음";
        };
        String htmlCode = """
                <!DOCTYPE html>
                <html>
                <body>
                <h1>검색한 지역의 날씨</h1>
                <h3>""" + weather + """
                </h3>
                </body>
                </html>
                
                """;
        return htmlCode;
    }

    @RequestMapping("sub3")
    public String sub3() {

        // 3.html코드응답

        // thymeleaf html 파일 위치
        // src/main/resources/templates/main4/sub3.html

        // view로 forward함
        return "main4/sub3";

    }

    //연습
    // /main4/sub4 로 요청 올때
    // 아래 html이 최종 응답 되도록 method
    // src/main/resoureces/templates/main4/sub4.html
    @RequestMapping("sub4")
    public String sub4() {

        return "main4/sub4";
    }
}
