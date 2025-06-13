package com.example.core.app13;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Controller1 {
    final Service1 service1;

    public void get() {
        service1.crud();
    }
}
@Configuration
class AppConfiguration {
    @Bean // 이 spring bean의 이름은 메소드 이름으로 결정
    public Service1 makeBean() {
        return new Service1();
    }
}