package org.reservation.rentalms_kotlin.model.vo

data class LateFee (
    var point: Long = 0
){
    fun addPoint(point: Long): LateFee{
        return LateFee(this.point + point)
    }

    @Throws(Exception::class)
    fun removePoint(point: Long): LateFee {
        if(this.point < point)
            throw Exception("보유한 퐁니트보다 커서 삭제할 수 없습니다.");
        return LateFee(this.point - point);
    }

    companion object {
        fun createLateFee(): LateFee {
            return LateFee(0);
        }

        fun sample(): LateFee {
            return LateFee(100);
        }
    }

}
