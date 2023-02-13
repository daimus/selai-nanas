package com.example.fileservice.infrastructure.data.s3.dto;

import lombok.Data;

@Data
public class BucketObject {
    private String fileName;
    private String md5;
    private String url;
}
