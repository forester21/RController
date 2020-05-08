package ru.forester.rcontroller.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.forester.rcontroller.service.MainService;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/reboot")
    public void reboot(){
        mainService.reboot();
    }
}
