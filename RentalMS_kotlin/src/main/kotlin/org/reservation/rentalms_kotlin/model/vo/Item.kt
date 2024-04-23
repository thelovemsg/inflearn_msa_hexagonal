package org.reservation.rentalms_kotlin.model.vo

data class Item(
    val no: Int?=null,
    val title: String?=null,
) {
    companion object{
        fun sample(): Item {
            return Item(10, "노인과바다");
        }
    }
}
