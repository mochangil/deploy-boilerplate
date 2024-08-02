package com.example.demo.service;

import com.example.demo.entity.Counter;
import com.example.demo.repository.CounterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CounterService {

    private final CounterRepository counterRepository;

    public void saveCounter() {
        Counter counter = new Counter(1L,0);
        counterRepository.save(counter);
    }

    // 현재 카운터 값 가져오기
    public int getCounterValue() {
        Optional<Counter> counter = counterRepository.findById(1L);
        return counter.map(Counter::getCountValue).orElse(0);
    }

    // 카운터 값 증가
    public int incrementCounter() {
        Counter counter = counterRepository.findById(1L).orElse(new Counter(1L, 0));
        counter.updateValue(counter.getCountValue() + 1);
        counterRepository.save(counter);
        return counter.getCountValue();
    }
}