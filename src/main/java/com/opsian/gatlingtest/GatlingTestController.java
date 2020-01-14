package com.opsian.gatlingtest;

import com.opsian.gatlingtest.kafka.KafkaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class GatlingTestController {

    private KafkaClient kafkaClient = new KafkaClient();
    private Random random = new Random();

    @GetMapping("/random")
    public int randomNumberHandler() {
        int randomNumber = random.nextInt();
        kafkaClient.sendToKafka(Integer.toString(randomNumber));

        return randomNumber;
    }
}
