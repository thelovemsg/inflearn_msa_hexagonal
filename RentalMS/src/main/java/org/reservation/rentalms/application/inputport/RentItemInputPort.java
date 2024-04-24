package org.reservation.rentalms.application.inputport;

import lombok.RequiredArgsConstructor;
import org.reservation.rentalms.application.outputport.RentalCardOutputPort;
import org.reservation.rentalms.application.usecase.RentItemUsecase;
import org.reservation.rentalms.framework.web.dto.RentalCardOutputDTO;
import org.reservation.rentalms.framework.web.dto.UserItemInputDTO;
import org.reservation.rentalms.model.RentalCard;
import org.reservation.rentalms.model.vo.IDName;
import org.reservation.rentalms.model.vo.Item;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RentItemInputPort implements RentItemUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;

    @Override
    public RentalCardOutputDTO rentItem(UserItemInputDTO rental) throws Exception {
        RentalCard rentalCard = rentalCardOutputPort.loadRentalCard(rental.userId)
                .orElseGet(() -> RentalCard.createRentalCard(new IDName(rental.getUserId(), rental.getUserNm())));

        Item newItem = new Item(rental.getItemId(), rental.getItemTitle());
        rentalCard.rentItem(newItem);
//        RentalCard savedRentalCard = rentalCardOutputPort.save(rentalCard);
        return RentalCardOutputDTO.mapToDTO(rentalCard);
    }
}
