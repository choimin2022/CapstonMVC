package com.ezen.member.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import departDAO.Depart_memberDAO;
import departDTO.Depart_memberDTO;

public class departEditForm implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");

        Depart_memberDAO memberDAO = Depart_memberDAO.getInstance();
        Depart_memberDTO departMember = memberDAO.getDepartMemberById(userid);

        request.setAttribute("depart_member", departMember);

        String url = "/depart/departEdit.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}