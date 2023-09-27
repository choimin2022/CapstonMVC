package com.ezen.member.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import departDAO.Depart_memberDAO;
import departDTO.Depart_memberDTO;
import com.ezen.member.dao.MemberDao;
import com.ezen.member.dto.MemberDto;

public class departAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 세션에서 로그인된 사용자 정보를 가져옴
        HttpSession session = request.getSession();
        MemberDto loginUser = (MemberDto) session.getAttribute("loginUser");
        
        // 사용자의 아이디를 가져옴
        String userid = (loginUser != null) ? loginUser.getUserid() : null;
        
        // 회원 정보를 가져옴
        MemberDao memberDao = MemberDao.getInstance();
        MemberDto memberDto = memberDao.getMember(userid);
        
        // 회원 정보에서 이름을 가져옴
        String name = (memberDto != null) ? memberDto.getName() : "";
        
        // 부서 멤버 DTO 객체를 생성하고 데이터 설정
        Depart_memberDTO departMemberDto = new Depart_memberDTO();
        departMemberDto.setD_code(request.getParameter("d_code"));
        departMemberDto.setUserid(userid);
        departMemberDto.setName(name);
        departMemberDto.setD_name(request.getParameter("d_name"));
        departMemberDto.setD_task(request.getParameter("d_task"));
        departMemberDto.setD_address(request.getParameter("d_address"));
        departMemberDto.setD_img(request.getParameter("d_img"));
        
        // 부서 멤버 DAO를 사용하여 데이터베이스에 삽입
        Depart_memberDAO departMemberDao = Depart_memberDAO.getInstance();
        departMemberDao.insertDepart_Member(departMemberDto);
        
        // 결과 페이지로 이동
        String url = "member.do?command=main";
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}