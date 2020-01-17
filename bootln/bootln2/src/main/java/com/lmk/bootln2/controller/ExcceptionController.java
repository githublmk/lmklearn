package com.lmk.bootln2.controller;

import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExcceptionController {

    @ExceptionHandler
    public String ExceptionHandler(Exception e,Model model){
        System.out.println(e.getMessage());
        e.printStackTrace();
        model.addAttribute("value",e.getMessage());
        return "error";
    }
}
