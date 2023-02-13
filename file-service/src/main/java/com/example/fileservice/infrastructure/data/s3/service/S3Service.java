package com.example.fileservice.infrastructure.data.s3.service;

import com.amazonaws.services.s3.model.*;
import com.example.fileservice.infrastructure.data.s3.dto.BucketObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.amazonaws.services.s3.AmazonS3;

import java.io.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class S3Service {
    private final AmazonS3 amazonS3Client;
    @Value("${aws.s3.bucket}")
    private String AWS_S3_BUCKET_NAME;

    public BucketObject putObject(File file) {
        String fileName = file.getName();
        PutObjectRequest putObjectRequest = new PutObjectRequest(AWS_S3_BUCKET_NAME, fileName, file).withCannedAcl(CannedAccessControlList.PublicRead);
        PutObjectResult putObjectResult = amazonS3Client.putObject(putObjectRequest);
        BucketObject bucketObject = new BucketObject();
        bucketObject.setFileName(fileName);
        bucketObject.setUrl(amazonS3Client.getUrl(AWS_S3_BUCKET_NAME, fileName).toExternalForm());
        bucketObject.setMd5(putObjectResult.getContentMd5());
        return bucketObject;
    }
}
