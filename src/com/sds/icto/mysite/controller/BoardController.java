package com.sds.icto.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sds.icto.mysite.domain.BoardVo;
import com.sds.icto.mysite.domain.MemberVo;
import com.sds.icto.mysite.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService BoardService;
	
	@RequestMapping(value={"/index","","/"})
	public String index(Model model) {
		
		List<BoardVo> list = BoardService.showList();

		model.addAttribute("list", list);
		
		return "board/listform";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeForm(){
		return "board/writeform";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String join( BoardVo vo, HttpSession session){
		MemberVo authMember = (MemberVo)session.getAttribute("authMember");
		if(authMember == null){
			return "redirect:/board/index";
		}
		
		BoardService.insert( vo );
		return "redirect:/board/index";
	}
	
	@RequestMapping(value = "/view")
	public String view( BoardVo vo, Model model ){
		
		BoardVo boardVo = BoardService.viewContentByNo(vo.getNo());
		model.addAttribute("boardVo", boardVo);

		return "board/contentsform";
	}

	
}
