package com.dotarsoyak.blog.services;

import com.dotarsoyak.blog.entities.Comment;
import com.dotarsoyak.blog.entities.Post;
import jakarta.transaction.Transactional;

import java.util.Optional;

public interface CommentService {
    Comment save(Comment comment);
}
