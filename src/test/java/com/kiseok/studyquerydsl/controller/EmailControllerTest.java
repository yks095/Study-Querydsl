package com.kiseok.studyquerydsl.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kiseok.studyquerydsl.domain.EmailDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit4.statements.SpringRepeat;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class EmailControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void email() throws Exception{
        EmailDto dto = EmailDto.builder()
                .to("rltjr219@gmail.com")
                .subject("[공지] 가입 안내")
                .text("반갑습니다!")
                .build();

        mockMvc.perform(post("/api/suggestion")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }
}