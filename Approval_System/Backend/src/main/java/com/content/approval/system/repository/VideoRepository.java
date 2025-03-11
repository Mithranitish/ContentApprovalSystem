package com.content.approval.system.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.content.approval.system.model.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
}

