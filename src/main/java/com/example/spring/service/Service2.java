package com.example.spring.service;

import com.example.spring.entity.*;
import com.example.spring.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class Service2 {

    private final Entity1Repository entity1Repository;
    private final Entity2Repository entity2Repository;
    private final Entity3Repository entity3Repository;
    private final Entity4Repository entity4Repository;
    private final Entity5Repository entity5Repository;
    private final Entity10Repository entity10Repository;
    private final Entity11Repository entity11Repository;
    private final Entity12Repository entity12Repository;
    private final Entity13Repository entity13Repository;
    private final Entity14Repository entity14Repository;
    private final Entity15Repository entity15Repository;


    public String process1() {
        System.out.println("Service2 process1 메소드 실행");
        return "process1";
    }

    public void process2() {
        // 비지니스 로직

        // spring data jpa 를 사용해서 crud
        Entity1 res = entity1Repository.findById(1).get();
        System.out.println(res.getId());
        System.out.println(res.getName());
        System.out.println(res.getAddress());
        System.out.println(res.getCity());

    }

    public void process3() {
        Entity2 data = entity2Repository.findById(2).get();
        System.out.println("data = " + data);
    }

    // jpa 사용
    // 1. Entity

    /// / : table과 1대1 매칭되는 클래스
    /// / : 이 클래스로 만든 각 객체는 table의 각 행과 매치됨
    /// / : @Entity,@Table(클래스-테이블)
    /// / : @Column(클래스필드와 - 테이블컬럼)
    /// / : @Id(클래스필드 - 테이블PK)

    //     2. Repository
    public void process4() {
        Entity3 data = entity3Repository.findById(1).get();
        System.out.println("data" + data);
    }

    public void process5() {
        Entity4 res = entity4Repository.findById(1).get();
    }

    public void process6() {
        Entity5 res = entity5Repository.findById(1).get();
        System.out.println("res = " + res);
    }

    public void process7() {
        // findById : 키(id)로 하나의 record(row)를 조회 함
        Optional<Entity10> data = entity10Repository.findById(1);

        System.out.println(data.isPresent());//false
        System.out.println(data.isEmpty());//true

    }

    public void process8() {
        Optional<Entity11> data = entity11Repository.findById(1);
        System.out.println("data = " + data);
        System.out.println(data.isPresent());
        System.out.println(data.isEmpty());
    }

    public void process9() {
        Optional<Entity12> data = entity12Repository.findById(1);
        System.out.println(data.isPresent());
        System.out.println(data.isEmpty());
    }

    public void process10() {
        Optional<Entity13> data = entity13Repository.findById(1);
        System.out.println(data.isPresent());
        System.out.println(data.isEmpty());
    }

    //SELECT
    // findById(key) : key에 해당하는 record를 저장한 Entity 객체를 리턴 (Optional)
    public Entity14 process11(Integer id) {
        Optional<Entity14> data = entity14Repository.findById(id);
        if (data.isPresent()) {
            return data.get();
        }
        return null;
    }

    public void process12(String name, Double score, String city) {
        //INSERT
        //save : 해당 entity를 새 record로 입력
        // 해당 entity에 매핑되는 record를 업데이트
        Entity14 data = new Entity14();
        data.setName(name);
        data.setScore(score);
        data.setCity(city);
        entity14Repository.save(data);

    }
    public void process13(String address, Integer price, LocalDateTime insertedAt) {
        Entity15 data = new Entity15();
        data.setAddress(address);
        data.setPrice(price);
        data.setInsertedAt(insertedAt);
        entity15Repository.save(data);
    }

    public void process14(Integer id,Double score) {
        //1.조회하고
        Entity14 data = entity14Repository.findById(id).get();
        //2. 값 변경하고
//        data.setName("강");
        data.setScore(score);
        //3. save
        entity14Repository.save(data);
    }

    public void process15(Integer id, String address) {
        //조회
        Entity15 data = entity15Repository.findById(id).get();
        //변경
        data.setAddress("강남");
        //저장
        entity15Repository.save(data);

    }

    public void process16(Integer id) {
        entity14Repository.deleteById(id);
    }

    public void process17(Integer id) {
        entity15Repository.deleteById(id);
    }
}
