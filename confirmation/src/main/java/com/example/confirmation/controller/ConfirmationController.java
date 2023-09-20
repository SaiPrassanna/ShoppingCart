package com.example.confirmation.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfirmationController {

    @GetMapping("/confirmation")
    public String showConfirmationPage() {
       
        return "confirmation";
    }
}