package com.dotarsoyak.blog.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private Long postId;
    private String comment;
    private Long authorId;
    @Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private Date created;

    private Post post;

    @ManyToOne
    @JoinColumn(name="id", nullable=true)
    public Post getPost(){
        return this.post;
    }

    public Comment(){
        super();
    }

    public Long getPostId() {
        return postId;
    }

    public String getComment() {
        return comment;
    }

    public Long getAuthorId() {
        return authorId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", postId=" + postId +
                ", comment='" + comment + '\'' +
                ", authorId=" + authorId +
                ", created=" + created +
                '}';
    }
}
