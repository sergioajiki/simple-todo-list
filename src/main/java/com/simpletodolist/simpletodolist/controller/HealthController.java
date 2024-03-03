package com.simpletodolist.simpletodolist.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Health")
@RequestMapping("/health")
@CrossOrigin
public class HealthController {
    @GetMapping
    public static String sayHello() {
        return "To Do List - Success!!";
    }
}
