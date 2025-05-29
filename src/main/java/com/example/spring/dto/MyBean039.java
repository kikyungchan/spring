package com.example.spring.dto;

public class MyBean039 {
    //연습
    //프로퍼티 만들기
    //name( 읽기,.쓰기),home(일기.쓰기),age(읽기,쓰기)
    private String nickName;
    private String house;
    private Integer number;

    public String getName() {
        return nickName;
    }

    public void setName(String name) {
        this.nickName = name;
    }

    public String getHome() {
        return house;
    }

    public void setHome(String home) {
        this.house = home;
    }

    public Integer getAge() {
        return number;
    }

    public void setAge(Integer age) {
        this.number = age;
    }
}
