package ru.shefer.service.utilServices;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ru.shefer.entity.Post;
import ru.shefer.entity.Topic;
import ru.shefer.service.commandLineActions.Action;
import ru.shefer.view.Constants;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.List;

import static ru.shefer.view.Constants.*;

@Service
public class CommandLineOutputService {
    private final BufferedWriter writer;

    public CommandLineOutputService() {
        this.writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    @SneakyThrows
    public void printMessage(Constants constant) {
        writer.write(constant.getValue());
        writer.flush();
    }

    @SneakyThrows
    public void printMessage(Constants constant, Object object) {
        writer.write(constant.getValue() + object.toString());
        writer.flush();
    }

    @SneakyThrows
    public void printTopicList(List<Topic> topicList) {
        writer.write(ALL_TOPICS_LIST.getValue());

        for (Topic topic : topicList) {
            writer.write(topic.customToString());
            writer.newLine();
        }
        writer.flush();
    }

    @SneakyThrows
    public void printPostList(List<Post> postList) {
        writer.write(ALL_POST_LIST.getValue());

        for (Post post : postList) {
            writer.write(post.customToString());
            writer.newLine();
        }
        writer.flush();
    }

    @SneakyThrows
    public void printMenuActions(List<Action> actionList) {
        int actionNumber = 1;
        writer.write(CHOOSE_ITEM.getValue());
        for (Action action : actionList) {
            writer.write(actionNumber + ". " + action.getActionName());
            writer.newLine();
            actionNumber++;
        }
        writer.flush();
    }
}
