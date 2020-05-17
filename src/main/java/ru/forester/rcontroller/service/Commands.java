package ru.forester.rcontroller.service;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public interface Commands {

    String FIFO_DIR = "/home/pi/FIFO";
    String SHOW_FILMS = "ls /mnt/local_share/MEDIA";
    String SHOW_SHARED = "ls /mnt/local_share/";
    String MOUNT = "mount -t cifs -o user=pi,password=zcbm0000 //192.168.1.66/Shared /mnt/local_share";
    String RUN_FILM = "omxplayer -o local /mnt/local_share/MEDIA/%s < " + FIFO_DIR;

    String OMX_COMMAND = "echo -n %s > " + FIFO_DIR;

    String START_FILM = format(OMX_COMMAND, ".");
    String STOP_FILM = format(OMX_COMMAND, "q");

    String GREP_OMX = "ps aux | grep omx";

    Map<String, String> ACTIONS = new HashMap<>(){{
        put("seek+30", "$RIGHT_ARROW");
        put("seek-30", "$LEFT_ARROW");
        put("seek+600", "$UP_ARROW");
        put("seek-600", "$DOWN_ARROW");
        put("pause", "p");
        put("volumeUp", "+");
        put("volumeDown", "-");
        put("stop", "q");
    }};

    String FREE_MEM = "free -m";
}
