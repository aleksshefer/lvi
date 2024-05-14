package ru.shefer.service;

import org.springframework.stereotype.Service;
import ru.shefer.entity.Topic;
import ru.shefer.repository.TopicRepository;

@Service
public class TopicService {
    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Topic save(Topic topic) {
        return topicRepository.save(topic);
    }
}
