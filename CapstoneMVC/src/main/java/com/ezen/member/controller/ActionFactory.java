package com.ezen.member.controller;

import com.ezen.member.controller.action.Action;

import com.ezen.member.controller.action.*;
import vo.PageInfo;


public class ActionFactory {
	private ActionFactory() {};
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() { return itc; }

	public Action getAction(String command) {
		Action ac = null;
		if(command.equals("ChatMain")) ac = new ChatMainAction();
		else if(command.equals("loginForm")) ac = new LoginFormAction();
		else if(command.equals("login")) ac = new LoginAction();
		else if(command.equals("logout")) ac = new LogOutAction();
		else if(command.equals("loginSession")) ac = new LoginSessionAction();
		else if(command.equals("joinForm")) ac = new JoinFormAction();
		else if(command.equals("idcheck")) ac = new IdCheckAction();
		else if(command.equals("join")) ac = new JoinAction();
		else if(command.equals("updateForm")) ac = new UpdateFormAction();
		else if(command.equals("update")) ac = new UpdateAction();
		else if(command.equals("main")) ac = new MainAction();
		else if(command.equals("editAdmin")) ac = new EditAdminAction();
		else if(command.equals("deleteMember")) ac = new DeleteMemberAction();
		else if(command.equals("departmember")) ac = new departMemberForm();
		else if(command.equals("departaction")) ac = new departAction();
		else if(command.equals("departlistaction")) ac = new departListAction();
		else if(command.equals("departdetail")) ac = new departDetailForm();
		else if(command.equals("departedit")) ac = new departEditForm();
		else if(command.equals("departeditaction")) ac = new departEditAction();
		else if(command.equals("departdel")) ac = new departDelForm();
		else if(command.equals("departdel")) ac = new PageInfo();
		

		return ac;
	}
}
