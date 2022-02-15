package com.consumer.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.consumer.dtos.CarDTO;

@Component
public class CarConsumer {
	private static final Logger logger = LoggerFactory.getLogger(CarConsumer.class);
    
    @KafkaListener(
    	topics = "${topic.name}",
    	groupId = "${spring.kafka.consumer.group-id}",
    	containerFactory = "carKafkaListenerContainerFactory"
    )
    public void listenTopcCar(ConsumerRecord<String, CarDTO> record) {
    	logger.info("Partição: "+ record.partition());
    	logger.info("Mensagem: "+ record.value());
    }
}
