package com.example.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

public class DirectionsController {
    @GetMapping("/directions")
    public String getDirections(@RequestParam String origin,@RequestParam String destination){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://maps.googleapis.com/maps/api/directions/json?origin=" + origin + "&destination=" + destination + "&key=YOUR_API_KEY";
        String response = restTemplate.getForObject(url, String.class);
        return response;
    }
}
