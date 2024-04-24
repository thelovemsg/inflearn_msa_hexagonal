package org.reservation.rentalms.framework.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.reservation.rentalms.model.vo.ReturnItem;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ReturnItemOutputDTO {
    private Integer itemNo;
    private String itemtitle;
    private LocalDate returnDate;

    public static ReturnItemOutputDTO mapToDTO(ReturnItem returnItem){
        ReturnItemOutputDTO rentItemOutputDTO = new ReturnItemOutputDTO();
        rentItemOutputDTO.setItemNo(returnItem.getRentalItem().getItem().getNo());
        rentItemOutputDTO.setItemtitle(returnItem.getRentalItem().getItem().getTitle());
        rentItemOutputDTO.setReturnDate(returnItem.getReturnDate());
        return rentItemOutputDTO;
    }
}