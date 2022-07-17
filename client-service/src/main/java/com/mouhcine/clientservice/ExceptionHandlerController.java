package com.mouhcine.clientservice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(Exception.class)
    public Map<String , String> error(Exception e){
        HashMap<String, String> map = new HashMap<>();
        map.put("message" , e.getMessage());
        return map;
    }
}
