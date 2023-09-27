package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBConnect.DBConnect;
import DTO.chat_logDTO;

public class chat_logDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public ArrayList<chat_logDTO> selectChatLog() {
		  ArrayList<chat_logDTO> list = new ArrayList<chat_logDTO>();
		  String sql = "select * from chat_log order by c_time desc";
		  conn = DBConnect.getConnection();
		  try {
		    pstmt = conn.prepareStatement(sql);
		    rs = pstmt.executeQuery();
		    while (rs.next()) {
		      chat_logDTO dto = new chat_logDTO();
		      dto.setC_id(rs.getInt("c_id"));
		      dto.setUserid(rs.getString("userid"));
		      dto.setT_question(rs.getString("t_question"));
		      dto.setT_answer(rs.getString("t_answer"));
		      list.add(dto);
		    }
		  } catch (SQLException e) {
		    e.printStackTrace();
		  } finally {
		    DBConnect.close();
		  }
		  return list;
		}

	public void insertChatLog(chat_logDTO dto) {
		String sql = "insert into chat_log(userid, t_question, t_answer) values (?, ?, ?)";
		conn = DBConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getT_question());
			pstmt.setString(3, dto.getT_answer());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.close();
		}
	}
}
