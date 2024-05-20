package ru.shefer.service.utilServices;

import org.springframework.stereotype.Service;
import ru.shefer.entity.Topic;
import ru.shefer.exception.TopicIsNotChosenException;

@Service
public class ChosenTopicService {
    private Topic topic;

    public void chooseTopic(Topic topic) {
        this.topic = topic;
    }

    public void dropChosenTopic() {
        this.topic = null;
    }

    public boolean isTopicChosen() {
        return topic != null;
    }

    public Topic getChosenTopic() {
        if (topic == null) {
            throw new TopicIsNotChosenException("Topic is not chosen");
        }
        return topic;
    }
}
