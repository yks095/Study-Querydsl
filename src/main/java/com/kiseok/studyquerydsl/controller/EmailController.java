package com.kiseok.studyquerydsl.controller;

import com.kiseok.studyquerydsl.domain.EmailDto;
import com.kiseok.studyquerydsl.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/suggestion")
public class EmailController {

    private final EmailService emailService;

    @PostMapping
    ResponseEntity<?> sendSuggestion(@RequestBody EmailDto emailDto)  {
        return emailService.sendSimpleMessage(emailDto);
    }

}
