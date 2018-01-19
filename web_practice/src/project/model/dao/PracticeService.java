package project.model.dao;

import java.sql.SQLException;

import project.model.dto.MemberDTO;

public class PracticeService {

	
	//member
	public static int getCountByIdPwd(String id) throws SQLException{
		return MemberDAO.getCountById(id);
	}
	
	public static MemberDTO getMember(String id, String pwd) throws SQLException{
		return MemberDAO.getMember(id,pwd);
	}
	
}
