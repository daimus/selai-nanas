package com.upload.fileservice.service;

import com.upload.fileservice.config.BucketName;
import com.upload.fileservice.domain.Upload;
import com.upload.fileservice.repositories.UploadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.apache.http.entity.ContentType.*;

@Service
@AllArgsConstructor
public class UploadServiceImpl implements UploadService {
    private final FileStore fileStore;
    private final UploadRepository repository;

    @Override
    public Upload saveTodo(String title, String description, MultipartFile file) {
        //check if the file is empty
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file");
        }
        //Check if the file is an image
        if (!Arrays.asList(IMAGE_PNG.getMimeType(),
                IMAGE_BMP.getMimeType(),
                IMAGE_GIF.getMimeType(),
                IMAGE_JPEG.getMimeType()).contains(file.getContentType())) {
            throw new IllegalStateException("FIle uploaded is not an image");
        }
        //get file metadata
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));
        //Save Image in S3 and then save Upload in the database
        String path = String.format("%s/%s", BucketName.TODO_IMAGE.getBucketName(), UUID.randomUUID());
        String fileName = String.format("%s", file.getOriginalFilename());
        try {
            fileStore.upload(path, fileName, Optional.of(metadata), file.getInputStream());
        } catch (IOException e) {
            throw new IllegalStateException("Failed to upload file", e);
        }
        Upload upload = Upload.builder()
                .description(description)
                .title(title)
                .imagePath(path)
                .imageFileName(fileName)
                .build();
        repository.save(upload);
        return repository.findByTitle(upload.getTitle());
    }

    @Override
    public byte[] downloadTodoImage(Long id) {
        Upload upload = repository.findById(id).get();
        return fileStore.download(upload.getImagePath(), upload.getImageFileName());
    }

    @Override
    public List<Upload> getAllTodos() {
        List<Upload> uploads = new ArrayList<>();
        repository.findAll().forEach(uploads::add);
        return uploads;
    }
}
