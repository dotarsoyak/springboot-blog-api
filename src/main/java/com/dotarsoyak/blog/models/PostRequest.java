package com.dotarsoyak.blog.models;

import com.dotarsoyak.blog.entities.Post;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PostRequest {
    private static final Integer PUBLISHED = 0;

    private Long id;

    @NotNull(message="Es necesario capturar un título.")
    @NotBlank(message = "Por favor capture el título.")
    private String title;
    @NotBlank(message = "Por favor capture el contenido del post.")
    private String content;
    private Integer authorId;
    private Date created = Date.from(Instant.now());
    private Date updated;
    private Integer published = 0;

    public static Post map(PostRequest postRequest){
        Post post = Post.build(0L, postRequest.getTitle()
                ,postRequest.getContent(), postRequest.getAuthorId(), null
                ,postRequest.getCreated(), postRequest.getUpdated(), PUBLISHED);

        return post;
    }

}
