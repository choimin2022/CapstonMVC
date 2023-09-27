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
	
	public ArrayList<departDTO> selectDepartName() {
		ArrayList<departDTO> list = new ArrayList<departDTO>();
		String sql = "select * from depart_name order by d_name";
		conn = DBConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				departDTO dto = new departDTO();
				dto.setD_id(rs.getString("d_id"));
				dto.setD_name(rs.getString("d_name"));
				dto.setD_url(rs.getString("d_url"));
				list.add(dto); 
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { DBConnect.close();}
		return list;
	}
	
	public departDTO selectDepartNameById(String d_id) { //계열ID에 따른 계열 정보 select
        departDTO departNameDTO = null;

        try {
        	conn =  DBConnect.getConnection(); // 데이터베이스 연결을 위한 메서드 호출

            String sql = "SELECT * FROM depart_name WHERE d_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, d_id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
            	departNameDTO = new departDTO();
            	departNameDTO.setD_id(rs.getString("d_id"));
            	departNameDTO.setD_name(rs.getString("d_name"));
            	departNameDTO.setD_url(rs.getString("d_url"));
            }
           } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 리소스 해제
        	DBConnect.close();
        }

        return departNameDTO;
        }
	}

