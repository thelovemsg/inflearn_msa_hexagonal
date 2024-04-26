package org.reservation.rentalms_kotlin.application.outputport

import org.reservation.rentalms_kotlin.model.RentalCard
import org.springframework.stereotype.Repository

@Repository
interface RentalCardOutputPort {
    fun loadRentalCard(userId: String): RentalCard?
    fun save(rentalCard: RentalCard): RentalCard
}