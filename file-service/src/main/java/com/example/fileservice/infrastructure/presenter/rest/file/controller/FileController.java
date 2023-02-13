package com.example.fileservice.infrastructure.presenter.rest.file.controller;

import com.example.fileservice.infrastructure.data.s3.dto.BucketObject;
import com.example.fileservice.infrastructure.data.s3.service.S3Service;
import com.example.fileservice.infrastructure.presenter.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileController {
    private final S3Service s3Service;
    @PostMapping
    public ResponseEntity<Object> upload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        Response response = new Response();
        String fileName = multipartFile.getOriginalFilename();
        File file = new File(System.getProperty("java.io.tmpdir")+"/"+fileName);
        multipartFile.transferTo(file);
        BucketObject bucketObject = s3Service.putObject(file);
        response.setData(bucketObject);
        response.setHttpCode(201);
        return response.getResponse();
    }
}
