package ru.forester.rcontroller.config;

import lombok.SneakyThrows;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.transport.verification.HostKeyVerifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.PublicKey;

@Configuration
public class SshClientConfig {

    @Bean
    @SneakyThrows
    public SSHClient buildClient() {
        final SSHClient ssh = new SSHClient();
        ssh.addHostKeyVerifier(new HostKeyVerifier() {
            @Override
            public boolean verify(String hostname, int port, PublicKey key) {
                return true;
            }
        });
        ssh.connect("192.168.1.70");
        ssh.authPassword("pi", "zcbm0000");
        return ssh;
    }
}
