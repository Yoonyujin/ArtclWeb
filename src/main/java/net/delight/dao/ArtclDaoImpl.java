package net.delight.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.delight.vo.ArtclVO;

public class ArtclDaoImpl implements ArtclDao {

	@Override
	public List<ArtclVO> getArtclList() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTCL", "yyj6240)");
			StringBuffer query = new StringBuffer();
			query.append(" SELECT ARTCL_ID ");
			query.append(" 		  , SBJ ");
			query.append(" 		  , CONT ");
			query.append(" 		  , CRT_DT ");
			query.append(" FROM		ARTCL ");
			
			pstmt = conn.prepareStatement(query.toString());
			rs = pstmt.executeQuery();
			
			List<ArtclVO> artcls = new ArrayList<ArtclVO>();
			ArtclVO artclVO = null;
			
			while(rs.next()) {
				artclVO = new ArtclVO();
				artclVO.setArtclId(rs.getInt("ARTCL_ID"));
				artclVO.setSubject(rs.getString("SBJ"));
				artclVO.setContent(rs.getString("CONT"));
				artclVO.setCreateDate(rs.getString("CRT_DT"));
				
				artcls.add(artclVO);
			}
			return artcls;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally{
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
			
		}
		
	}
	
	

}
