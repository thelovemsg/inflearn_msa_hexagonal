package com.msa.rental.domain.model.vo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class RentalCardNo implements Serializable {
    private static final long serialVersionUID = -152186546848646L;
    private String no;

    public static RentalCardNo createRentalCardNo() {
        UUID uuid = UUID.randomUUID();
        String year = String.valueOf(LocalDate.now().getYear());
        String str = year + "-" + uuid;
        RentalCardNo rentalCardNo = new RentalCardNo();
        rentalCardNo.setNo(str);
        return rentalCardNo;
    }

    public static RentalCardNo sample() {
        return RentalCardNo.createRentalCardNo();
    }

    public static void main(String[] args) {
        System.out.println(RentalCardNo.sample());
    }

}
