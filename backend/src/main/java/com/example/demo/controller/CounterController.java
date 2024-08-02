package com.example.demo.controller;

import com.example.demo.service.CounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/counter")
@CrossOrigin(origins = "http://localhost:3000") // React 개발 서버에서의 요청 허용
public class CounterController {

    private final CounterService counterService;

    @GetMapping("/save")
    public void saveCounter(){
        counterService.saveCounter();
    }

    @GetMapping
    public int getCounter() {
        return counterService.getCounterValue();
    }

    @PostMapping("/increment")
    public int incrementCounter() {
        return counterService.incrementCounter();
    }
}