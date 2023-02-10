package com.upload.fileservice.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BucketName {
    TODO_IMAGE("aws-bucket-alterra");
    private final String bucketName;
}
