package ru.shefer.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.shefer.entity.User;

import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);

    Optional<User> findByEmail(String email);
}
