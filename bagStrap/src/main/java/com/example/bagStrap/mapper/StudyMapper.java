package com.example.bagStrap.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.bagStrap.model.Item;
import com.example.bagStrap.model.StudyComm;

//
@Mapper
public interface StudyMapper {
	List<Item> searchItem(HashMap<String, Object> map);
	List<Item> searchCodes(HashMap<String, Object> map);
	
	//스터디 커뮤니티 카테고리 타입
	List<StudyComm> selectStuComm(HashMap<String, Object> map);
	//스터디 커뮤니티 리스트 
	List<StudyComm> selectStuCommList(HashMap<String, Object> map);
	//스터디 커뮤니티  컨텐츠 보드
	List<StudyComm> selectStuCommListBoard(HashMap<String, Object> map);
	//스터디 커뮤니티 게시글 개수
	int countCommList(HashMap<String, Object> map);
	// 나의 커뮤니티 개시글 개수 
	int countMyCommList(HashMap<String, Object> map);
	// 나의 커뮤니티 댓글 개수 
	int countMycommentList(HashMap<String, Object> map);
	//스터디 커뮤니티 게시글 상세보기
	StudyComm selectCommView(HashMap<String, Object> map);
	//스터디 커뮤니티 게시글 상세보기 댓글
	List<StudyComm>selectViewComment(HashMap<String, Object> map);
	//스터디 커뮤니티 게시글 상세보기 댓글 작성
	void insertViewComment(HashMap<String, Object> map);
}
