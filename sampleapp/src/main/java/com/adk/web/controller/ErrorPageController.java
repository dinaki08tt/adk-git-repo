package com.adk.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ErrorPageController {

    @RequestMapping("/errorPage")
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    public String showErrorPage(){
        return "404";
    }
    
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception e){
        return "404";
    }
}