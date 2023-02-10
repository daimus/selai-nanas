package com.upload.fileservice.service;

import com.upload.fileservice.domain.Upload;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UploadService {
    Upload saveTodo(String title, String description, MultipartFile file);

    byte[] downloadTodoImage(Long id);

    List<Upload> getAllTodos();
}
