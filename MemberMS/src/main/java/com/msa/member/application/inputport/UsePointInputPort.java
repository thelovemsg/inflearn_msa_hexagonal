package com.msa.member.application.inputport;

import com.msa.member.application.outputport.MemberOutPutPort;
import com.msa.member.application.usecase.UsePointUsecase;
import com.msa.member.domain.model.Member;
import com.msa.member.domain.vo.IDName;
import com.msa.member.framework.web.dto.MemberOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UsePointInputPort implements UsePointUsecase {

    private final MemberOutPutPort memberOutPutPort;

    @Override
    public MemberOutputDTO usePoint(IDName idName, long point) throws Exception {
        Member member = memberOutPutPort.loadMemberByIdName(idName);
        member.usePoint(point);
        return MemberOutputDTO.mapToDTO(member);
    }
}
