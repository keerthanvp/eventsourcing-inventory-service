package com.vpk.tutorial.inventoryservice.config.kafka;

import com.vpk.tutorial.inventoryservice.events.InventoryEvent;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class InventoryEventProducerConfig {

    @Value("${spring.kafka.bootstrap-server}")
    private String BOOTSTRAP_SERVER;

    @Value("${spring.kafka.key-serializer}")
    private String KEY_SERIALIZER;

    @Value("${spring.kafka.value-serializer}")
    private String VALUE_SERIALIZER;

    @Bean
    public Map<String, Object> orderEventProducerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KEY_SERIALIZER);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, VALUE_SERIALIZER);
        return props;
    }

    @Bean
    public ProducerFactory<String, InventoryEvent> orderEventProducerFactory() {
        return new DefaultKafkaProducerFactory<>(orderEventProducerConfigs());
    }

    @Bean
    public KafkaTemplate<String, InventoryEvent> orderEventKafkaTemplate() {
        return new KafkaTemplate<>(orderEventProducerFactory());
    }

}

