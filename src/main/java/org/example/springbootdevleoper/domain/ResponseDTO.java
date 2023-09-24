package org.example.springbootdevleoper.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter @Setter
public class ResponseDTO {

    private String error;
    private int result;
}
