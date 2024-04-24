package org.reservation.rentalms.application.inputport;

import lombok.RequiredArgsConstructor;
import org.reservation.rentalms.application.outputport.RentalCardOutputPort;
import org.reservation.rentalms.application.usecase.CreateRentalCardUsecase;
import org.reservation.rentalms.framework.web.dto.RentalCardOutputDTO;
import org.reservation.rentalms.framework.web.dto.UserInputDTO;
import org.reservation.rentalms.model.RentalCard;
import org.reservation.rentalms.model.vo.IDName;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateRentalCardInputPort implements CreateRentalCardUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;

    @Override
    public RentalCardOutputDTO createRentalCard(UserInputDTO owner) {
        RentalCard rentalCard = RentalCard.createRentalCard(new IDName(owner.getUserId(), owner.getUserNm()));
        RentalCard savedRentalCard = rentalCardOutputPort.save(rentalCard);
        return RentalCardOutputDTO.mapToDTO(savedRentalCard);
    }
}
