package org.reservation.rentalms_kotlin.model.vo

import org.reservation.rentalms_kotlin.model.RentalItem
import java.time.LocalDate

data class ReturnItem(
        val rentalItem: RentalItem,
        val returnData: LocalDate?=null,
) {
    companion object {
        fun createReturnItem(rentalItem: RentalItem): ReturnItem {
            return ReturnItem(rentalItem, LocalDate.now());
        }

        fun sample(): ReturnItem {
            return ReturnItem(RentalItem.sample());
        }
    }
}
