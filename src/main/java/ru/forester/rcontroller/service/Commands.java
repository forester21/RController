package ru.forester.rcontroller.service;

import static java.lang.String.format;

public interface Commands {

    String FIFO_DIR = "/home/pi/FIFO";
    String SHOW_FILMS = "ls /mnt/local_share/MEDIA";
    String RUN_FILM = "omxplayer -o local /mnt/local_share/MEDIA/%s < " + FIFO_DIR;

    String OMX_COMMAND = "echo -n %s > " + FIFO_DIR;

    String START_FILM = format(OMX_COMMAND, ".");
    String STOP_FILM = format(OMX_COMMAND, "q");

    String GREP_OMX = "ps aux | grep omx";
}
