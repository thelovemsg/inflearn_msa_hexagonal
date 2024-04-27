package org.reservation.rentalms.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.reservation.rentalms.model.vo.Item;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class RentalItem {
    @Embedded
    private Item item;
    private LocalDate rez1ntDate;
    private boolean overdued;
    private LocalDate overdueDate; // 반납예정일

    public static RentalItem createRentalItem(Item item) {
        return new RentalItem(item, LocalDate.now(), false, LocalDate.now().plusDays(14));
    }

    public static RentalItem sample() {
        return RentalItem.createRentalItem(Item.sample());
    }
}
