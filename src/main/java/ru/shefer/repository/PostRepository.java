package ru.shefer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import ru.shefer.entity.Post;
import ru.shefer.entity.Topic;
import ru.shefer.entity.User;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTopic(@Param("topic") Topic topic);

    List<Post> findByAuthor(@Param("user") User user);
}
