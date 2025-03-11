package com.content.approval.system.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.content.approval.system.dto.VideoUploadRequest;
import com.content.approval.system.service.VideoService;

@RestController
@RequestMapping("/api/editor")
public class EditorController {
    private final VideoService videoService;

    public EditorController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping("/upload-edited")
    public String uploadEditedVideo(@RequestBody VideoUploadRequest request) {
        videoService.uploadEditedVideoToGCP(request);
        return "Edited video uploaded!";
    }
}

