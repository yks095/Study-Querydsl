package com.kiseok.studyquerydsl.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter @Setter
@ConfigurationProperties("mail")
@Component
public class MailProperties {

    private int port;
    private int socketPort;
    private boolean auth;
    private boolean starttls;
    private boolean starttls_required;
    private boolean fallback;
}
