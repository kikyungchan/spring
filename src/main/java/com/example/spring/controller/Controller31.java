package com.example.spring.controller;

import com.example.spring.dto.MyBean311;
import com.example.spring.dto.MyBean312;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@ResponseBody
@RequestMapping("/api/main31")
public class Controller31 {

    @PostMapping("sub1")
    public String sub1(
            @RequestParam("name") String name,
            @RequestParam("age") Integer age,
            @RequestParam("myFiles[]") MultipartFile[] files) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        if (files != null && files.length > 0) {
            for (MultipartFile file : files) {
                System.out.println("file = " + file.getOriginalFilename());
                System.out.println("file = " + file.getSize());
            }
        }
        return null;

    }

    @PostMapping("sub2")
    public String sub2(String address, Double score,
                       @RequestParam("yourFiles[]") MultipartFile[] yourFile) {
        System.out.println("address = " + address);
        System.out.println("score = " + score);
        if (yourFile != null && yourFile.length > 0) {
            for (MultipartFile file : yourFile) {
                System.out.println("file = " + file.getOriginalFilename());
                System.out.println("file = " + file.getSize());
            }
        }
        System.out.println();
        return null;
    }

    // 연습 : react에 세번째 버튼 클릭 시
    //  request handler method가 실행되도록 코드 작성
    // multiple file 전송
    @PostMapping("sub3")
    public String sub3(String city, @RequestParam("uploadFiles[]") MultipartFile[] files) {
        System.out.println("city = " + city);
        if (files != null && files.length > 0) {
            for (MultipartFile file : files) {
                System.out.println("file = " + file.getOriginalFilename());
                System.out.println("file = " + file.getSize());
            }
        }
        return null;
    }

    @PostMapping("sub4")
    public String sub4(MyBean311 dto) {
        System.out.println("dto.getAddress() = " + dto.getAddress());
        System.out.println("dto.getId() = " + dto.getId());
        System.out.println("dto.getUserName() = " + dto.getUserName());
        MultipartFile[] uploadFiles = dto.getUploadFiles();
        if (uploadFiles != null && uploadFiles.length > 0) {
            for (MultipartFile file : uploadFiles) {
                System.out.println("file = " + file.getOriginalFilename());
                System.out.println("file = " + file.getSize());
            }
        }
        return null;
    }

    @PostMapping("sub5")
    public String sub5(MyBean312 dto) {
        System.out.println("dto.getClassName() = " + dto.getClassName());
        System.out.println("dto.getScore() = " + dto.getScore());
        System.out.println("dto.getLocation() = " + dto.getLocation());
        MultipartFile[] uploads = dto.getUploads();
        if (uploads != null && uploads.length > 0) {
            for (MultipartFile file : uploads) {
                System.out.println("file = " + file.getOriginalFilename());
                System.out.println("file = " + file.getSize());
            }
        }
        return null;
    }

    @GetMapping("sub6/{city}")
    public String sub6(@PathVariable String city) {
        System.out.println("city = " + city);

        System.out.println("Controller31.sub6");
        return null;
    }

    @GetMapping("sub7/{id}")
    public String sub7(@PathVariable Integer id) {
        System.out.println("id = " + id);
        System.out.println("Controller31.sub7");
        return null;
    }
}
