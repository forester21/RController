package ru.forester.rcontroller.service;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class Constants {

    public static String FIFO_DIR = "/home/pi/FIFO";
    public static String SHOW_FILMS = "ls /mnt/local_share/MEDIA";
    public static String SHOW_SHARED = "ls /mnt/local_share/";
    public static String MOUNT = "mount -t cifs -o user=pi,password=zcbm0000 //192.168.1.66/Shared /mnt/local_share";
    public static String RUN_FILM = "omxplayer -o local /mnt/local_share/MEDIA/%s < " + FIFO_DIR;

    public static String OMX_COMMAND = "echo -n %s > " + FIFO_DIR;

    public static String START_FILM = format(OMX_COMMAND, ".");
    public static String STOP_FILM = format(OMX_COMMAND, "q");

    public static String GREP_OMX = "ps aux | grep omx";

    public static Map<String, String> ACTIONS = new HashMap<>();

    static {
        ACTIONS.put("seek+30", "$RIGHT_ARROW");
        ACTIONS.put("seek-30", "$LEFT_ARROW");
        ACTIONS.put("seek+600", "$UP_ARROW");
        ACTIONS.put("seek-600", "$DOWN_ARROW");
        ACTIONS.put("pause", "p");
        ACTIONS.put("volumeUp", "+");
        ACTIONS.put("volumeDown", "-");
        ACTIONS.put("stop", "q");
    };

}
