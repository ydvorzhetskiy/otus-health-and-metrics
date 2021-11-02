package ru.otus.healthandmetrics.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomHealthIndicator implements HealthIndicator {

    private final Random random = new Random();

    @Override
    public Health health() {
        boolean serverIsDown = random.nextBoolean();
        if (serverIsDown) {
            return Health.down()
                .status(Status.OUT_OF_SERVICE)
                .withDetail("message", "Караул!")
                .build();
        } else {
            return Health.up().withDetail("message", "Ура, товарищи!").build();
        }
    }
}
