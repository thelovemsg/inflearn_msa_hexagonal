package org.reservation.rentalms.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Integer no;
    private String title;

    public static Item sample() {
        return new Item(10, "노인과바다");
    }
}
