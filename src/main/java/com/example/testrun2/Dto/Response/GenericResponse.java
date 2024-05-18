package com.example.testrun2.Dto.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GenericResponse {

    private String code;

    private String message;

    private Object data;

    private Object metaData;
}
