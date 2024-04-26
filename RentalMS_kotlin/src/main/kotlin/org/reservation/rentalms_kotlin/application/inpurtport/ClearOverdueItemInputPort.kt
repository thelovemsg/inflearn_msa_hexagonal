package org.reservation.rentalms_kotlin.application.inpurtport

import lombok.RequiredArgsConstructor
import org.reservation.rentalms_kotlin.application.outputport.RentalCardOutputPort
import org.reservation.rentalms_kotlin.application.usecase.ClearOverdueItemUsercase
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
@RequiredArgsConstructor
class ClearOverdueItemInputPort (
    private val rentalCardOutputPort: RentalCardOutputPort
): ClearOverdueItemUsercase {

}

