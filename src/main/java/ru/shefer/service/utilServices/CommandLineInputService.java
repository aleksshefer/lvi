package ru.shefer.service.utilServices;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class CommandLineInputService {
    private final BufferedReader reader;

    public CommandLineInputService() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @SneakyThrows
    public String readLine() {
        return reader.readLine();
    }
}
