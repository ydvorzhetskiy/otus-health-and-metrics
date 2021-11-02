package ru.otus.healthandmetrics.rest;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MetricsCounter {

    private final MeterRegistry registry;

    @GetMapping("/counter")
    public void counter() {
        registry.counter("counter.example");
    }

    @GetMapping("/gauge")
    public void gauge() {
        registry.gauge("counter.example", Math.random());
    }
}
