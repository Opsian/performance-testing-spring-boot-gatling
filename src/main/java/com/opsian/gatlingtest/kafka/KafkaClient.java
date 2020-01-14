package com.opsian.gatlingtest.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaClient {

    private KafkaProducer<String, String> producer;

    public KafkaClient() {
        producer = new KafkaProducer<>(kafkaProducerProperties());
    }

    private Properties kafkaProducerProperties() {
        Properties props = new Properties();

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "docker.for.mac.localhost:9092");
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "producer");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return props;
    }

    public void sendToKafka(String event) {
        ProducerRecord record = new ProducerRecord<String, String>("random-numbers", null, event);
        producer.send(record);
    }
}