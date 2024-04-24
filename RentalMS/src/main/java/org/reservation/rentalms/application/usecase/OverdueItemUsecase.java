package org.reservation.rentalms.application.usecase;

import org.reservation.rentalms.framework.web.dto.RentalCardOutputDTO;
import org.reservation.rentalms.framework.web.dto.UserItemInputDTO;

public interface OverdueItemUsecase {
    RentalCardOutputDTO overDueItem(UserItemInputDTO rental) throws Exception;
}
