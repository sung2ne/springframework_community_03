package com.test.community.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.test.community.vo.BoardVO;

@Mapper
public interface BoardMapper {
    
	// 게시글 등록
    int insert(BoardVO boardVO);

}
