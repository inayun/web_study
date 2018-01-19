package project.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.model.dto.MemberDTO;
import project.model.util.DBService;

public class MemberDAO {

	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static MemberDAO single = null;

	public static MemberDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new MemberDAO();
		//생성된 객체정보를 반환
		return single;
	}
	//conn = DBService.getInstance().getConnection();
	
	
	public static int getCountById(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int count=0;
		
		try {
			
			con = DBService.getInstance().getConnection();
			pstmt = con.prepareStatement("select * from member where id=?");
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt(1);
			}
			
		}finally {
			DBService.close(rset, pstmt, con);;
		}
	return count;
	}
	
	public static MemberDTO getMember(String id, String pwd) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberDTO member = null;
		
		try {
			con = DBService.getInstance().getConnection();
			pstmt = con.prepareStatement("select * from member where id=? and pwd=?");
			pstmt.setString(1,id);
			pstmt.setString(2,pwd);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new MemberDTO();
				member.setMemberCode(rset.getInt(1));
				member.setId(rset.getString(2));
				member.setPwd(rset.getString(3));
				member.setName(rset.getString(4));
				member.setEmail(rset.getString(5));
			}
		} finally {
			DBService.close(rset, pstmt, con);
		}
		return member;
	}
}
