package com.content.approval.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.content.approval.system.model.Video;
import com.content.approval.system.repository.VideoRepository;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private GoogleCloudStorageService gcpService;

    @Autowired
    private YouTubeApiService youtubeApiService;

    public Video uploadUneditedVideo(MultipartFile file, String title, String description) {
        String videoUrl = gcpService.uploadFile(file);
        Video video = new Video(title, description, videoUrl);
        return videoRepository.save(video);
    }

    public String getUneditedVideoUrl(Long videoId) {
        Video video = videoRepository.findById(videoId)
                .orElseThrow(() -> new RuntimeException("Video not found"));
        return video.getUneditedVideoUrl();
    }

    public Video uploadEditedVideo(Long videoId, MultipartFile file) {
        Video video = videoRepository.findById(videoId)
                .orElseThrow(() -> new RuntimeException("Video not found"));

        String editedVideoUrl = gcpService.uploadFile(file);
        video.setEditedVideoUrl(editedVideoUrl);
        video.setStatus("Pending");
        return videoRepository.save(video);
    }

    public Video approveVideo(Long videoId) {
        Video video = videoRepository.findById(videoId)
                .orElseThrow(() -> new RuntimeException("Video not found"));

        if (video.getEditedVideoUrl() == null) {
            throw new RuntimeException("No edited video uploaded");
        }

        String youtubeUrl = youtubeApiService.uploadVideoToYouTube(video);
        video.setYoutubeVideoUrl(youtubeUrl);
        video.setStatus("Approved");

        return videoRepository.save(video);
    }

    public Video rejectVideo(Long videoId, String comment) {
        Video video = videoRepository.findById(videoId)
                .orElseThrow(() -> new RuntimeException("Video not found"));

        video.setStatus("Rejected");
        video.setOwnerComment(comment);

        return videoRepository.save(video);
    }
}

