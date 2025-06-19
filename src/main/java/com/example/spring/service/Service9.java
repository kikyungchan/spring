package com.example.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Transactional
@Service
@RequiredArgsConstructor
public class Service9 {

    public void action1(String username, MultipartFile upload) {
        System.out.println("username = " + username);
        System.out.println("upload = " + upload.getOriginalFilename());
        try {
            InputStream is = upload.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);

            String filePath = "C:/Temp/uploadFiles/" + upload.getOriginalFilename();

            OutputStream os = new FileOutputStream(filePath);
            BufferedOutputStream bos = new BufferedOutputStream(os);

            try (bos; os; bis; is) {

                byte[] buffer = new byte[1024];
                int length;

                while ((length = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, length);
                }
                bos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new RuntimeException(e);
        }
    }

    public void action2(String address, MultipartFile upload) {
        System.out.println(address);
        System.out.println("upload = " + upload);
        if (upload != null) {
            if (upload.getSize() > 0) {
                try {
                    String filePath = "C:/Temp/uploadFiles/" + upload.getOriginalFilename();
                    OutputStream os = new FileOutputStream(filePath);
                    BufferedOutputStream bos = new BufferedOutputStream(os);
                    InputStream is = upload.getInputStream();
                    BufferedInputStream bis = new BufferedInputStream(is);

                    try (bis; bos; os; is) {
//                        is.transferTo(bos);
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = is.read(buffer)) != -1) {
                            bos.write(buffer, 0, length);
                        }
                        bos.flush();
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void action3(MultipartFile[] upload) {
        if (upload != null) {
            for (MultipartFile file : upload) {
                try {
                    if (file.getSize() > 0) {
                        String Path = "C:/Temp/uploadFiles/" + file.getOriginalFilename();
                        var bis = new BufferedInputStream(file.getInputStream());
                        var bos = new BufferedOutputStream(new FileOutputStream(Path));
                        try (bos; bis) {
                            byte[] buffer = new byte[1024];
                            int length;
                            while ((length = bis.read(buffer)) != -1) {
                                bos.write(buffer, 0, length);
                            }
                            bos.flush();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void action4(MultipartFile[] upload) {
        //업로드가 널이 아니면
        if (upload != null) {
            for (MultipartFile file : upload) {
                try {
                        //파일의 사이즈가 0보다 크면
                    if (file.getSize() > 0) {
                        String path = "C:/Temp/uploadFiles/" + file.getOriginalFilename();
                        var bis = new BufferedInputStream(file.getInputStream());
                        var bos = new BufferedOutputStream(new FileOutputStream(path));
                        try (bis; bos) {

                            byte[] buffer = new byte[1024];
                            int length;
                            while ((length = bis.read(buffer)) != -1) {
                                bos.write(buffer, 0, length);
                            }
                            bos.flush();
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
