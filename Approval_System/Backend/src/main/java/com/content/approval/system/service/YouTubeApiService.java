package com.content.approval.system.service;

import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.content.approval.system.model.Video;
import com.google.api.client.http.InputStreamContent;

@Service
public class YouTubeApiService {

    @Autowired
    private YouTube youTube;

    public String uploadVideoToYouTube(Video video) {
        try {
            Video youtubeVideo = new Video();
            youtubeVideo.setSnippet(new VideoSnippet()
                    .setTitle(video.getTitle())
                    .setDescription(video.getDescription()));

            InputStreamContent mediaContent = new InputStreamContent(
                    "video/*", new URL(video.getEditedVideoUrl()).openStream());

            YouTube.Videos.Insert request = youTube.videos()
                    .insert("snippet,status", youtubeVideo, mediaContent);

            Video response = request.execute();
            return "https://www.youtube.com/watch?v=" + response.getId();
        } catch (Exception e) {
            throw new RuntimeException("Error uploading video to YouTube", e);
        }
    }
}
