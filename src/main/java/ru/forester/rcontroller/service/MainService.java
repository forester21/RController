package ru.forester.rcontroller.service;

import lombok.SneakyThrows;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.common.IOUtils;
import net.schmizz.sshj.connection.channel.direct.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static ru.forester.rcontroller.service.Commands.*;

@Component
public class MainService {

    @Autowired
    private SSHClient ssh;

    public List<String> getFilms() {
        return parseFilms(exec(SHOW_FILMS));
    }

    private List<String> parseFilms(String films) {
        return films.lines().collect(toList());
    }

    @SneakyThrows
    public void runFilm(String filmName) {
        if (isFilmRunning()) {
            exec(STOP_FILM);
        }
        new Thread(() -> exec(format(RUN_FILM, filmName))).start();
        Thread.sleep(2000);
        exec(START_FILM);
    }

    private static Map<String, String> ACTIONS = new HashMap<>() {{
        this.put("seek+30", "$'\\x1b\\x5b\\x43'");
        this.put("seek-30", "$'\\x1b\\x5b\\x44'");
        this.put("seek+600", "$'\\x1b\\x5b\\x41'");
        this.put("seek-600", "$'\\x1b\\x5b\\x42'");
        this.put("pause", "p");
        this.put("volumeUp", "+");
        this.put("volumeDown", "-");
        this.put("stop", "q");
    }};

    public void doAction(String action) {
        if (!isFilmRunning() || !ACTIONS.containsKey(action)) {
            return;
        }
        exec(format(OMX_COMMAND, ACTIONS.get(action)));
    }

    private boolean isFilmRunning() {
        return exec(GREP_OMX).lines().count() > 2;
    }

    @SneakyThrows
    private String exec(String command) {
        try (Session session = ssh.startSession()) {
            Session.Command cmd = session.exec(command);
            return IOUtils.readFully(cmd.getInputStream()).toString();
//            cmd.join(5, TimeUnit.SECONDS);
//            System.out.println("\n** exit status: " + cmd.getExitStatus());
        }
    }
}
