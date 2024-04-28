package com.msa.member.application.inputport;

import com.msa.member.application.outputport.MemberOutPutPort;
import com.msa.member.application.usecase.SavePointUsecase;
import com.msa.member.domain.model.Member;
import com.msa.member.domain.vo.IDName;
import com.msa.member.framework.web.dto.MemberOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SavePointInputPort implements SavePointUsecase {

    private final MemberOutPutPort memberOutPutPort;

    @Override
    public MemberOutputDTO savePoint(IDName idName, Long point) {
        Member loadedMember = memberOutPutPort.loadMemberByIdName(idName);
        loadedMember.savePoint(point);
        return MemberOutputDTO.mapToDTO(loadedMember);
    }
}
