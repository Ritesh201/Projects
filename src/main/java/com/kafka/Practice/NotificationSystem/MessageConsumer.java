package com.kafka.Practice.NotificationSystem;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class MessageConsumer {
    public static void main(String[] args) {

        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "message-delivery");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        KafkaConsumer<String, Message> consumer =
                new KafkaConsumer<>(props);



        consumer.subscribe(Collections.singletonList("messages"));

        while (true) {
            ConsumerRecords<String, Message> records =
                    consumer.poll(Duration.ofMillis(100));

            for (ConsumerRecord<String, Message> record : records) {
                Message event = record.value();
                deliver(event);
            }
        }
    }

    private static void deliver(Message event) {
        System.out.println(
                "Delivering message from " +
                        event.getSender().name + " to " +
                        event.getReciever().name
        );
    }
}
