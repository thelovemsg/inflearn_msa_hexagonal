package org.reservation.rentalms_kotlin.model

import org.reservation.rentalms_kotlin.model.vo.*
import java.time.LocalDate
import java.time.Period

data class RentalCard(
        var rentalCardNo: RentalCardNo? = null,
        var member: IDName? = null,
        var rentStatus: RentStatus? = null,
        var lateFee: LateFee = LateFee.createLateFee(),
        var rentalItemList: MutableList<RentalItem> = mutableListOf(),
        var returnItemList: MutableList<ReturnItem> = mutableListOf(),
) {
    companion object {
        fun sample(): RentalCard {
            return RentalCard().apply {
                rentalCardNo = RentalCardNo.createRentalCardNo()
                member = IDName.sample()
                rentStatus = RentStatus.RENT_AVAILABLE
                lateFee = LateFee.sample()
            }
        }

        fun createRentalCard(creator: IDName): RentalCard {
            return RentalCard().apply {
                rentalCardNo = RentalCardNo.createRentalCardNo()
                member = creator
                rentStatus = RentStatus.RENT_AVAILABLE
            }
        }
    }

    private fun addRentalItem(rentalItem: RentalItem) {
        this.rentalItemList.add(rentalItem);
    }

    private fun removeRentalItem(rentalItem: RentalItem) {
        this.rentalItemList.remove(rentalItem);
    }

    private fun addReturnItem(returnItem: ReturnItem) {
        this.returnItemList.add(returnItem);
    }

    fun rentItem(item: Item): RentalCard {
        checkRentalAvailable();
        addRentalItem(RentalItem.createRentalItem(item))
        return this;
    }

    private fun checkRentalAvailable() {
        require(this.rentStatus !== RentStatus.RENT_UNAVAILABLE) { "대여불가상태입니다." }
        require(rentalItemList.size <= 5) { "이미 5권을 대여했습니다." }
    }

    fun returnItem(item: Item?, returnDate: LocalDate): RentalCard {
        val rentalItem = rentalItemList.first { it.item == item }
        calculateLateFee(rentalItem, returnDate)
        this.addReturnItem(ReturnItem.createReturnItem(rentalItem))
        this.removeRentalItem(rentalItem)
        return this
    }

    private fun calculateLateFee(rentalItem: RentalItem, returnDate: LocalDate) {
        if (returnDate > rentalItem.overdueDate) {
            val point = Period.between(rentalItem.overdueDate, returnDate).days * 10L;
            lateFee = lateFee.addPoint(point);
        }
    }

    fun overdueItem(item: Item): RentalCard {
        val rentalItem = rentalItemList.first { it.item == item }
        rentalItem.overdued = true
        rentStatus = RentStatus.RENT_UNAVAILABLE
        rentalItem.overdueDate = LocalDate.now().minusDays(1)
        return this;
    }

    fun makeAvailableRental(point: Long): Long {
        if (rentalItemList.size != 0) throw IllegalArgumentException("모든 도서가 반납되어야 정지를 해제할 수 있습니다.");
        if (lateFee.point != point) throw IllegalArgumentException("모든 도서가 반납되어야 정지를 해제할 수 있습니다.");

        lateFee = lateFee.removePoint(point);
        if (lateFee.point == 0L)
            rentStatus = RentStatus.RENT_AVAILABLE

        return lateFee.point;
    }

}