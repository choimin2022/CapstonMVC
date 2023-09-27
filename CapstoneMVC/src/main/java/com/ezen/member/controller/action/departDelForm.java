package com.ezen.member.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import departDAO.Depart_memberDAO;
import departDTO.Depart_memberDTO;

public class departDelForm implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        
        Depart_memberDAO memberDAO = Depart_memberDAO.getInstance();
        memberDAO.deleteDepartMember(userid);

        // 삭제 후 리다이렉트 또는 다른 처리
        response.sendRedirect("member.do?command=main");
    }
}
  