package ru.shefer.service;

import org.springframework.stereotype.Service;
import ru.shefer.entity.Post;
import ru.shefer.entity.Topic;
import ru.shefer.repository.PostRepository;
import ru.shefer.service.utilServices.ChosenTopicService;
import ru.shefer.service.utilServices.LoggedUserService;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final LoggedUserService loggedUserService;
    private final ChosenTopicService chosenTopicService;

    public PostService(PostRepository postRepository,
                       LoggedUserService loggedUserService,
                       ChosenTopicService chosenTopicService) {
        this.postRepository = postRepository;
        this.loggedUserService = loggedUserService;
        this.chosenTopicService = chosenTopicService;
    }

    public List<Post> findByTopic(Topic topic) {
        return postRepository.findByTopic(topic);
    }

    public void save(String content) {
        Post postToSave = new Post();
        postToSave.setAuthor(loggedUserService.getLoggedUser());
        postToSave.setDate(Date.from(Instant.now()));
        postToSave.setTopic(chosenTopicService.getChosenTopic());
        postToSave.setText(content);

        postRepository.save(postToSave);
    }
}
