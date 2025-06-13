package com.example.core.app11;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Bean2 {
    public void crud() {
        System.out.println("Bean2.crud");
    }
}