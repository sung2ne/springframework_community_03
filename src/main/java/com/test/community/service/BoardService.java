package com.test.community.service;

import com.test.community.vo.BoardVO;

public interface BoardService {
	
	// 게시글 등록
    int insert(BoardVO boardVO);

}
