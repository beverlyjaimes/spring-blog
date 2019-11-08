package com.codeup.blog.blog.Repositories;

import com.codeup.blog.blog.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<PostImage, Integer> {
}
