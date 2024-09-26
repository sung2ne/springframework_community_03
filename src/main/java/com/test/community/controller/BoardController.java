package com.test.community.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.community.service.BoardService;
import com.test.community.vo.BoardVO;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService boardService;
	
	// 게시글 등록(화면)
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView createGET() {
		ModelAndView mav = new ModelAndView("board/create");
		return mav;
	}
	
	// 게시글 등록(처리)
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String createPOST(BoardVO boardVO) {
		// 글 등록
		int cnt = this.boardService.insert(boardVO);
		
		// 게시글 등록 실패 시 게시글 등록(화면)으로 다시 이동
		if (cnt < 1) {
			return "redirect:/create";
		}	
		
		// 게시글 등록 성공 시 게시글 조회로 이동
		return "redirect:/read/" + boardVO.getSeq();
	}
	
}