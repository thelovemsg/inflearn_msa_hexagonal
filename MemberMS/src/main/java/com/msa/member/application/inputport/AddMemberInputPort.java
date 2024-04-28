package com.msa.member.application.inputport;

import com.msa.member.application.usecase.AddMemberUsecase;
import com.msa.member.application.outputport.MemberOutPutPort;
import com.msa.member.domain.model.Member;
import com.msa.member.domain.vo.Email;
import com.msa.member.domain.vo.IDName;
import com.msa.member.domain.vo.PassWord;
import com.msa.member.framework.web.dto.MemberInfoDTO;
import com.msa.member.framework.web.dto.MemberOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AddMemberInputPort implements AddMemberUsecase {

    private final MemberOutPutPort memberOutputPort;

    @Override
    public MemberOutputDTO addMember(MemberInfoDTO memberInfoDTO) {
        IDName idName = new IDName(memberInfoDTO.getId(), memberInfoDTO.getName());
        PassWord pwd = new PassWord(memberInfoDTO.getPassWord(), memberInfoDTO.getPassWord());
        Email email = new Email(memberInfoDTO.getEmail());
        Member addedMember = Member.registerMember(idName, pwd, email);
        Member savedMember = memberOutputPort.saveMember(addedMember);
        return MemberOutputDTO.mapToDTO(savedMember);
    }
}
