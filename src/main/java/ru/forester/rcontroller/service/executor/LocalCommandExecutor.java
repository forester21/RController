package ru.forester.rcontroller.service.executor;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.springframework.util.StringUtils.trimTrailingCharacter;

@Slf4j
@Component
@Profile("local")
public class LocalCommandExecutor implements CommandExecutor {

    @Override
    @SneakyThrows
    public String exec(String command) {
        String[] cmd = {"/bin/sh", "-c", command};
        Process process = Runtime.getRuntime().exec(cmd);
        StringBuilder sb = new StringBuilder();
        new BufferedReader(new InputStreamReader(process.getInputStream()))
                .lines()
                .forEach(it -> sb.append(it).append("\n"));
        process.waitFor();
        log.info(sb.toString());
        return trimTrailingCharacter(sb.toString(), '\n');
    }
}
