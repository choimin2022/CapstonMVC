package com.ezen.member.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.member.dao.MemberDao;
import com.ezen.member.dto.MemberDto;

public class LoginSessionAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 로그인한 사용자의 ID를 가져옵니다.
        String userid = request.getParameter("userid");
    	String url = "CapstoneMVC/chatMain/ChatMain.jsp";

        // 로그인한 사용자의 정보를 가져옵니다.
        MemberDao memberDao = MemberDao.getInstance();
        MemberDto member = memberDao.getMember(userid);

        // 로그인한 사용자의 이름을 저장합니다.
        if (member != null) {
            request.setAttribute("name", member.getName());

            // 세션을 생성하고 유효시간을 30분으로 설정합니다.
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(30 * 60);
            session.setAttribute("loginUser", member);
        }


		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
    }
}
