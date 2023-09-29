package com.dotarsoyak.blog.services;

import com.dotarsoyak.blog.entities.Post;
import com.dotarsoyak.blog.repositories.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    @Transactional
    public Post save(Post post){
        return this.postRepository.save(post);
    }

    @Override
    public List<Post> findAll() {
        return this.postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return this.postRepository.findById(id);
    }
}
