package org.reservation.rentalms.model.vo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.reservation.rentalms.model.RentalItem;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ReturnItem {
    @Embedded
    private RentalItem rentalItem;
    private LocalDate returnDate;

    public static ReturnItem createReturnItem(RentalItem rentalItem) {
        return new ReturnItem(rentalItem, LocalDate.now());
    }

    public static ReturnItem sample() {
        return new ReturnItem(RentalItem.sample(), LocalDate.now());
    }
}
