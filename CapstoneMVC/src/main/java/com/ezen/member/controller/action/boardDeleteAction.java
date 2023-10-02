package com.ezen.member.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.boardDAO;

public class boardDeleteAction {
	public class deleteBoardAction implements Action {

	    @Override
		public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        int b_num = Integer.parseInt(request.getParameter("b_num"));

	        boardDAO boardDAO = DAO.boardDAO.getInstance();
	        boardDAO.deleteBoard(b_num);
	        
	        String url = "/depart/departBoard.jsp";
	        response.sendRedirect(url);
	    }
}
}
