package com.sds.icto.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sds.icto.mysite.domain.GuestBookVo;
import com.sds.icto.mysite.repository.GuestBookDao;
import com.sds.icto.mysite.service.GuestBookService;



@Controller
@RequestMapping("/guestbook")
public class GuestBookController {

	@Autowired
	GuestBookService GuestBookService;
	
	
	@RequestMapping(value={"/index","","/"})
	public String index(Model model) {
		
		model.addAttribute("list", GuestBookService.showIndex());
		
		return "guestbook/list";
	}
	

	@RequestMapping(value= "/insert", method=RequestMethod.POST)
	public String insert( @RequestParam("name") String name, 
			@RequestParam("pass") String password,
			@RequestParam("content") String message)
			{
		
		GuestBookService.insert(name, password, message);

		return "redirect: index";
	
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteForm(){
		return "guestbook/deleteform";
	}


	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String join( 
			@RequestParam("no") String no,
			@RequestParam("password") String password
			){

		GuestBookService.delete(no, password);
		
		return "redirect: index";
	}
	
}
