package com.msa.rental.application.inputport;

import com.msa.rental.application.outputport.EventOutputPort;
import com.msa.rental.application.usecase.ClearOverdueItemUsecase;
import com.msa.rental.domain.model.event.OverdueCleared;
import com.msa.rental.framework.web.dto.ClearOverdueInfoDTO;
import com.msa.rental.domain.model.RentalCard;
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
    private final EventOutputPort eventOutputPort;

    @Override
    public RentalResultOutputDTO clearOverdue(ClearOverdueInfoDTO clearOverdueInfoDTO) throws Exception {
        RentalCard rentalCard = rentalCardOutputPort.loadRentalCard(clearOverdueInfoDTO.getUserId()).orElseThrow(() -> new IllegalArgumentException("해당 카드가 존재하지 않습니다."));
        rentalCard.makeAvailableRental(clearOverdueInfoDTO.point);
        //이벤트 생성 및 발행
        OverdueCleared overdueClearedEvent = RentalCard.createOverdueClearedEvent(rentalCard.getMember(), clearOverdueInfoDTO.getPoint());
        eventOutputPort.occurOverdueClearedEvent(overdueClearedEvent);
        return RentalResultOutputDTO.mapToDTO(rentalCard);
    }
}
