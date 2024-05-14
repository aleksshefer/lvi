package ru.shefer.service.utilServices;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ru.shefer.view.Constants;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

@Service
public class CommandLineOutputService {
    private final BufferedWriter writer;

    public CommandLineOutputService() {
        this.writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    @SneakyThrows
    public void writeMessage(Constants constant) {
        writer.write(constant.getValue());
    }

    @SneakyThrows
    public void writeMessage(Constants constant, Object object) {
        writer.write(constant.getValue() + object.toString());
    }
}
