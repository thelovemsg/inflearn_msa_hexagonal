package org.reservation.rentalms_kotlin.model.vo

import java.time.LocalDate
import java.util.UUID

data class RentalCardNo(
    var no: String? = null
) {
    companion object {
        fun createRentalCardNo(): RentalCardNo {
            val uuid = UUID.randomUUID()
            val year = LocalDate.now().year.toString();
            val str = "$year-$uuid";
            return RentalCardNo(str);
        }

        fun sample(): RentalCardNo = createRentalCardNo()
    }
}


