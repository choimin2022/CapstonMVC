package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezen.member.dao.MemberDao;

import DBConnect.DBConnect;
import DTO.boardDTO;

public class boardDAO {
    private static boardDAO list = new boardDAO();

    //싱글톤 패턴
    private boardDAO() {}

    public static boardDAO getInstance() {
        return list;
    }

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    // 게시글 전체 조회
    public ArrayList<boardDTO> selectBoardList() {
        ArrayList<boardDTO> list = new ArrayList<boardDTO>();
        String sql = "select * from board order by b_num desc";
        conn = DBConnect.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                boardDTO boardDTO = new boardDTO();
                boardDTO.setB_num(rs.getInt("b_num"));
                boardDTO.setU_id(rs.getString("u_id"));
                boardDTO.setB_title(rs.getString("b_title"));
                boardDTO.setB_content(rs.getString("b_content"));
                boardDTO.setB_like(rs.getInt("b_like"));
                boardDTO.setB_check(rs.getBoolean("b_check"));
                boardDTO.setB_date(rs.getString("b_date"));
                list.add(boardDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(); 
        }
        return list;
    }

    // 게시글 상세 조회
    public boardDTO selectBoardByNum(int b_num) {
        boardDTO boardDTO = null;
        String sql = "select * from board where b_num = ?";
        conn = DBConnect.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, b_num);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                boardDTO = new boardDTO();
                boardDTO.setB_num(rs.getInt("b_num"));
                boardDTO.setU_id(rs.getString("u_id"));
                boardDTO.setB_title(rs.getString("b_title"));
                boardDTO.setB_content(rs.getString("b_content"));
                boardDTO.setB_like(rs.getInt("b_like"));
                boardDTO.setB_check(rs.getBoolean("b_check"));
                boardDTO.setB_date(rs.getString("b_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.close();
        }
        return boardDTO;
    }

    // 게시글 작성
    public int insertBoard(boardDTO boardDTO) {
        int result = 0;
        String sql = "insert into board (u_id, b_title, b_content, b_like, b_check) values (?, ?, ?, ?, ?)";
        conn = DBConnect.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, boardDTO.getU_id());
            pstmt.setString(2, boardDTO.getB_title());
            pstmt.setString(3, boardDTO.getB_content());
            pstmt.setInt(4, boardDTO.getB_like());
            pstmt.setBoolean(5, boardDTO.isB_check());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(); 
        }
        return result;
    }
 // 게시글 수정
    public int updateBoard(boardDTO boardDTO) {
        int result = 0;
        String sql = "update board set b_title = ?, b_content = ? where b_num = ?";
        conn = DBConnect.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, boardDTO.getB_title());
            pstmt.setString(2, boardDTO.getB_content());
            pstmt.setInt(3, boardDTO.getB_num());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(); 
        }
        return result;
    }

 // 게시글 삭제
    public void deleteBoard(int b_num) {
        String sql = "delete from board where b_num = ?";
        conn = DBConnect.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, b_num);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(); 
        }
    }
 // 게시글 좋아요 여부 확인
    public boolean checkBoardLike(int b_num, String u_id) {
        boolean check = false;
        String sql = "select b_check from board where b_num = ? and u_id = ?";
        conn = DBConnect.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, b_num);
            pstmt.setString(2, u_id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                check = rs.getBoolean("b_check");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(); 
        }
        return check;
    }

}

