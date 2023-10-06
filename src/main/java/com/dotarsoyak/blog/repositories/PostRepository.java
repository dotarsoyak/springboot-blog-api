package com.dotarsoyak.blog.repositories;

import com.dotarsoyak.blog.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>,
        PagingAndSortingRepository<Post, Long> {
    List<Post> findAll();
}
