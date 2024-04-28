package com.msa.rental.application.inputport;

import com.msa.rental.application.usecase.ClearOverdueItemUsecase;
import com.msa.rental.framework.web.dto.ClearOverdueInfoDTO;
import com.msa.rental.model.RentalCard;
import lombok.RequiredArgsConstructor;
import com.msa.rental.application.outputport.RentalCardOutputPort;
import com.msa.rental.framework.web.dto.RentalResultOutputDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ClearOverdueItemInputPort implements ClearOverdueItemUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;

    @Override
    public RentalResultOutputDTO clearOverdue(ClearOverdueInfoDTO clearOverdueInfoDTO) throws Exception {
        RentalCard rentalCard = rentalCardOutputPort.loadRentalCard(clearOverdueInfoDTO.getUserId()).orElseThrow(() -> new IllegalArgumentException("해당 카드가 존재하지 않습니다."));
        rentalCard.makeAvailableRental(clearOverdueInfoDTO.point);
        return RentalResultOutputDTO.mapToDTO(rentalCard);
    }
}
