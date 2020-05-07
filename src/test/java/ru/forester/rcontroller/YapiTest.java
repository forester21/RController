package ru.forester.rcontroller;

import com.mollin.yapi.YeelightDevice;
import com.mollin.yapi.enumeration.YeelightEffect;
import org.junit.jupiter.api.Test;

public class YapiTest {

//    @Test
    void name() throws Exception {
        // Instantiate your device (with its IP)
        YeelightDevice device = new YeelightDevice("192.168.1.64");
        device.setEffect(YeelightEffect.SMOOTH);
        // Switch on the device
        device.setBrightness(1);
        device.toggle();
//        device.setBrightness(300);
        // Change device color
//        device.setRGB(255, 126, 0);
        // Change device brightness
//        device.setBrightness(200);

    }
}
