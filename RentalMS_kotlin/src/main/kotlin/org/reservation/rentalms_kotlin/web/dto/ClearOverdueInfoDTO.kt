package org.reservation.rentalms_kotlin.web.dto

import lombok.Getter

@Getter
data class ClearOverdueInfoDTO(
    val userId: String? = null,
    val userNm: String? = null,
    val point: Int? = null,
)
