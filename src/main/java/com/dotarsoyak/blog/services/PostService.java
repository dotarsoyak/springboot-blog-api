package com.dotarsoyak.blog.services;

import com.dotarsoyak.blog.entities.Post;
import com.dotarsoyak.blog.models.PostRequest;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Post save(PostRequest postRequest);
    List<Post> findAll();

    Post create(Post post);

    Optional<Post> findById(Long id);
}
