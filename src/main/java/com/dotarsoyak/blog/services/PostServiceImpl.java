package com.dotarsoyak.blog.services;

import com.dotarsoyak.blog.entities.Comment;
import com.dotarsoyak.blog.entities.Post;
import com.dotarsoyak.blog.models.PostRequest;
import com.dotarsoyak.blog.repositories.PostRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private EntityManager em;

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post save(PostRequest postRequest){
        Post post = PostRequest.map(postRequest);
        return this.postRepository.save(post);
    }

    @Transactional
    public Post create(Post post){
        em.persist(post);

        if(post.getComments() != null && post.getComments().size() > 0){
            for(Comment comment: post.getComments()){
                comment.setPost(post);
                em.persist(comment);
            }
        }

        em.flush();

        return post;
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
