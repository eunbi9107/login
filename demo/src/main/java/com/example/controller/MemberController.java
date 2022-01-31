package com.example.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.MemberVO;
import com.example.service.MemberService;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {

    @Inject
    private MemberService service;

    private static final Logger l = LoggerFactory.getLogger(MemberController.class);

    @RequestMapping(value = "/insert", method = RequestMethod.GET )
    public String insertGet() throws Exception{
        l.info("C: 회원가입 입력페이지 GET");
        System.out.println("C: 회원가입 입력페이지 GET");

        return "/insertMember";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertPost(MemberVO vo) throws Exception{
        
        l.info("c: " + vo);

        service.insertMember(vo);
        l.info("C: 회원가입 처리페이지 POST");
        System.out.println("C: 회원가입 처리페이지 POST");

        return "redirect:/member/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginGET() throws Exception{
        l.info("C: 로그인 입력페이지 GET");
        System.out.println("C: 로그인 입력페이지 GET");
        return "/loginForm";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(MemberVO vo, HttpSession session, RedirectAttributes rttr) throws Exception{
        l.info("C: 로그인 처리 페이지 POST");
        System.out.println("C: 로그인 처리 입력페이지 POST");

        l.info("C: " + vo.getUserid() + vo.getUserpw());

        MemberVO returnVo = service.loginMember(vo);
        l.info("C: 리턴VO 결과(서비스에서 예외처리를 진행했으므로 null이 출력되면 코드에 문제있다는 의미 " + returnVo);
        System.out.println("C: 리턴VO 결과(서비스에서 예외처리를 진행했으므로 null이 출력되면 코드에 문제있다는 의미 " + returnVo);

        if(returnVo != null){
            session.setAttribute("id", returnVo.getUserid());
            session.setAttribute("isAdmin", returnVo.getAdminCk());

            rttr.addFlashAttribute("mvo", returnVo);
            return "redirect:/member/main";
        } else{
            return "redirect:/member/login";
        }
       
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainGET() throws Exception{
        l.info("C: 메인 출력페이지 GET");

        return "/main";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutGET(HttpSession session) throws Exception{
        l.info("c: 로그아웃 GET");
        session.invalidate();

        return "/logout";
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public String infoGET(HttpSession session, Model model) throws Exception{
        String id = (String) session.getAttribute("id");
        l.info("C: 회원정보보기 GET의 아이디 " + id);
        System.out.println("C: 회원정보보기 GET의 아이디 " + id);

        MemberVO vo = service.readMember(id);

        model.addAttribute("memVO", vo);
        l.info("C: 회원정보보기 GET의 VO " + vo);
        System.out.println("C: 회원정보보기 GET의 VO " + vo);

        return "/info";
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String updateGET(HttpSession session, Model model) throws Exception{

        model.addAttribute("memVO", service.readMember((String)session.getAttribute("id")));

        return "/updateForm";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updatePOST(MemberVO vo) throws Exception{
        l.info("C: 회원정보수정 입력페이지 POST");
        System.out.println("C: 회원정보수정 입력페이지 POST");

        service.updateMember(vo);
        return "/main";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteGET(HttpSession session) throws Exception {
        l.info("C: 회원정보 삭제 GET");
        System.out.println("C: 회원정보 삭제 GET");
        // 세션제어
        String id = (String) session.getAttribute("id");
        if (id == null) {
            return "redirect:/member/main";
        }
        return "/deleteForm";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deletePOST(MemberVO vo, HttpSession session) throws Exception {
        l.info("C: 회원정보 삭제 POST");
        System.out.println("C: 회원정보 삭제 POST");
        // 1. 파라미터값 저장
        l.info("C: deleteForm전달정보 " + vo);
        System.out.println("C: deleteForm 전달 정보 " + vo);
        // 2. 전달받은 정보를 가지고 삭제 동작 처리이동
        // 3. service 객체 - 동작
        service.deleteMember(vo);
        // 4. 세션초기화
        session.invalidate();
        // 5. 페이지 이동
        return "redirect:/member/main";
    }

    /* 관리자용 회원 목록 */
    @RequestMapping(value = "/memberList", method = RequestMethod.GET)
    public String listGET(HttpSession session, Model model, MemberVO vo) throws Exception {
        // 1. 관리자 세션 제어
        String id = (String) session.getAttribute("id");
        int isAdmin = (int) session.getAttribute("isAdmin");
        System.out.println("isAdmin : " + isAdmin);

        if (id == null || isAdmin != 2) {
            l.info("C: 관리자아닌 접근 ID - " + id);
            System.out.println("C: 관리자아닌 접근 ID - " + id);

            return "redirect:/member/main";
        }

        // 2. 서비스 - 회원 목록 가져오는 동작
        List<MemberVO> memberList = service.getMemberList();

        // 3. 정보 저장 -> 뷰(/memberlist.jsp) -> (Model 객체 )
        model.addAttribute("memberList", memberList);
        
        // 4. 페이지이동
        return "/memberList";
    }

    @RequestMapping(value = "/adminGoodsList")
    public String goodsListGET(){
        

        return "/adminGoodsList";
    }
}
