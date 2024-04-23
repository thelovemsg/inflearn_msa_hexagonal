package org.reservation.rentalms_kotlin.model.vo

data class IDName (
    var id: String,
    var name: String
) {
    companion object{
        fun sample(): IDName {
            return IDName("scant", "moon")
        }
    }
}