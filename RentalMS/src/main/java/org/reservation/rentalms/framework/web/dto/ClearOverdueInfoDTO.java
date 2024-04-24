package org.reservation.rentalms.framework.web.dto;

import lombok.Getter;

@Getter
public class ClearOverdueInfoDTO {
    public String userId;
    public String userNm;
    public Integer point;
}
