package org.reservation.rentalms.application.inputport;

import lombok.RequiredArgsConstructor;
import org.reservation.rentalms.application.outputport.RentalCardOutputPort;
import org.reservation.rentalms.application.usecase.ReturnItemUsecase;
import org.reservation.rentalms.framework.web.dto.RentalCardOutputDTO;
import org.reservation.rentalms.framework.web.dto.UserItemInputDTO;
import org.reservation.rentalms.model.RentalCard;
import org.reservation.rentalms.model.vo.Item;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class ReturnItemInputPort implements ReturnItemUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;

    @Override
    public RentalCardOutputDTO returnItem(UserItemInputDTO returnDTO) throws Exception {
        RentalCard rentalCard = rentalCardOutputPort.loadRentalCard(returnDTO.userId).orElseThrow(() -> new IllegalArgumentException("해당 카드가 없습니다."));
        Item returnItem = new Item(returnDTO.itemId, returnDTO.getItemTitle());
        rentalCard.returnItem(returnItem, LocalDate.now());
        return RentalCardOutputDTO.mapToDTO(rentalCard);
    }
}
