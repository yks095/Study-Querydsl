package com.kiseok.studyquerydsl.domain;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class EmailDto {

    private String to;

    private String subject;

    private String text;

}
