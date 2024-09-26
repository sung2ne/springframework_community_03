package com.test.community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.community.mapper.BoardMapper;
import com.test.community.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper boardgMapper;
	
	@Autowired
	public BoardServiceImpl(BoardMapper boardgMapper) {
		this.boardgMapper = boardgMapper;
	}

	// 게시글 등록
	@Override
	@Transactional
	public int insert(BoardVO boardVO) {
		return this.boardgMapper.insert(boardVO);
	}

}
