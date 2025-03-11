package com.content.approval.system.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.content.approval.system.dto.VideoUploadRequest;
import com.content.approval.system.service.VideoService;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {
    private final VideoService videoService;

    public OwnerController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping("/upload")
    public String uploadVideo(@RequestBody VideoUploadRequest request) {
        videoService.uploadToGCP(request);
        return "Video uploaded successfully!";
    }

    @PostMapping("/approve/{videoId}")
    public String approveVideo(@PathVariable Long videoId) {
        videoService.approveVideo(videoId);
        return "Video approved and uploaded to YouTube!";
    }
}

