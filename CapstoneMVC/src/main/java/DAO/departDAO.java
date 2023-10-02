package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBConnect.DBConnect;
import DTO.departDTO;

public class departDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 계열 정보 전체 조회
	public ArrayList<departDTO> selectDepartNames() {
		ArrayList<departDTO> list = new ArrayList<departDTO>();
		String sql = "select * from depart_name order by d_name";
		conn = DBConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				departDTO departDTO = new departDTO();
				departDTO.setD_id(rs.getString("d_id"));
				departDTO.setD_name(rs.getString("d_name"));
				list.add(departDTO); 
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			DBConnect.close(); 
		}
		return list;
	}
	
	// 계열 ID에 따른 계열 정보 조회
	public departDTO selectDepartNameById(String d_id) {
		departDTO departDTO = null;

		conn = DBConnect.getConnection();
		try {
        	pstmt = conn.prepareStatement("SELECT * FROM depart_name WHERE d_id = ?");
            pstmt.setString(1, d_id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
            	departDTO = new departDTO();
            	departDTO.setD_id(rs.getString("d_id"));
            	departDTO.setD_name(rs.getString("d_name"));
            }
           } 
		catch (SQLException e) {
            e.printStackTrace();
        } 
		finally {
            DBConnect.close(); 
        }

        return departDTO;
    }
	
	// 계열 정보 수정
	public void updateDepartName(departDTO departDTO) {
		String sql = "update depart_name set d_name = ? where d_id = ?";
		conn = DBConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, departDTO.getD_name());
			pstmt.setString(2, departDTO.getD_id());
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			DBConnect.close(); 
		}
	}
	
	// 계열 정보 삭제
	public void deleteDepartName(String d_id) {
		String sql = "delete from depart_name where d_id = ?";
		conn = DBConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, d_id);
			pstmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			DBConnect.close(); 
		}
	}
	}

