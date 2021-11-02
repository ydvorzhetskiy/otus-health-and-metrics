package ru.otus.healthandmetrics.rest;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MetricsCounter {

    private final MeterRegistry registry;

    @GetMapping("/counter")
    public void counter() {
        registry.counter("counter.example", Tags.empty())
            .increment();
    }

    @GetMapping("/gauge")
    public void gauge() {
        registry.gauge("gauge.example", Math.random());
    }
}
