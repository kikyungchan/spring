package com.example.spring.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MyBean312 {
    Double score;
    String className;
    String location;
    MultipartFile[] uploads;
}
