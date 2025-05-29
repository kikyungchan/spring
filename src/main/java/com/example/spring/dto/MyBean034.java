package com.example.spring.dto;

import lombok.*;

@Getter // getter
@Setter // setter
@ToString // 투스트링
@EqualsAndHashCode // equals,hashCode
//@NoArgsConstructor // 기본생성자 파라미터X
@AllArgsConstructor // 모든 필드를 받는 생성자
@RequiredArgsConstructor // final 필드를 초기화 하는 생성자
public class MyBean034 {
    private String home;
    private final Integer age;
}
