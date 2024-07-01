package io.fagner.integrator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Value("${processing.folder}")
    String processingFolder;

}
