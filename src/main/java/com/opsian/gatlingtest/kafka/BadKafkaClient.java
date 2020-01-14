package com.opsian.gatlingtest.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class BadKafkaClient {

    private BadKafkaClient() {}

    public static Properties kafkaProducerProperties() {
        Properties props = new Properties();

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "docker.for.mac.localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return props;
    }

    public static void sendToKafka(String event) {
        KafkaProducer<String, String> producer = new KafkaProducer<>(kafkaProducerProperties());
        ProducerRecord record = new ProducerRecord<String, String>("random-numbers", null, event);

        producer.send(record);
    }
}
