package com.kafka.Practice.NotificationSystem;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Collections;
import java.util.Properties;

public class MessageProducer {

    private final KafkaProducer<String, Message> producer;
    private static final String TOPIC = "messages";

    public MessageProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<>(props);
    }

    public void send(Message event) {
        ProducerRecord<String, Message> record =

                new ProducerRecord<>(TOPIC, event.getReciever().name, event);

        producer.send(record, (metadata, exception) -> {
            if (exception != null) {
                System.err.println("Failed to send message");
            }
        });
    }
}


