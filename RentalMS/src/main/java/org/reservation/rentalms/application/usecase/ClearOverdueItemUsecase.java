package org.reservation.rentalms.application.usecase;

import org.reservation.rentalms.framework.web.dto.ClearOverdueInfoDTO;
import org.reservation.rentalms.framework.web.dto.RentalResultOutputDTO;

public interface ClearOverdueItemUsecase {
    RentalResultOutputDTO clearOverdue(ClearOverdueInfoDTO clearOverdueInfoDTO) throws Exception;
}
