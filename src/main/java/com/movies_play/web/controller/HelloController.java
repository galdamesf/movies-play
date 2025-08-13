package com.movies_play.web.controller;

import com.movies_play.domain.service.MoviesPlayService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final String platform;
    private  final MoviesPlayService aiService;

    public HelloController(@Value("${spring.application.name}") String platform, MoviesPlayService aiService) {
        this.platform = platform;
        this.aiService = aiService;
    }

    @GetMapping("/hello")
    public String hello(){
        return this.aiService.generateGreeting(platform);
    }

}
