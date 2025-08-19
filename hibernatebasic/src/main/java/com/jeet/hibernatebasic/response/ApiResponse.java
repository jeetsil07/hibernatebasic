package com.jeet.hibernatebasic.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T>{
    private String message;
    private T data;
    private boolean success;
    private int statusCode;
}
