package com.msa.member.framework.web.dto;

import com.msa.member.domain.model.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberOutputDTO {
    private String id;
    private String name;
    private String password;
    private String email;

    private long point;

    public static MemberOutputDTO mapToDTO(Member member) {
        MemberOutputDTO memberOutputDTO = new MemberOutputDTO();
        memberOutputDTO.setId(member.getIdName().getId());
        memberOutputDTO.setName(member.getIdName().getName());
        memberOutputDTO.setPassword(member.getPassword().getPastPWD());
        memberOutputDTO.setEmail(member.getEmail().getAddress());
        memberOutputDTO.setPoint(member.getPoint().getPointValue());
        return memberOutputDTO;
    }
}
