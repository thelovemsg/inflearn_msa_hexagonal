package org.reservation.rentalms.application.usecase;

import org.reservation.rentalms.framework.web.dto.*;

import java.util.List;
import java.util.Optional;

public interface InqueryUsecase {
    Optional<RentalCardOutputDTO> getRentalCard(UserInputDTO userInputDTO);
    Optional<List<RentItemOutputDTO>> getAllRentItem(UserItemInputDTO userItemInputDTO);
    Optional<List<ReturnItemOutputDTO>> getAllReturnItem(UserInputDTO userInputDTO);
}
