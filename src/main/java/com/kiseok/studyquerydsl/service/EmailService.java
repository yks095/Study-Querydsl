package com.kiseok.studyquerydsl.service;

import com.kiseok.studyquerydsl.domain.EmailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    private final MailContentBuilder mailContentBuilder;

    public ResponseEntity<?> sendSimpleMessage(EmailDto emailDto)   {
        this.createMessage(emailDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void createMessage(EmailDto emailDto) {

        String content = mailContentBuilder.build(emailDto.getText());

        MimeMessagePreparator message = mimeMessage -> {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setFrom("KAKAO");
            mimeMessageHelper.setTo(emailDto.getTo());
            mimeMessageHelper.setSubject(emailDto.getSubject());
            mimeMessageHelper.setText(content, true);
        };
        javaMailSender.send(message);
    }

}
