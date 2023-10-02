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
	
	// 채팅로그 전체 조회
	public ArrayList<chat_logDTO> selectChatLogs() {
		ArrayList<chat_logDTO> list = new ArrayList<chat_logDTO>();
		String sql = "select * from chat_log order by c_time desc";
		conn = DBConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				chat_logDTO chatLog = new chat_logDTO();
				chatLog.setC_id(rs.getInt("c_id"));
				chatLog.setUserid(rs.getString("userid"));
				chatLog.setT_question(rs.getString("t_question"));
				chatLog.setT_answer(rs.getString("t_answer"));
				chatLog.setC_time(rs.getString("c_time")); //
				list.add(chatLog); 
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			DBConnect.close(); // 리소스 해제
		}
		return list;
	}
	
	// 채팅로그 ID에 따른 채팅로그 조회
	public chat_logDTO selectChatLogById(int c_id) {
		chat_logDTO chatLog = null;

		conn = DBConnect.getConnection();
		try {
        	pstmt = conn.prepareStatement("SELECT * FROM chat_log WHERE c_id = ?");
            pstmt.setInt(1, c_id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
            	chatLog = new chat_logDTO();
            	chatLog.setC_id(rs.getInt("c_id"));
            	chatLog.setUserid(rs.getString("userid"));
            	chatLog.setT_question(rs.getString("t_question"));
            	chatLog.setT_answer(rs.getString("t_answer"));
            	chatLog.setC_time(rs.getString("c_time")); //
            }
           } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(); // 리소스 해제
        }

        return chatLog;
    }
	
	// 채팅로그 등록
	public void insertChatLog(chat_logDTO chatLog) {
		String sql = "insert into chat_log (userid, t_question, t_answer) values (?, ?, ?)";
		conn = DBConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, chatLog.getUserid());
			pstmt.setString(2, chatLog.getT_question());
			pstmt.setString(3, chatLog.getT_answer());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.close(); // 리소스 해제
		}
	}
	// 채팅로그 삭제
	public void deleteChatLog(int c_id) {
		String sql = "delete from chat_log where c_id = ?";
		conn = DBConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, c_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.close(); // 리소스 해제
		}
	}
}
