package org.reservation.rentalms.application.inputport;

import lombok.RequiredArgsConstructor;
import org.reservation.rentalms.application.outputport.RentalCardOutputPort;
import org.reservation.rentalms.application.usecase.InqueryUsecase;
import org.reservation.rentalms.framework.web.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class InqueryInputPort implements InqueryUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;

    @Override
    public Optional<RentalCardOutputDTO> getRentalCard(UserInputDTO userInputDTO) {
        return rentalCardOutputPort.loadRentalCard(userInputDTO.userId).map(RentalCardOutputDTO::mapToDTO);
    }

    @Override
    public Optional<List<RentItemOutputDTO>> getAllRentItem(UserItemInputDTO userItemInputDTO) {
        return rentalCardOutputPort.loadRentalCard(userItemInputDTO.userId)
                        .map(loadCard -> loadCard.getRentalItemList().stream().map(RentItemOutputDTO::mapToDTO).toList());
    }

    @Override
    public Optional<List<ReturnItemOutputDTO>> getAllReturnItem(UserInputDTO userInputDTO) {
        return rentalCardOutputPort.loadRentalCard(userInputDTO.userId)
                        .map(loadCard -> loadCard.getReturnItemList().stream().map(ReturnItemOutputDTO::mapToDTO).toList());
    }
}
