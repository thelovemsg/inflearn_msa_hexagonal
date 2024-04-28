package com.msa.member.domain.vo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Email {
    private String address;

    public static Email sample() {
        return new Email("scant10@gmail.com");
    }
}
