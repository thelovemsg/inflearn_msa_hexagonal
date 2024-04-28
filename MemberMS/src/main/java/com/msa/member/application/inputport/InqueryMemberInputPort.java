package com.msa.member.application.inputport;

import com.msa.member.application.outputport.MemberOutPutPort;
import com.msa.member.application.usecase.InqueryUsecase;
import com.msa.member.domain.model.Member;
import com.msa.member.framework.web.dto.MemberOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class InqueryMemberInputPort implements InqueryUsecase {

    private final MemberOutPutPort memberOutPutPort;

    @Override
    public MemberOutputDTO getMember(long memberNo) {
        Member loadMember = memberOutPutPort.loadMember(memberNo);
        return MemberOutputDTO.mapToDTO(loadMember);
    }
}
