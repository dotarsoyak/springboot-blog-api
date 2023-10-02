package com.dotarsoyak.blog.entities;

import static jakarta.persistence.GenerationType.IDENTITY;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String comment;
    private Long authorId;
    //@Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private Date created = Date.from(Instant.now());

    //bidirectional relationship
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="post_id")
    @JsonIgnore
    private Post post;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public Date getCreated() {
        return created;
    }

    public Comment(){
        super();
    }

    public Comment(String comment, Long authorId, Post post) {
        this.comment = comment;
        this.authorId = authorId;
        this.post = post;
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
                ", comment='" + comment + '\'' +
                ", authorId=" + authorId +
                ", created=" + created +
                '}';
    }
}
