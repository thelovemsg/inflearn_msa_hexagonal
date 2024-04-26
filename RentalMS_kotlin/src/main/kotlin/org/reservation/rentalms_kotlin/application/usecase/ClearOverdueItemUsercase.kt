package org.reservation.rentalms_kotlin.application.usecase

import org.reservation.rentalms_kotlin.web.dto.ClearOverdueInfoDTO
import org.reservation.rentalms_kotlin.web.dto.RentalResultOutputDTO

interface ClearOverdueItemUsercase {
    @Throws(Exception::class)
    fun clearOverdue(clearOverdueInfoDTO: ClearOverdueInfoDTO?): RentalResultOutputDTO?

}
