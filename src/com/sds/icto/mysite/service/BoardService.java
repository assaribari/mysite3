package com.sds.icto.mysite.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.icto.mysite.domain.BoardVo;
import com.sds.icto.mysite.repository.BoardDao;

@Service
public class BoardService {

	@Autowired
	BoardDao BoardDao;

	public void insert(BoardVo vo) {
		BoardDao.insert(vo);
	}

	public void delete() {
	}

	public ArrayList<BoardVo> showList() {
		ArrayList<BoardVo> list = (ArrayList<BoardVo>) BoardDao.fetchList();
		return list;
	}

	public BoardVo viewContentByNo(Long no){
		BoardVo vo = BoardDao.getBoardVo(no);
		return vo;
	}
	
}
	
	
	/*

	delete
	update
	getboard
	list
	
	
	*/

