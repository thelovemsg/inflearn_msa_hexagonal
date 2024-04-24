package org.reservation.rentalms.application.inputport;

import lombok.RequiredArgsConstructor;
import org.reservation.rentalms.application.outputport.RentalCardOutputPort;
import org.reservation.rentalms.application.usecase.ClearOverdueItemUsecase;
import org.reservation.rentalms.framework.web.dto.ClearOverdueInfoDTO;
import org.reservation.rentalms.framework.web.dto.RentalResultOutputDTO;
import org.reservation.rentalms.model.RentalCard;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ClearOverdueItemInputPort implements ClearOverdueItemUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;

    @Override
    public RentalResultOutputDTO clearOverdue(ClearOverdueInfoDTO clearOverdueInfoDTO) throws Exception {
        RentalCard rentalCard = rentalCardOutputPort.loadRentalCard(clearOverdueInfoDTO.getUserId()).orElseThrow(() -> new IllegalArgumentException("해당 카드가 존재하지 않습니다."));
        rentalCard.makeAvailableRental(clearOverdueInfoDTO.point);
        return RentalResultOutputDTO.mapToDTO(rentalCard);
    }
}
