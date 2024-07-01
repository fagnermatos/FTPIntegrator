package io.fagner.integrator;

import io.fagner.integrator.file.FileDTO;
import lombok.AllArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FTPListener extends RouteBuilder {

    private final FTPConfiguration ftpConfiguration;
    private final AppConfiguration appConfiguration;


    @Override
    public void configure() {
        from(STR."""
                    \{ftpConfiguration.url}?
                    password=\{ftpConfiguration.password}&
                    ftpClient.dataTimeout=\{ftpConfiguration.ftpClientDataTimeout}&
                    passiveMode=\{ftpConfiguration.passiveMode}&
                    readLock=\{ftpConfiguration.readLock}&
                    delete=\{ftpConfiguration.delete}&
                    noop=\{ftpConfiguration.noop}&
                    resumeDownload=\{ftpConfiguration.resumeDownload}&
                    localWorkDirectory=\{ftpConfiguration.localWorkDirectory}&
                    binary=\{ftpConfiguration.binary}&
                    transferLoggingLevel=\{ftpConfiguration.transferLoggingLevel}&
                    idempotent=\{ftpConfiguration.idempotent}&
                    sendEmptyMessageWhenIdle=\{ftpConfiguration.sendEmptyMessageWhenIdle}&
                    maximumReconnectAttempts=\{ftpConfiguration.maximumReconnectAttempts}&
                    reconnectDelay=\{ftpConfiguration.reconnectDelay}&
                    maxMessagesPerPoll=\{ftpConfiguration.maxMessagesPerPoll}&
                    delay=\{ftpConfiguration.delay}&
                    runLoggingLevel=\{ftpConfiguration.runLoggingLevel}
                """)
                .choice()
                .when(body().isNotNull())
                .to(STR."file://\{appConfiguration.processingFolder}")
                .choice()
                .when(body().isNotNull())
                .setBody(this::getFile)
                .to( "bean:fileService?method=save");
    }

    private FileDTO getFile(Exchange exchange) {
        return new FileDTO(exchange.getIn().toString());
    }
}