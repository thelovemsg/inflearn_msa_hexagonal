package org.reservation.rentalms_kotlin.model

import org.reservation.rentalms_kotlin.model.vo.Item
import java.time.LocalDate

data class RentalItem(
        var item: Item?=null,
        var rentDate: LocalDate?=null,
        var overdued: Boolean?= false,
        var overdueDate: LocalDate?=null
) {
    companion object {
        fun createRentalItem(item: Item): RentalItem {
            return RentalItem(item, LocalDate.now(), false, LocalDate.now().plusDays(14));
        }

        fun sample(): RentalItem {
            return createRentalItem(Item.sample());
        }
    }

}
