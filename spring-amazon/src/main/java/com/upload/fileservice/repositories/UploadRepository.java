package com.upload.fileservice.repositories;

import com.upload.fileservice.domain.Upload;
import org.springframework.data.repository.CrudRepository;

public interface UploadRepository extends CrudRepository<Upload, Long> {
    Upload findByTitle(String title);
}
