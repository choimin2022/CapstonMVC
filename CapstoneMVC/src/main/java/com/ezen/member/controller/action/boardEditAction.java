package com.ezen.member.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.boardDAO;
import DTO.boardDTO;
import com.ezen.member.dao.MemberDao;
import com.ezen.member.dto.MemberDto;

public class boardEditAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String b_title = request.getParameter("b_title");
	    String b_content = request.getParameter("b_content");

	    // 로그인한 사용자의 ID를 가져옵니다.
	    String userid = request.getParameter("userid");

	    // 로그인한 사용자의 정보가 있는 경우
	    if (userid != null) {
	        boardDAO boardDAO = DAO.boardDAO.getInstance();
	        boardDTO boardDTO = new boardDTO();

	        boardDTO.setB_title(b_title);
	        boardDTO.setB_content(b_content);
	        boardDTO.setU_id(userid);

	        // 게시판 등록 수행
	        boardDAO.insertBoard(boardDTO);
	    } else {
	        // 로그인한 사용자의 정보가 없는 경우
	        String url = "member.do?command=main";
	        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	        dispatcher.forward(request, response);
	    }
	    //로그인한 사용자일 경우
        String url = "/depart/departBoard.jsp";
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
}
}
