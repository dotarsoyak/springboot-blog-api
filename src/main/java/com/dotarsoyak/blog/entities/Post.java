package com.dotarsoyak.blog.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Post {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String title;
    private String content;
    private Integer authorId;

    //bidirectinal
    @OneToMany(mappedBy = "post", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    //Unidirectional
    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();

    //@Column(columnDefinition = "DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private Date created = Date.from(Instant.now());

    //@Column(columnDefinition = "DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP")
    private Date updated;
    private Integer published = 0;

    public Post(String title, String content, Integer authorId, List<Comment> comments) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.comments = comments;
    }

}
