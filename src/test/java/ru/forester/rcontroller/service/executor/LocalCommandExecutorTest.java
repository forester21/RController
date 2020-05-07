package ru.forester.rcontroller.service.executor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalCommandExecutorTest {

//    @Test
    void name() {
        System.out.println(new LocalCommandExecutor().exec("ps aux | grep java"));
    }
}