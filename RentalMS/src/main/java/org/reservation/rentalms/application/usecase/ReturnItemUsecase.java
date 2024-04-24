package org.reservation.rentalms.application.usecase;

import org.reservation.rentalms.framework.web.dto.RentalCardOutputDTO;
import org.reservation.rentalms.framework.web.dto.UserItemInputDTO;

public interface ReturnItemUsecase {
    RentalCardOutputDTO returnItem(UserItemInputDTO returnDTO) throws Exception;
}
