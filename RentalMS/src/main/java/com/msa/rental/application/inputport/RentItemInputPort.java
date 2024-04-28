package com.msa.rental.application.inputport;

import com.msa.rental.application.usecase.RentItemUsecase;
import com.msa.rental.framework.web.dto.UserItemInputDTO;
import com.msa.rental.model.RentalCard;
import com.msa.rental.model.vo.IDName;
import com.msa.rental.model.vo.Item;
import lombok.RequiredArgsConstructor;
import com.msa.rental.application.outputport.RentalCardOutputPort;
import com.msa.rental.framework.web.dto.RentalCardOutputDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RentItemInputPort implements RentItemUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;

    @Override
    public RentalCardOutputDTO rentItem(UserItemInputDTO rental) throws Exception {
        RentalCard rentalCard = rentalCardOutputPort.loadRentalCard(rental.userId)
                .orElseGet(() -> RentalCard.createRentalCard(new IDName(rental.getUserId(), rental.getUserNm())));

        Item newItem = new Item(rental.getItemId(), rental.getItemTitle());
        rentalCard.rentItem(newItem);
//        RentalCard savedRentalCard = rentalCardOutputPort.save(rentalCard);
        return RentalCardOutputDTO.mapToDTO(rentalCard);
    }
}
