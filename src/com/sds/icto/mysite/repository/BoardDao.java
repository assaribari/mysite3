package com.sds.icto.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.sds.icto.mysite.domain.BoardVo;

@Repository
public class BoardDao {

	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
	
	public void insert( BoardVo vo ) {

		sqlMapClientTemplate.insert("board.insert", vo);
		
	} //insert
	
	public void delete(BoardVo vo) {
		
		sqlMapClientTemplate.delete("BoardService.delete", vo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<BoardVo> fetchList() {
		List<BoardVo> list = 
				sqlMapClientTemplate.queryForList("board.list");
		
		return list;
	}
	
	public BoardVo getBoardVo(Long no) {
		BoardVo vo = (BoardVo) sqlMapClientTemplate.queryForObject("board.viewbyno", no);
		
		return vo;
	}	
	
//	public void update(BoardVo vo) throws ClassNotFoundException, SQLException {
//		Connection conn = getConnection();
//
//		String sql = "update board set title=?, content=? where no = ? and member_no = ?";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//
//		pstmt.setString(1, vo.getTitle());
//		pstmt.setString(2, vo.getContent());
//		pstmt.setLong(3, vo.getNo());
//		pstmt.setLong(4, vo.getMemberno());
//
//		pstmt.executeUpdate();
//
//		pstmt.close();
//		conn.close();
//	}
//	
//	public BoardVo getBoardVo(BoardVo vo) throws ClassNotFoundException,
//			SQLException {
//		BoardVo boardVo = null;
//
//		Connection conn = getConnection();
//
//		String sql = "select * from board where no = ? and member_no = ?";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//
//		pstmt.setLong(1, vo.getNo());
//		pstmt.setLong(2, vo.getMemberno());
//
//		ResultSet rs = pstmt.executeQuery();
//		if (rs.next()) {
//			Long no = rs.getLong(1);
//			String title = rs.getString(2);
//			String content = rs.getString(3);
//			Long memberno = rs.getLong(4);
//			String name = rs.getString(5);
//			Long viewcount = rs.getLong(6);
//			String sysdate = rs.getString(7);
//
//			boardVo = new BoardVo();
//			boardVo.setNo(no);
//			boardVo.setTitle(title);
//			boardVo.setContent(content);
//			boardVo.setMemberno(memberno);
//			boardVo.setName(name);
//			boardVo.setViewcount(viewcount);
//			boardVo.setSysdate(sysdate);
//		}
//
//		rs.close();
//		pstmt.close();
//		conn.close();
//
//		return boardVo;
//	}
//

	

	
} //BoardDao
