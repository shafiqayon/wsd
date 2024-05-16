package com.wsd.ayon.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/check")
public class CheckController {
    @GetMapping("")
    public String checkGet() {
        return "check 2";
    }
}
