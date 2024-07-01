package io.fagner.integrator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FTPConfiguration {

    @Value("${apache.camel.ftp.url}")
    String url;

    @Value("${apache.camel.ftp.password}")
    String password;

    @Value("${apache.camel.ftp.ftpClient.dataTimeout}")
    Integer ftpClientDataTimeout;

    @Value("${apache.camel.ftp.passiveMode}")
    Boolean passiveMode;

    @Value("${apache.camel.ftp.readLock}")
    String readLock;

    @Value("${apache.camel.ftp.delete}")
    Boolean delete;

    @Value("${apache.camel.ftp.noop}")
    Boolean noop;

    @Value("${apache.camel.ftp.resumeDownload}")
    Boolean resumeDownload;

    @Value("${apache.camel.ftp.localWorkDirectory}")
    String localWorkDirectory;

    @Value("${apache.camel.ftp.binary}")
    Boolean binary;

    @Value("${apache.camel.ftp.transferLoggingLevel}")
    String transferLoggingLevel;

    @Value("${apache.camel.ftp.idempotent}")
    Boolean idempotent;

    @Value("${apache.camel.ftp.sendEmptyMessageWhenIdle}")
    Boolean sendEmptyMessageWhenIdle;

    @Value("${apache.camel.ftp.maximumReconnectAttempts}")
    String maximumReconnectAttempts;

    @Value("${apache.camel.ftp.reconnectDelay}")
    Integer reconnectDelay;

    @Value("${apache.camel.ftp.maxMessagesPerPoll}")
    Integer maxMessagesPerPoll;

    @Value("${apache.camel.ftp.delay}")
    Integer delay;

    @Value("${apache.camel.ftp.runLoggingLevel}")
    String runLoggingLevel;

}
