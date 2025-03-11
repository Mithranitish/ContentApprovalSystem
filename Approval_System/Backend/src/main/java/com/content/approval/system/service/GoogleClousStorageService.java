package com.content.approval.system.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.api.services.storage.Storage;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;

@Service
public class GoogleClousStorageService {

    @Autowired
    private Storage storage;

    private final String bucketName = "your-gcp-bucket-name";

    public String uploadFile(MultipartFile file) {
        try {
            String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
            BlobId blobId = BlobId.of(bucketName, fileName);
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(file.getContentType()).build();
            storage.create(blobInfo, file.getBytes());
            return "https://storage.googleapis.com/" + bucketName + "/" + fileName;
        } catch (Exception e) {
            throw new RuntimeException("Error uploading file to GCP", e);
        }
    }
}

