package com.ezen.member.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import departDAO.Depart_memberDAO;
import departDTO.Depart_memberDTO;

public class departEditAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        String name = request.getParameter("d_name");
        String task = request.getParameter("d_task");
        String address = request.getParameter("d_address");
        String image = request.getParameter("d_img");

        Depart_memberDAO memberDAO = Depart_memberDAO.getInstance();
        Depart_memberDTO departMember = memberDAO.getDepartMemberById(userid);

        departMember.setD_name(name);
        departMember.setD_task(task);
        departMember.setD_address(address);
        departMember.setD_img(image);

        // 업데이트 수행
        memberDAO.updateDepartMember(departMember);

        // 업데이트 후 해당 페이지로 이동
        String url = "member.do?command=main";
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}