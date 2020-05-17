package ru.forester.rcontroller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.forester.rcontroller.service.executor.CommandExecutor;

@Service
public class MainService {

    @Autowired
    private CommandExecutor executor;

    public void reboot() {
        executor.exec("reboot");
    }
}
