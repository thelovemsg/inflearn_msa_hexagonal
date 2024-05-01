package com.msa.rental.application.inputport;

import com.msa.rental.application.usecase.CreateRentalCardUsecase;
import com.msa.rental.framework.web.dto.RentalCardOutputDTO;
import com.msa.rental.framework.web.dto.UserInputDTO;
import com.msa.rental.domain.model.RentalCard;
import com.msa.rental.domain.model.vo.IDName;
import lombok.RequiredArgsConstructor;
import com.msa.rental.application.outputport.RentalCardOutputPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateRentalCardInputPort implements CreateRentalCardUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;

    @Override
    public RentalCardOutputDTO createRentalCard(UserInputDTO owner) {
        RentalCard rentalCard = RentalCard.createRentalCard(new IDName(owner.getUserId(), owner.getUserNm()));
        RentalCard savedRentalCard = rentalCardOutputPort.save(rentalCard);
        return RentalCardOutputDTO.mapToDTO(savedRentalCard);
    }
}
