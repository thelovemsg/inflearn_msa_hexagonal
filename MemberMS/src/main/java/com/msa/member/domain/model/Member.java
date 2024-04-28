package com.msa.member.domain.model;

import com.msa.member.domain.vo.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long MemberNo;
    @Embedded
    private IDName idName;
    @Embedded
    private PassWord password;
    @Embedded
    private Email email;
    @ElementCollection
    private List<Authority> authorities = new ArrayList<>();
    @Embedded
    private Point point;

    public static Member registerMember(IDName idName, PassWord pwd, Email email) {
        Member member = new Member();
        member.setIdName(idName);
        member.setPassword(pwd);
        member.setEmail(email);
        member.setPoint(new Point(0L));
        member.addAuthority(new Authority(UserRole.USER));
        return member;
    }

    private void addAuthority(Authority authority) {
        this.authorities.add(authority);
    }

    public long savePoint(long point) {
        return this.point.addPoint(point);
    }

    public long usePoint(long point) throws Exception {
        return this.point.removePoint(point);
    }

    public Member login(IDName idNname, PassWord password) {
        return this;
    }

    public void logout(IDName idName) {
    }

}
