package ru.forester.rcontroller.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.forester.rcontroller.service.executor.CommandExecutor;

import java.util.List;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static ru.forester.rcontroller.service.Constants.*;

@Slf4j
@Component
public class FilmService {

    @Autowired
    private CommandExecutor executor;

    @Autowired
    private YeelightService yeelightService;

    public List<String> getFilms() {
        mountSharedIfNeeded();
        return parseFilms(exec(SHOW_FILMS));
    }

    private List<String> parseFilms(String films) {
        return films.lines().collect(toList());
    }

    @SneakyThrows
    public void runFilm(String filmName) {
        if (isFilmRunning()) {
            log.info("Film is running!");
            exec(STOP_FILM);
        }
        yeelightService.turnOff();
        new Thread(() -> exec(format(RUN_FILM, escapeCharacters(filmName)))).start();
        Thread.sleep(2000);
        exec(START_FILM);
    }

    private void mountSharedIfNeeded(){
        if (exec(SHOW_SHARED).lines().count() == 0){
            exec(MOUNT);
        }
    }


    private String escapeCharacters(String str) {
        return str.replace(" ", "\\ ")
                .replace("(", "\\(")
                .replace(")", "\\)");
    }

    public void doAction(String action) {
        if (!isFilmRunning() || !ACTIONS.containsKey(action)) {
            log.info("Film is not running!");
            return;
        }
        exec(format(OMX_COMMAND, ACTIONS.get(action)));
        if ("stop".equals(action)){
            yeelightService.turnOn();
        }
    }

    private boolean isFilmRunning() {
        return exec(GREP_OMX).lines().count() > 2;
    }

    private String exec(String command) {
        log.info("Run: " + command);
        return executor.exec(command);
    }
}
