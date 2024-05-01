package com.msa.rental.framework.kafkaatapder;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.msa.rental.application.outputport.EventOutputPort;
import com.msa.rental.domain.model.event.ItemRented;
import com.msa.rental.domain.model.event.ItemReturned;
import com.msa.rental.domain.model.event.OverdueCleared;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class RentalKafkaProducer implements EventOutputPort {

    @Value(value = "${producers.topic1.name}")
    private String TOPIC_RENT;
    @Value(value = "${producers.topic2.name}")
    private String TOPIC_RETURN;
    @Value(value = "${producers.topic3.name}")
    private String TOPIC_CLEAR;

    private final KafkaTemplate<String, ItemRented> kafkaTemplate1;
    private final KafkaTemplate<String, ItemReturned> kafkaTemplate2;
    private final KafkaTemplate<String, OverdueCleared> kafkaTemplate3;

    @Override
    public void occurRentalEvent(ItemRented itemRented) throws JsonProcessingException {
        CompletableFuture<SendResult<String, ItemRented>> future = kafkaTemplate1.send(TOPIC_RENT, itemRented);
        future.whenComplete((result, ex) -> {
            if(ex == null) {
                ItemRented g = result.getProducerRecord().value();
                log.info("Sent message = [%s] with offset [%s]", g.getItem().getNo() , result.getRecordMetadata().offset());
            } else {
                log.error("%s", ex);
            }
        });
    }

    @Override
    public void occurReturnEvent(ItemReturned itemReturned) throws JsonProcessingException {
        CompletableFuture<SendResult<String, ItemReturned>> future = kafkaTemplate2.send(TOPIC_RETURN, itemReturned);
        future.whenComplete((result, ex) -> {
            if(ex == null) {
                ItemReturned g = result.getProducerRecord().value();
                log.info("Sent message = [%s] with offset [%s]", g.getItem().getNo() , result.getRecordMetadata().offset());
            } else {
                log.error("%s", ex);
            }
        });
    }

    @Override
    public void occurOverdueClearedEvent(OverdueCleared overdueCleared) throws JsonProcessingException {
        CompletableFuture<SendResult<String, OverdueCleared>> future = kafkaTemplate3.send(TOPIC_RETURN, overdueCleared);
        future.whenComplete((result, ex) -> {
            if(ex == null) {
                OverdueCleared g = result.getProducerRecord().value();
                log.info("Sent message = [%s] with offset [%s]", g.getIdName() , result.getRecordMetadata().offset());
            } else {
                log.error("%s", ex);
            }
        });
    }
}
