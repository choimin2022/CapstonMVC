package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBConnect.DBConnect;
import DTO.webDTO;

public class webDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 웹 이름 전체 조회
	public ArrayList<webDTO> selectWebNames() {
		ArrayList<webDTO> list = new ArrayList<webDTO>();
		String sql = "select * from web_name order by w_name";
		conn = DBConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				webDTO dto = new webDTO();
				dto.setW_code(rs.getString("w_code"));
				dto.setW_name(rs.getString("w_name"));
				dto.setW_url(rs.getString("w_url"));
				list.add(dto); 
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			DBConnect.close(); 
		}
		return list;
	}
	
	// 웹 이름 ID에 따른 웹 이름 조회
	public webDTO selectWebNameById(String w_code) {
		webDTO webNameDTO = null;

		conn = DBConnect.getConnection();
		try {
        	pstmt = conn.prepareStatement("SELECT * FROM web_name WHERE w_code = ?");
            pstmt.setString(1, w_code);
            rs = pstmt.executeQuery();

            if (rs.next()) {
            	webNameDTO = new webDTO();
            	webNameDTO.setW_code(rs.getString("w_code"));
            	webNameDTO.setW_name(rs.getString("w_name"));
            	webNameDTO.setW_url(rs.getString("w_url"));
            }
           } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(); 
        }

        return webNameDTO;
    }
	
	// 웹 이름 수정
	public void updateWebName(webDTO webNameDTO) {
		String sql = "update web_name set w_name = ?, w_url = ? where w_code = ?";
		conn = DBConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, webNameDTO.getW_name());
			pstmt.setString(2, webNameDTO.getW_url());
			pstmt.setString(3, webNameDTO.getW_code());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.close(); 
		}
	}
	
	// 웹 이름 삭제
	public void deleteWebName(String w_code) {
		String sql = "delete from web_name where w_code = ?";
		conn = DBConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, w_code);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.close(); 
		}
	}
}
