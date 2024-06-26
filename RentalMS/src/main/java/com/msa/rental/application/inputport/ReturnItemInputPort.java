package com.msa.rental.application.inputport;

import com.msa.rental.application.outputport.EventOutputPort;
import com.msa.rental.application.usecase.ReturnItemUsecase;
import com.msa.rental.domain.model.event.ItemReturned;
import com.msa.rental.framework.web.dto.UserItemInputDTO;
import com.msa.rental.domain.model.RentalCard;
import com.msa.rental.domain.model.vo.Item;
import lombok.RequiredArgsConstructor;
import com.msa.rental.application.outputport.RentalCardOutputPort;
import com.msa.rental.framework.web.dto.RentalCardOutputDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class ReturnItemInputPort implements ReturnItemUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;
    private final EventOutputPort eventOutputPort;

    @Override
    public RentalCardOutputDTO returnItem(UserItemInputDTO returnDTO) throws Exception {
        RentalCard rentalCard = rentalCardOutputPort.loadRentalCard(returnDTO.userId).orElseThrow(() -> new IllegalArgumentException("해당 카드가 없습니다."));
        Item returnItem = new Item(returnDTO.itemId, returnDTO.getItemTitle());
        rentalCard.returnItem(returnItem, LocalDate.now());

        //이벤트 생성 및 발행
        ItemReturned itemReturnEvent = RentalCard.createItemReturnEvent(rentalCard.getMember(), returnItem, 10L);
        eventOutputPort.occurReturnEvent(itemReturnEvent);

        return RentalCardOutputDTO.mapToDTO(rentalCard);
    }
}
