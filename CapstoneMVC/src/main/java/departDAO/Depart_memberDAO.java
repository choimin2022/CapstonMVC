package departDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ezen.member.dao.MemberDao;
import com.ezen.member.dto.MemberDto;

import DBConnect.DBConnect;
import departDAO.Depart_memberDAO;
import departDTO.Depart_memberDTO;

public class Depart_memberDAO {
	//싱글턴 코드
	public Depart_memberDAO() {}
	private static Depart_memberDAO list = new Depart_memberDAO();
	public static Depart_memberDAO getInstance() { return list; }
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	

	public Depart_memberDTO getDepart_member(String d_num) {
		Depart_memberDTO departMember = null;
		
		String sql = "select * from depart_member where d_num=?";
		con = DBConnect.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, d_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				departMember = new Depart_memberDTO();
				departMember.setD_num(rs.getInt("d_num"));
				departMember.setD_code(rs.getString("d_code"));
				departMember.setUserid(rs.getString("userid"));
				departMember.setD_name(rs.getString("name"));
				departMember.setD_name(rs.getString("d_name"));
				departMember.setD_task(rs.getString("d_task"));
				departMember.setD_address(rs.getString("d_address"));
				departMember.setD_img(rs.getString("d_img"));
				departMember.setD_date(rs.getString("d_date"));
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBConnect.close(); }
		
		return departMember;
	}
	public int insertDepart_Member(Depart_memberDTO mdto) { //명함등록
		int result = 0;
		String sql = "insert into depart_member(d_code,userid,name,d_name,d_task,d_address,d_img)"
				+ " values(?,?,?,?,?,?,?)";
		con = DBConnect.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getD_code());
			pstmt.setString(2, mdto.getUserid());
			pstmt.setString(3, mdto.getName());
			pstmt.setString(4, mdto.getD_name());
			pstmt.setString(5, mdto.getD_task());
			pstmt.setString(6, mdto.getD_address());
			pstmt.setString(7, mdto.getD_img());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {  DBConnect.close(); }
		
		return result;
	}
	public List<Depart_memberDTO> getAllDepartMembers() { //어드민은 모든 명함이 보여야 하기에 모든 명함 출력
        List<Depart_memberDTO> memberList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn =  DBConnect.getConnection();
            String sql = "SELECT * FROM depart_member";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int d_num = rs.getInt("d_num");
                String d_code = rs.getString("d_code");
                String userid = rs.getString("userid");
                String name = rs.getString("name");
                String d_name = rs.getString("d_name");
                String d_task = rs.getString("d_task");
                String d_address = rs.getString("d_address");
                String d_img = rs.getString("d_img");
                String d_date = rs.getString("d_date");

                Depart_memberDTO memberDTO = new Depart_memberDTO();
                memberDTO.setD_num(d_num);
                memberDTO.setD_code(d_code);
                memberDTO.setUserid(userid);
                memberDTO.setName(name);
                memberDTO.setD_name(d_name);
                memberDTO.setD_task(d_task);
                memberDTO.setD_address(d_address);
                memberDTO.setD_img(d_img);
                memberDTO.setD_date(d_date);

                memberList.add(memberDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	 DBConnect.close();
        }

        return memberList;
    }
	
	 public Depart_memberDTO getDepartMemberById(String userid) { //계정에 따른 명함 select
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        Depart_memberDTO member = null;

	        try {
	        	conn =  DBConnect.getConnection(); // 데이터베이스 연결을 위한 메서드 호출

	            String sql = "SELECT * FROM depart_member WHERE userid = ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, userid);
	            rs = pstmt.executeQuery();

	            if (rs.next()) {
	                member = new Depart_memberDTO();
	                member.setD_num(rs.getInt("d_num"));
	                member.setName(rs.getString("name"));
	                member.setD_name(rs.getString("d_name"));
	                member.setD_code(rs.getString("d_code"));
	                member.setUserid(rs.getString("userid"));
	                member.setD_task(rs.getString("d_task"));
	                member.setD_address(rs.getString("d_address"));
	                member.setD_img(rs.getString("d_img"));
	                member.setD_date(rs.getString("d_date"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // 리소스 해제
	        	DBConnect.close();
	        }

	        return member;
	    }
	 
	  // 명함 삭제
	 public void deleteDepartMember(String userid) { //명함삭제
		    Connection conn = null;
		    PreparedStatement pstmt = null;

		    try {
		    	conn =  DBConnect.getConnection();
		        String sql = "DELETE FROM depart_member WHERE userid = ?";
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, userid);
		        pstmt.executeUpdate();
		        
		        // 변경 사항을 데이터베이스에 적용하기 위해 커밋
		        conn.commit();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		    	DBConnect.close();
		    }
		}
	 
	 public void updateDepartMember(Depart_memberDTO departMember) { //명함수정
	        String sql = "UPDATE depart_member SET d_name = ?, d_task = ?, d_address = ?, d_img = ? WHERE userid = ?";
	        
	        try (
	        	 Connection conn = DBConnect.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            
	            pstmt.setString(1, departMember.getD_name());
	            pstmt.setString(2, departMember.getD_task());
	            pstmt.setString(3, departMember.getD_address());
	            pstmt.setString(4, departMember.getD_img());
	            pstmt.setString(5, departMember.getUserid());
	          
	            
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 public List<Depart_memberDTO> getDepartMembers(int page, int pageSize) { //페이징처리
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    List<Depart_memberDTO> memberList = new ArrayList<>();

		    try {
		        conn = DBConnect.getConnection();
		        String sql = "SELECT * FROM depart_member ORDER BY d_num DESC LIMIT ?, ?"; //뽑아낼 갯수
		        pstmt = conn.prepareStatement(sql);

		        // 페이징 처리를 위해 시작 인덱스 계산
		        int start = (page - 1) * pageSize;

		        pstmt.setInt(1, start);
		        pstmt.setInt(2, pageSize);
		        rs = pstmt.executeQuery();

		        while (rs.next()) {
		            Depart_memberDTO member = new Depart_memberDTO();
		            member.setD_num(rs.getInt("d_num"));
		            member.setD_code(rs.getString("d_code"));
		            member.setUserid(rs.getString("userid"));
		            member.setD_name(rs.getString("d_name"));
		            member.setD_task(rs.getString("d_task"));
		            member.setD_address(rs.getString("d_address"));
		            member.setD_img(rs.getString("d_img"));
		            member.setD_date(rs.getString("d_date")); 
		            memberList.add(member);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        DBConnect.close();
		    }

		    return memberList;
		}
}


