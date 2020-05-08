package ru.forester.rcontroller.service;

import com.mollin.yapi.YeelightDevice;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ScheduledThreadPoolExecutor;

import static com.mollin.yapi.enumeration.YeelightEffect.SMOOTH;
import static java.util.concurrent.TimeUnit.SECONDS;

@Service
@Slf4j
public class YeelightService {

    private YeelightDevice device;

    private ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(4);

    @SneakyThrows
    private synchronized YeelightDevice getYeelightInstance() {
        if (device == null) {
            device = new YeelightDevice("192.168.1.64");
            device.setEffect(SMOOTH);
        }
        return device;
    }

    public void turnOn() {
        executor.schedule(() -> {
            try {
                getYeelightInstance().setPower(true);
                getYeelightInstance().setBrightness(1);
            } catch (Exception e) {
                log.error("ERROR!", e);
            }
        }, 5, SECONDS);
    }

    public void turnOff() {
        executor.schedule(() -> {
            try {
                getYeelightInstance().setBrightness(1);
                getYeelightInstance().setPower(false);
            } catch (Exception e) {
                log.error("ERROR!", e);
            }
        }, 5, SECONDS);
    }

}
