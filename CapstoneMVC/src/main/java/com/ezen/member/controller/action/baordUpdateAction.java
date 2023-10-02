package com.ezen.member.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.boardDAO;
import DTO.boardDTO;

public class baordUpdateAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int b_num = Integer.parseInt(request.getParameter("b_num"));
        String b_title = request.getParameter("b_title");
        String b_content = request.getParameter("b_content");
        int b_like = Integer.parseInt(request.getParameter("b_like"));
        boolean b_check = Boolean.parseBoolean(request.getParameter("b_check"));

        boardDTO boardDTO = new boardDTO();
        boardDTO.setB_num(b_num);
        boardDTO.setB_title(b_title);
        boardDTO.setB_content(b_content);
        boardDTO.setB_like(b_like);
        boardDTO.setB_check(b_check);
        boardDAO boardDAO = DAO.boardDAO.getInstance();
        int result = boardDAO.updateBoard(boardDTO);

        if (result > 0) {
            request.setAttribute("message", "게시글 수정 성공");
        } else {
            request.setAttribute("message", "게시글 수정 실패");
        }

        String url = "member.do?command=main";
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
