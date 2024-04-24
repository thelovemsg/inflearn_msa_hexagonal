package org.reservation.rentalms.application.inputport;

import lombok.RequiredArgsConstructor;
import org.reservation.rentalms.application.outputport.RentalCardOutputPort;
import org.reservation.rentalms.application.usecase.OverdueItemUsecase;
import org.reservation.rentalms.framework.web.dto.RentalCardOutputDTO;
import org.reservation.rentalms.framework.web.dto.UserItemInputDTO;
import org.reservation.rentalms.model.RentalCard;
import org.reservation.rentalms.model.vo.Item;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OverDueItemInputPort implements OverdueItemUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;

    @Override
    public RentalCardOutputDTO overDueItem(UserItemInputDTO rental) throws Exception {
        RentalCard rentalCard = rentalCardOutputPort.loadRentalCard(rental.userId).orElseThrow(() -> new IllegalArgumentException("해당 카드가 존재하지 않습니다."));
        rentalCard.overdueItem(new Item(rental.itemId, rental.itemTitle));
        return RentalCardOutputDTO.mapToDTO(rentalCard);
    }
}
