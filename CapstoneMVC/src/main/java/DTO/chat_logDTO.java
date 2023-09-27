package DTO;

public class chat_logDTO {
	private int c_id;
	private String userid;
	private String t_question;
	private String t_answer;
	private String c_time;

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getT_question() {
		return t_question;
	}

	public void setT_question(String t_question) {
		this.t_question = t_question;
	}

	public String getT_answer() {
		return t_answer;
	}

	public void setT_answer(String t_answer) {
		this.t_answer = t_answer;
	}

	public String getC_time() {
		return c_time;
	}

	public void setC_time(String c_time) {
		this.c_time = c_time;
	}
}
