package com.sds.icto.mysite.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.icto.mysite.domain.GuestBookVo;
import com.sds.icto.mysite.repository.GuestBookDao;



@Service
public class GuestBookService {

	@Autowired
	GuestBookDao GuestBookDao;
	
	public ArrayList<GuestBookVo> showIndex() {
		ArrayList<GuestBookVo> list = (ArrayList<GuestBookVo>) GuestBookDao.fetchList();
		return list;
	}
	
	public void insert(String name, String password, String message){
		GuestBookVo vo = new GuestBookVo();
		vo.setName(name);
		vo.setPassword(password);
		vo.setMessage(message);
		
		GuestBookDao.insert(vo);
	}
	
	public void delete(String no, String password) {
		GuestBookDao.delete(Long.parseLong(no), password);
	}
}
