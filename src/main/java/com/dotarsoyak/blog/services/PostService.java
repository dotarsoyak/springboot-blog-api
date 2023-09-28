package com.dotarsoyak.blog.services;

import com.dotarsoyak.blog.entities.Post;

import java.util.List;

public interface PostService {
    Post save(Post post);
    List<Post> findAll();
}
