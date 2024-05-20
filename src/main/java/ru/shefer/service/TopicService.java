package ru.shefer.service;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shefer.entity.Topic;
import ru.shefer.repository.TopicRepository;

import java.util.List;

@Service
public class TopicService {
    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public void save(Topic topic) {
        topicRepository.save(topic);
    }

    @Transactional(readOnly = true)
    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

    public Topic findByNameContains(String name) {
        return topicRepository.findByNameContainingIgnoreCase(name);
    }

    public void delete(Topic topic) {
        topicRepository.delete(topic);
    }
}
