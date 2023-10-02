package com.dotarsoyak.blog;

import com.dotarsoyak.blog.entities.Comment;
import com.dotarsoyak.blog.entities.Post;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import jakarta.persistence.EntityManager;

import java.util.List;

@SpringBootApplication
public class SpringbootBlogApiApplication implements CommandLineRunner {

	@Autowired
	private EntityManager em;
	private static final Logger LOG = LoggerFactory.getLogger(SpringbootBlogApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBlogApiApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		/*LOG.info("Creating a new Comment");
		Comment comment = new Comment("This is a new comment", 12L, null);

		LOG.info("Creating a new Post");
		Post newPost = new Post("mi post","post content", 1, null);

		newPost.setComments(List.of(comment));;

		LOG.info("Persisting the post");
		em.persist(newPost);

		LOG.info("Persisting the comment");
		comment.setPost(newPost);
		em.persist(comment);

		LOG.info("--------------------------------------");
		LOG.info("Getting the post");

		var foundPost = em.find(Post.class, 1L);

		LOG.info("The post {} properties: ", foundPost);

		LOG.info("--------------------------------------");
		LOG.info("Getting the comment");

		var foundComment = em.find(Comment.class, 1L);

		LOG.info("The comment {} properties: ", foundComment);

		em.close();*/
	}
}
