package ru.shefer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.shefer.entity.Topic;
import ru.shefer.entity.User;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface TopicRepository extends JpaRepository<Topic, Long> {
    Topic findByName(@Param("name") String name);

    List<Topic> findByAuthor(@Param("author") User user);
}
