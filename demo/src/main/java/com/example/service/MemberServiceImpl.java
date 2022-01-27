package com.example.service;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.example.domain.MemberVO;
import com.example.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{

    @Inject
    private MemberDAO mdao;

    @Override
    public void insertMember(MemberVO vo) throws Exception {
        System.out.println("S : 회원가입 동작");
        if(vo == null){
            return;
        }
        mdao.insertMember(vo);
        // try {
        //     mdao.insertMember(vo);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    }

    @Override
    public MemberVO loginMember(MemberVO vo) {
        System.out.println("S : 컨트롤러에서 호출받으면 필요한 정보를 받아서 DAO로 전달");
        
        MemberVO returnVO = null;

        try{
            returnVO = mdao.readMemberWithIDPW(vo.getUserid(), vo.getUserpw());
        } catch (Exception e){
            e.printStackTrace();
            returnVO = null;
        }
        return returnVO;
    }

    @Override
    public MemberVO readMember(String id) {
        System.out.println("S : readMember() 실행");
        MemberVO vo = null;
        
        try{
            vo = mdao.readMember(id);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return vo;
    }

    @Override
    public void updateMember(MemberVO vo) {
        System.out.println("S : updateMember() 실행");
        try {
            mdao.updateMember(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMember(MemberVO vo) {
        System.out.println("S: deleteMember 실행");
        try {
            mdao.deleteMember(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<MemberVO> getMemberList(MemberVO vo) {
        return mdao.getMemberList(vo);
    }

    

}
