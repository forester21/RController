package ru.forester.rcontroller.service.executor;

import lombok.SneakyThrows;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.common.IOUtils;
import net.schmizz.sshj.connection.channel.direct.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("remote")
public class SshCommandExecutor implements CommandExecutor {

    @Autowired
    private SSHClient ssh;

    @Override
    @SneakyThrows
    public String exec(String command) {
        try (Session session = ssh.startSession()) {
            Session.Command cmd = session.exec(command);
            return IOUtils.readFully(cmd.getInputStream()).toString();
//            cmd.join(5, TimeUnit.SECONDS);
//            System.out.println("\n** exit status: " + cmd.getExitStatus());
        }
    }
}
