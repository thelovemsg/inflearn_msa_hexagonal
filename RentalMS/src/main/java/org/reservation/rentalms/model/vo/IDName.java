package org.reservation.rentalms.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IDName {
    private String id;
    private String name;

    public static IDName sample() {
        return new IDName("scant", "moon");
    }

}