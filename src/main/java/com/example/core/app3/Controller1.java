package com.example.core.app3;

import org.springframework.stereotype.Component;

@Component("bean1")
// 이름을 제시하지 않으면
//클래스명을 lowerCamelCase 소문자로 바꾼 이름을 짓는다
public class Controller1 { // controller1
    public void method1() {
        System.out.println("Controller1.method1");
    }
}
