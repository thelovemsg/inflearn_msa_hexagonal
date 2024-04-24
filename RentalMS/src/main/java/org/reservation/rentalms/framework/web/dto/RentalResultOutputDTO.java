package org.reservation.rentalms.framework.web.dto;

import lombok.Getter;
import lombok.Setter;
import org.reservation.rentalms.model.RentalCard;

@Getter
@Setter
public class RentalResultOutputDTO {
    public String userId;
    public String userNm;
    public Integer rentedCount;
    public long totalLateFee;

    public static RentalResultOutputDTO mapToDTO(RentalCard rental){
        RentalResultOutputDTO rentDTO = new RentalResultOutputDTO();
        rentDTO.setUserId(rental.getMember().getId());
        rentDTO.setUserNm(rental.getMember().getName());
        rentDTO.setRentedCount(rental.getRentalItemList().size());
        rentDTO.setTotalLateFee(rental.getLateFee().getPoint());
        return rentDTO;
    }
}