package com.dotarsoyak.blog.services;

import com.dotarsoyak.blog.entities.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Post save(Post post);
    List<Post> findAll();

    Optional<Post> findById(Long id);
}
