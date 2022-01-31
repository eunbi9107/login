package com.example.service;

import java.util.List;

import com.example.domain.MemberVO;

public interface MemberService {
    public void insertMember(MemberVO vo) throws Exception;

    public MemberVO loginMember(MemberVO vo);

    public MemberVO readMember(String id);

    public void updateMember(MemberVO vo);

    public void deleteMember(MemberVO vo);

    public List<MemberVO> getMemberList();
}
