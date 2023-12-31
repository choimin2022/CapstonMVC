package com.ezen.member.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.boardDAO;
import DTO.boardDTO;
import vo.PageInfo;

public class boardListAction implements Action{
    @Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boardDAO boardDAO = DAO.boardDAO.getInstance();
        ArrayList<boardDTO> boardList = boardDAO.selectBoardList();

        // 페이지 처리를 위한 변수 설정
        int page = 1; // 현재 페이지 번호
        int limit = 10; // 한 페이지에 출력할 게시글 수

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        // 전체 게시글 수
        int listCount = boardList.size();

        // 총 페이지 수
        int maxPage = (int) Math.ceil((double) listCount / limit);

        // 현재 페이지에 해당하는 게시글 목록 가져오기
        int startIndex = (page - 1) * limit;
        int endIndex = Math.min(startIndex + limit - 1, listCount - 1);
        ArrayList<boardDTO> currentPageList = new ArrayList<>(boardList.subList(startIndex, endIndex + 1));

        // 시작 페이지와 끝 페이지 계산
        int startPage = ((int) ((double) page / 10 + 0.9)) * 10 - 9;
        int endPage = Math.min(startPage + 9, maxPage);

        // PageInfo 객체 생성 및 값 설정
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPage(page);
        pageInfo.setMaxPage(maxPage);
        pageInfo.setStartPage(startPage);
        pageInfo.setEndPage(endPage);
        pageInfo.setListCount(listCount);

        // JSP로 데이터 전달
        request.setAttribute("boardList", currentPageList);
        request.setAttribute("pageInfo", pageInfo);

        // JSP로 이동
        String url = "/depart/departBoard.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
