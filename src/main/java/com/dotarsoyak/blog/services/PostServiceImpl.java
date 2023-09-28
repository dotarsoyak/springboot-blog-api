package com.dotarsoyak.blog.services;

import com.dotarsoyak.blog.entities.Post;
import com.dotarsoyak.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public Post save(Post post){
        return this.postRepository.save(post);
    }

    @Override
    public List<Post> findAll() {
        return this.postRepository.findAll();
    }
}
