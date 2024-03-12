package com.weimin.app1.controller;

import org.springframework.http.MediaType;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class IndexController {

    @GetMapping("/app1")
    public String test(){
        return "i am app1";
    }

    @PostMapping(value = "/upload",consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(@RequestPart("file") MultipartFile file){

        if(!ObjectUtils.isEmpty(file)){
            String originalFilename = file.getOriginalFilename();
            System.out.println(originalFilename);
            return originalFilename;
        }

        return "empty file";
    }

    @PostMapping(value = "/upload2",consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload2(@RequestPart("files") MultipartFile[] files){

        if(!ObjectUtils.isEmpty(files)){
            StringBuilder filesName = new StringBuilder();
            for (MultipartFile file : files) {
                filesName.append(", ").append(file.getOriginalFilename());
            }
            System.out.println("哈哈哈----"+filesName.toString());
            return filesName.toString();

        }

        return "empty file";
    }
}
