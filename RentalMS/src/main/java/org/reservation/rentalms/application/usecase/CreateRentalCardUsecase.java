package org.reservation.rentalms.application.usecase;

import org.reservation.rentalms.framework.web.dto.RentalCardOutputDTO;
import org.reservation.rentalms.framework.web.dto.UserInputDTO;

public interface CreateRentalCardUsecase {
    RentalCardOutputDTO createRentalCard(UserInputDTO userInputDTO);
}
