package com.example.mappers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.domain.MemberVO;
import com.example.persistence.MemberDAO;

@Repository
public class MemberDAOImpl implements MemberDAO {

    @Inject
    private SqlSession sqlSession;

    private static final String namespace = "com.example.mapper.memberMapper";

    @Override
    public String getTime() {
        String result = sqlSession.selectOne(namespace + ".getTime");

        return result;
    }

    @Override
    public void insertMember(MemberVO vo) {
        System.out.println("####");
        sqlSession.insert(namespace + ".insertMember", vo);
    }

    @Override
    public MemberVO readMember(String userid) throws Exception {
        MemberVO vo = sqlSession.selectOne(namespace + ".readMember", userid);

        return vo;
    }

    @Override
    public MemberVO readMemberWithIDPW(String userid, String userpw) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("userid", userid);
        paramMap.put("userpw", userpw);

        return sqlSession.selectOne(namespace + ".readMemberWithIDPW", paramMap);
    }

    @Override
    public void updateMember(MemberVO vo) throws Exception {
        sqlSession.update(namespace + ".updateMember", vo);

    }

    @Override
    public void deleteMember(MemberVO vo) throws Exception {
        int check = sqlSession.delete(namespace + ".deleteMember", vo);
        System.out.println("DAO : deleteMember() " + check);

    }

    @Override
    public List<MemberVO> getMemberList(MemberVO vo) {
        
        List<MemberVO> memberList = null;
        memberList = sqlSession.selectList(namespace + ".memberList", vo);
        System.out.println("DAO: getMemberList 결과 - " + memberList);

        return memberList;
    }
}
