package ru.shefer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.shefer.view.MainMenu;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.
                run(Application.class, args)
                .getBean(MainMenu.class).run();
    }
}