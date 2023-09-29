package com.dotarsoyak.blog.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String title;
    private String content;
    private Integer authorId;

    //bidirectinal
    //@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> comment = new ArrayList<>();

    //@Column(columnDefinition = "DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private Date created = Date.from(Instant.now());

    //@Column(columnDefinition = "DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP")
    private Date updated;

    public Post() {
        super();
    }

    public Post(String title, String content, Integer authorId, List<Comment> comment) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", authorId='" + authorId + '\'' +
                ", comments=" + comment +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public List<Comment> getComments() {
        return this.comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }
}
