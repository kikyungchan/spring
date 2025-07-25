package com.example.core.app13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App13 {
    public static void main(String[] args) {
        var context = SpringApplication.run(App13.class, args);
        Controller1 bean = context.getBean(Controller1.class);
        // 문제 없이 실행되게
        // Service1에 @Component 붙이지 않기
        // AppConfiguration  클래스와 그 안의 메소드
        // 적절한 annotation들 적용하기
        bean.get();

    }
}