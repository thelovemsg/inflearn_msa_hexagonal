package com.msa.rental.application.outputport;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.msa.rental.domain.model.event.ItemRented;
import com.msa.rental.domain.model.event.ItemReturned;
import com.msa.rental.domain.model.event.OverdueCleared;
import org.springframework.stereotype.Repository;

@Repository
public interface EventOutputPort {
    void occurRentalEvent(ItemRented rentalItemEvent) throws JsonProcessingException;
    void occurReturnEvent(ItemReturned itemReturnedEvent) throws JsonProcessingException;
    void occurOverdueClearedEvent(OverdueCleared overdueCleared) throws JsonProcessingException;
}
