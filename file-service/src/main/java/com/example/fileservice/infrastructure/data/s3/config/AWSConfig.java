package com.example.fileservice.infrastructure.data.s3.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSConfig {
    @Value("${aws.secret.key}")
    private String AWS_SECRET_KEY;
    @Value("${aws.access.key}")
    private String AWS_ACCESS_KEY;
    public AWSCredentials credentials() {
        AWSCredentials credentials = new BasicAWSCredentials(
                AWS_ACCESS_KEY,
                AWS_SECRET_KEY
        );
        return credentials;
    }

    @Bean
    public AmazonS3 amazonS3() {
        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials()))
                .withRegion(Regions.AP_SOUTHEAST_1)
                .build();
        return s3client;
    }
}
