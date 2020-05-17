package ru.forester.rcontroller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.forester.rcontroller.dto.MonitoringInfo;
import ru.forester.rcontroller.service.executor.CommandExecutor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static ru.forester.rcontroller.service.Commands.DISK_MEM;
import static ru.forester.rcontroller.service.Commands.FREE_MEM;

@Service
public class MonitoringService {

    @Autowired
    private CommandExecutor commandExecutor;

    public MonitoringInfo getMonitoringInfo(){
        Map<String, String> diskMemory = getDiskMemory();
        return new MonitoringInfo()
                .setUsedMemory(getUsedRamMemory())
                .setUsedDiskMemory(diskMemory.get("Use%"))
                .setFreeDiskMemory(diskMemory.get("Avail"));
    }

    private String getUsedRamMemory(){
        Map<String, String> values = getMapOfValuesFrom(commandExecutor.exec(FREE_MEM));
        return (parseInt(values.get("total")) - parseInt(values.get("available")))*100/parseInt(values.get("total")) + "%";
    }

    private Map<String, String> getDiskMemory(){
        return getMapOfValuesFrom(commandExecutor.exec(DISK_MEM));
    }

    private Map<String, String> getMapOfValuesFrom(String table){
        List<String> lines = table.lines().collect(toList());
        Iterator<String> titles = asList(lines.get(0).split("\\s+")).iterator();
        Iterator<String> values = asList(lines.get(1).substring(4).split("\\s+")).iterator();
        Map<String, String> valuesMap = new HashMap<>();
        while (titles.hasNext() && values.hasNext()) {
            valuesMap.put(titles.next(), values.next());
        }
        return valuesMap;
    }
}
