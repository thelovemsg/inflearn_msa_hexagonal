package org.reservation.rentalms.framework.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.reservation.rentalms.model.RentalCard;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RentalCardOutputDTO {
    private String rentalCardId;
    private String memberId;
    private String memberName;
    private String rentStatus;//대여가능여부
    private Long totalLateFee;//전체연체료
    private Long totalRentalCnt;//전체대여도서건수
    private Long totalReturnCnt;//반납도서건수
    private Long totalOverduedCnt;//연체중인도서건수
    public static RentalCardOutputDTO mapToDTO(RentalCard rental){
        RentalCardOutputDTO rentDTO = new RentalCardOutputDTO();
        rentDTO.setRentalCardId(rental.getRentalCardNo().getNo().toString());
        rentDTO.setMemberId(rental.getMember().getId().toString());
        rentDTO.setMemberName(rental.getMember().getName());
        rentDTO.setRentStatus(rental.getRentStatus().toString());
        rentDTO.setTotalRentalCnt(rental.getRentalItemList().stream().count());
        rentDTO.setTotalReturnCnt(rental.getReturnItemList().stream().count());

        rentDTO.setTotalOverduedCnt(rental.getRentalItemList().stream().filter(i ->
                i.isOverdued()).count());
        return rentDTO;
    }
}