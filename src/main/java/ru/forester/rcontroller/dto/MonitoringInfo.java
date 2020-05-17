package ru.forester.rcontroller.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MonitoringInfo {
    String usedMemory;
    String cpu;
    String freeDiskMemory;
    String usedDiskMemory;
}
