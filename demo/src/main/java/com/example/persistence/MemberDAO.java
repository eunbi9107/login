package com.example.persistence;

import java.util.List;

import com.example.domain.MemberVO;

public interface MemberDAO {
    public String getTime();

    public void insertMember(MemberVO vo);

    public MemberVO readMember(String userid) throws Exception;

    public MemberVO readMemberWithIDPW(String userid, String userpw) throws Exception;

    public void updateMember(MemberVO vo) throws Exception;

    public void deleteMember(MemberVO vo) throws Exception;

    public List<MemberVO> getMemberList();

}
