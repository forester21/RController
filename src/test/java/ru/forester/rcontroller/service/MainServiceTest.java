//package ru.forester.rcontroller.service;
//
//import lombok.SneakyThrows;
//import net.schmizz.sshj.SSHClient;
//import org.junit.jupiter.api.Test;
//
//class MainServiceTest {
//
//    public static final String OMX_CMD = "omxplayer -o local /mnt/local_share/MEDIA/Sex.Education.S02E06.Episode.6.1080p.NF.WEB-DL.DDP5.1.H264-EniaHD.mkv";
//
//    @SneakyThrows
//    @Test
//    public void doLS() {
//        MainService mainService = new MainService();
//        try (SSHClient ssh = mainService.buildClient()) {
//            mainService.exec(ssh, "ls /mnt/local_share/MEDIA");
////            mainService.exec(ssh, "omxplayer -o local /mnt/local_share/MEDIA/Sex.Education.S02E06.Episode.6.1080p.NF.WEB-DL.DDP5.1.H264-EniaHD.mkv");
//        }
//    }
//
//    @SneakyThrows
//    @Test
//    public void runOmx() {
//        MainService mainService = new MainService();
//        try (SSHClient ssh = mainService.buildClient()) {
//            mainService.exec(ssh, "omxplayer -o local /mnt/local_share/MEDIA/Sex.Education.S02E06.Episode.6.1080p.NF.WEB-DL.DDP5.1.H264-EniaHD.mkv < /home/pi/FIFO");
//        }
//    }
//
//    @SneakyThrows
//    @Test
//    public void sendCommandToOMX() {
//        MainService mainService = new MainService();
//        try (SSHClient ssh = mainService.buildClient()) {
//            mainService.exec(ssh, "echo -n . > /home/pi/FIFO");
//        }
//    }
//}