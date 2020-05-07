package ru.forester.rcontroller.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.forester.rcontroller.dto.Action;
import ru.forester.rcontroller.dto.Film;
import ru.forester.rcontroller.service.MainService;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/films")
    public List<String> getFilms(){
        log.info("Call to /films");
        return mainService.getFilms();
    }

    @PostMapping("/run-film")
    public void runFilm(@RequestBody Film film){
        mainService.runFilm(film.getName());
    }

    @PostMapping("/action")
    public void doAction(@RequestBody Action action){
        mainService.doAction(action.getValue());
    }
}
