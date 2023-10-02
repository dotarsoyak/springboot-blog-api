package com.dotarsoyak.blog.services;

import com.dotarsoyak.blog.entities.Comment;
import com.dotarsoyak.blog.repositories.CommentRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private static final Logger LOG = LoggerFactory.getLogger(CommentServiceImpl.class);
    @Autowired
    private CommentRepository commentRepository;

    @Override
    @Transactional
    public Comment save(Comment comment) {
        Comment entity;
        LOG.info("Start saving comment");

        try{
            entity = this.commentRepository.save(comment);    
        }catch(Exception e){
            LOG.info("Excepción no controlada al guardar comentario.");
            return null;
        }
        LOG.info("End saving comment");

        return entity;
    }

}
