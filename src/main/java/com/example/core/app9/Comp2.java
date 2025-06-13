package com.example.core.app9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Comp2 {
    Comp1 comp1;

//    @Autowired
    //생성자 하나면 오토와이어드 생략가능
    public Comp2(Comp1 comp1) {
        this.comp1 = comp1;
    }

    public void action1() {
        comp1.test();
    }
}