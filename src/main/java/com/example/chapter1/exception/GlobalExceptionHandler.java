package com.example.chapter1.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ApiResponse<String> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ApiResponse<String> ar = new ApiResponse<>();
        ar.setMessage(e.getMessage());
        ar.setCode(ApiResponse.ERROR);
        ar.setData("something wrong happened!!!");
        ar.setUrl(req.getRequestURL().toString());
        return ar;
    }
}
