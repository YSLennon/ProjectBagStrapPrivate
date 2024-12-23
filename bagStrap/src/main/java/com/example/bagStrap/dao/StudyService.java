package com.example.bagStrap.dao;

import java.util.HashMap;

public interface StudyService {
	// ------------------------------- 스터디 커뮤니티 --------------------------------------
	
	//스터디 사이드바 커뮤니티 카테고리 타입
	HashMap<String, Object> selectStuComm(HashMap<String, Object> map);
	//스터디 사이드바 나의 게시글 개수
	HashMap<String, Object> sidebarCnt(HashMap<String, Object> map);
	//스터디 커뮤니티 컨텐츠 
	HashMap<String, Object> selectStuCommListBoard(HashMap<String, Object> map);
	//나의 게시글, 댓글 목록
	HashMap<String, Object> myCnt(HashMap<String, Object> map);
	//스터디 커뮤니티 게시글 상세보기
	HashMap<String, Object> selectCommView(HashMap<String, Object> map);
	//스터디 커뮤니티 게시글 상세보기 댓글작성
	HashMap<String, Object> insertViewComment(HashMap<String, Object> map);
	//스터디 커뮤니티 게시글 작성하기 카테고리  
	HashMap<String, Object> selectMyCommCategory(HashMap<String, Object> map);
	//스터디 커뮤니티 게시글 작성하기
	HashMap<String, Object> insertComm(HashMap<String, Object> map);	
	//스터디 커뮤니티 게시글 파일업로드
	HashMap<String, Object> addBoardFile(HashMap<String, Object> map);
	// 스터디 커뮤티 게시글 삭제
	HashMap<String, Object> deleteBoard(HashMap<String, Object> map);
	// 스터디 커뮤티 게시글 숨기기
	HashMap<String, Object> updateStatusBoard(HashMap<String, Object> map);
	// 스터디 커뮤니티 업데이트
	HashMap<String, Object> updateComm(HashMap<String, Object> map);
	// 스터디 커뮤티 게시글 댓글 숨기기
	HashMap<String, Object> updateStatusBoardComment(HashMap<String, Object> map);
	// 스터디 커뮤니티 게시글 댓글 삭제
	HashMap<String, Object> deleteBoardComment(HashMap<String, Object> map);
	// 스터디 커뮤티 게시글 좋아요
	HashMap<String, Object> insertCommLike(HashMap<String, Object> map);
	// 스터디 커뮤니티 게시글 댓글 좋아요
	HashMap<String, Object> insertCommentLike(HashMap<String, Object> map);
	//스터디 커뮤니티 상세보기 좋아요 중복체크  
	HashMap<String, Object> selectLikeCheck(HashMap<String, Object> map);
	//스터디 커뮤니티 상세보기 좋아요 삭제
	HashMap<String, Object> deleteCommentLike(HashMap<String, Object> map);
	// 스터디 커뮤니티 좋아요수 갱신  
	HashMap<String, Object> selectgetLikeCount(HashMap<String, Object> map);
	// 스터디 커뮤니티 댓글 수정모드 
	HashMap<String, Object> updateComment(HashMap<String, Object> map);
	// 스터디 커뮤니티 댓글 수정모드 N
	HashMap<String, Object> updateCommentNO(HashMap<String, Object> map);
	// 스터디 커뮤니티 댓글 수정 완료처리
	HashMap<String, Object> updateCommentResult(HashMap<String, Object> map);
	// 스터디 커뮤니티 답글 세트
	HashMap<String, Object> updateCommentRENO(HashMap<String, Object> map);
	// 스터디 커뮤니티 답글 모드
	HashMap<String, Object> updateCommentREY(HashMap<String, Object> map);
	// 스터디 커뮤니티 답글 수정완료처리
	HashMap<String, Object> updateCommentReResult(HashMap<String, Object> map);
	// ------------------------------- 스터디 그룹 --------------------------------------
	
	//스터디 그룹 만들기(책 불러오기)
	HashMap<String, Object> selectStuGroupInsertBoardType(HashMap<String, Object> map);
	//스터디 그룹 만들기
	HashMap<String, Object> insertStuGroup(HashMap<String, Object> map);	
	//스터디 그룹 리스트 사이드바
	HashMap<String, Object> selectStuGroupListSidebar(HashMap<String, Object> map);	
	//스터디 그룹 상세정보
	HashMap<String, Object> selectStuGroupDetail(HashMap<String, Object> map);	
	//스터디 신청하기 
	HashMap<String, Object> insertStuGroupApply(HashMap<String, Object> map);	
	//스터디 중복가입 방지
	HashMap<String, Object> selectStuGroupSubscription(HashMap<String, Object> map);	
	//스터디 방장 자동가입
	HashMap<String, Object> insertStuGroupKingApply(HashMap<String, Object> map);	
	//스터디 그룹 사람검색
	HashMap<String, Object> selectStuGroupUserSearch(HashMap<String, Object> map);	
	//마이페이지 -> 스터디그룹 수정
	HashMap<String, Object> updateStuGroup(HashMap<String, Object> map);
	//마이페이지 -> 스터디 강퇴
	HashMap<String, Object> updateStuGroupLeave(HashMap<String, Object> map);
	//마이페이지 -> 스터디 강퇴 모드
	HashMap<String, Object> updateStuGroupLeaveMode(HashMap<String, Object> map);
	//마이페이지 -> 스터디 차단 풀기
	HashMap<String, Object> deleteStuGroupUnblocking(HashMap<String, Object> map);
	//마이페이지 -> 스터디 그룹장 위임
	HashMap<String, Object> updateStuGroupBossDelegation(HashMap<String, Object> map);
	//마이페이지 -> 스터디 가입 승인 
	HashMap<String, Object> updateStuGroupJoin(HashMap<String, Object> map);
	//마이페이지 -> 스터디그룹 해체 
	HashMap<String, Object> deleteStuGroup(HashMap<String, Object> map);
	//스터디긔룹 채팅같은 게시글 쓰기
	HashMap<String, Object> insertStuGroupMessage(HashMap<String, Object> map);
	//스터디 채팅 불러오기 
	HashMap<String, Object> selectStuGroupMessage(HashMap<String, Object> map);
	//스터디 채팅삭제 
	HashMap<String, Object> deletGroupMessage(HashMap<String, Object> map);
	//마이페이지 내 스터디 숨기기
	HashMap<String, Object> updateStuGroupHide(HashMap<String, Object> map);
	//스터디 나의 학습목표 수정하기
	HashMap<String, Object> updateStuGoal(HashMap<String, Object> map);
	//노트필기 경쟁대회 수상 3001
	HashMap<String, Object> selectEvent3001(HashMap<String, Object> map);
	//마이스터디 -> 상세페이지 가입유저(페이징처리)
	HashMap<String, Object> selectStuGroupSubscriptionSearchPage(HashMap<String, Object> map);
	// 책 top5
	HashMap<String, Object> selectTop5(HashMap<String, Object> map);
	
}
