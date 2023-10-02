package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBConnect.DBConnect;
import DTO.proDTO;

public class proDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 교수 정보 전체 조회
	public ArrayList<proDTO> selectProNames() {
		ArrayList<proDTO> list = new ArrayList<proDTO>();
		String sql = "select * from pro_name order by p_name";
		conn = DBConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				proDTO professor = new proDTO();
				professor.setP_id(rs.getString("p_id"));
				professor.setD_id(rs.getString("d_id"));
				professor.setP_name(rs.getString("p_name"));
				professor.setP_url(rs.getString("p_url"));
				list.add(professor); 
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			DBConnect.close(); 
		}
		return list;
	}
	
	// 교수 ID에 따른 교수 정보 조회
	public proDTO selectProNameById(String p_id) {
		proDTO professor = null;

		conn = DBConnect.getConnection();
		try {
        	pstmt = conn.prepareStatement("SELECT * FROM pro_name WHERE p_id = ?");
            pstmt.setString(1, p_id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
            	professor = new proDTO();
            	professor.setP_id(rs.getString("p_id"));
            	professor.setD_id(rs.getString("d_id"));
            	professor.setP_name(rs.getString("p_name"));
            	professor.setP_url(rs.getString("p_url"));
            }
           } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(); 
        }

        return professor;
    }
	
	// 교수 정보 수정
	public void updateProName(proDTO professor) {
		String sql = "update pro_name set p_name = ?, p_url = ? where p_id = ?";
		conn = DBConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, professor.getP_name());
			pstmt.setString(2, professor.getP_url());
			pstmt.setString(3, professor.getP_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.close();
		}
	}
	
	// 교수 정보 삭제
	public void deleteProName(String p_id) {
		String sql = "delete from pro_name where p_id = ?";
		conn = DBConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.close(); 
		}
	}
}

