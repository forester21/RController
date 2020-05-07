package ru.forester.rcontroller.service;

import com.mollin.yapi.YeelightDevice;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.mollin.yapi.enumeration.YeelightEffect.SMOOTH;

@Service
@Slf4j
public class YeelightService {

    private YeelightDevice device;

    @SneakyThrows
    private synchronized YeelightDevice getYeelightInstance() {
        if (device == null) {
            device = new YeelightDevice("192.168.1.64");
            device.setEffect(SMOOTH);
        }
        return device;
    }

    public void turnOn() {
        try {
            getYeelightInstance().setPower(true);
            getYeelightInstance().setBrightness(1);
        } catch (Exception e) {
            log.error("ERROR!", e);
        }
    }

    public void turnOff() {
        try {
            getYeelightInstance().setBrightness(1);
            getYeelightInstance().setPower(false);
        } catch (Exception e) {
            log.error("ERROR!", e);
        }
    }
}
