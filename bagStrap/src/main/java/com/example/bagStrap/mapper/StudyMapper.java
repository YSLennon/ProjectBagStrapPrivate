package com.example.bagStrap.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.bagStrap.model.Item;
import com.example.bagStrap.model.StudyComm;

//
@Mapper
public interface StudyMapper {
	
	// ------------------------------- 스터디 커뮤니티 --------------------------------------
	
	//스터디 커뮤니티 카테고리 타입
	List<StudyComm> selectStuComm(HashMap<String, Object> map);
	//스터디 커뮤니티 리스트 
	List<StudyComm> selectStuCommList(HashMap<String, Object> map);
	//스터디 커뮤니티 컨텐츠 보드
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
	//스터디 커뮤니티 나의 게시글
	List<StudyComm> selectMyComm(HashMap<String, Object> map);
	//스터디 커뮤니티 나의 댓글 
	List<StudyComm> selectMyComment(HashMap<String, Object> map);
	//스터디 커뮤니티 게시글 작성하기 카테고리  
	List<StudyComm> selectMyCommCategory(HashMap<String, Object> map);
	//스터디 커뮤니티 게시글 작성 
	void insertComm(HashMap<String, Object> map); 
	// 스터디 커뮤티 게시글 작성 이미지 첨부
	void insertBoardFile(HashMap<String, Object> map);
	// 스터디 커뮤티 게시글 삭제
	void deleteBoard(HashMap<String, Object> map);
	// 스터디 커뮤티 게시글 숨기기
	void updateStatusBoard(HashMap<String, Object> map);
	// 스터디 커뮤니티 게시글 업데이트
	void updateComm(HashMap<String, Object> map);
	// 스터디 커뮤티 게시글 댓글 숨기기
	void updateStatusBoardComment(HashMap<String, Object> map);
	// 스터디 커뮤니티 게시글 댓글 삭제
	void deleteBoardComment(HashMap<String, Object> map);
	// 스터디 커뮤티 게시글 좋아요
	void insertCommLike(HashMap<String, Object> map);
	// 스터디 커뮤니티 게시글 댓글 좋아요
	void insertCommentLike(HashMap<String, Object> map);
	//스터디 커뮤니티 상세보기 좋아요 중복체크  
	StudyComm selectLikeCheck(HashMap<String, Object> map);
	// 스터디 커뮤니티 상세보기 좋아요 삭제
	void deleteCommentLike(HashMap<String, Object> map);
	// 스터디 커뮤니티 조회수
	void updateCommViews(HashMap<String, Object> map);
	// 스터디 커뮤니티 좋아요수 갱신  
	StudyComm selectgetLikeCount(HashMap<String, Object> map);
	// 스터디 커뮤니티  댓글 수정모드 
	void updateComment(HashMap<String, Object> map);
	// 스터디 커뮤니티  댓글 수정모드 N
	void updateCommentNO(HashMap<String, Object> map);
	// 스터디 커뮤니티  답글 세트
	void updateCommentRENO(HashMap<String, Object> map);
	// 스터디 커뮤니티 수정완료처리
	void updateCommentResult(HashMap<String, Object> map);
	// 스터디 커뮤니티 답글 모드
	void updateCommentREY(HashMap<String, Object> map);
	// 스터디 커뮤니티 답글 수정완료처리
	void updateCommentReResult(HashMap<String, Object> map);
	
	// ------------------------------- 스터디 그룹 --------------------------------------
	
	//스터디 그룹 만들기(책 불러오기)
	List<StudyComm> selectStuGroupInsertBoardType(HashMap<String, Object> map);
	//스터디 그룹 만들기
	void insertStuGroup(HashMap<String, Object> map);	
	//스터디 그룹 리스트 사이드바
	List<StudyComm> selectStuGroupListSidebar(HashMap<String, Object> map);
	//스터디 그룹 개수(페이징)
	int selectStuGroupListSidebarCnt(HashMap<String, Object> map);
	//스터디 상세정보
	StudyComm selectStuGroupDetail(HashMap<String, Object> map);
	//스터디 신청하기
	void insertStuGroupApply(HashMap<String, Object> map);
	//스터디 중복신청검사
	StudyComm selectStuGroupSubscription(HashMap<String, Object> map);
	//마이페이지 스터디그룹
	List<StudyComm> selectStuGroupMyPage(HashMap<String, Object> map);
	//스터디 방장 자동가입
	void insertStuGroupKingApply(HashMap<String, Object> map);
	//마이스터디 -> 상세페이지 스터디 그룹 사람검색
	StudyComm selectStuGroupUserSearch(HashMap<String, Object> map);
	//마이스터디 -> 상세페이지 유저 학습목표 가져오기
	StudyComm selectStuGroupUserApplSearch(HashMap<String, Object> map);
	//마이페이지 -> 스터디그룹 가입목록 확인
	List<StudyComm> selectStuGroupSubscriptionSearch(HashMap<String, Object> map);
	//마이페이지 -> 스터디그룹 가입목록 확인(페이징)
	List<StudyComm> selectStuGroupSubscriptionSearchPage(HashMap<String, Object> map);
	//마이페이지 -> 스터디그룹 가입목록 인원수 확인 (페이징)
	int selectStuGroupSubscriptionSearchCnt(HashMap<String, Object> map);
	//마이페이지 -> 스터디그룹 미가입목록 확인
	List<StudyComm> selectStuGroupSubscriptionSearchN(HashMap<String, Object> map);
	//마이페이지 -> 스터디그룹 강퇴목록 확인
	List<StudyComm> selectStuGroupSubscriptionSearchL(HashMap<String, Object> map);
	//마이페이지 -> 스터디그룹 수정
	void updateStuGroup(HashMap<String, Object> map);
	//마이페이지 -> 스터디 강퇴
	void updateStuGroupLeave(HashMap<String, Object> map);
	//마이페이지 -> 스터디 강퇴 모드
	void updateStuGroupLeaveMode(HashMap<String, Object> map);
	//마이페이지 -> 스터디 강퇴 모드 풀기
	void updateStuGroupLeaveModeNo(HashMap<String, Object> map);
	//마이페이지 -> 스터디 차단 풀기
	void deleteStuGroupUnblocking(HashMap<String, Object> map);
	//마이페이지 -> 스터디 그룹장 위임
	void updateStuGroupBossDelegation(HashMap<String, Object> map);
	//마이페이지 -> 스터디 가입 승인 
	void updateStuGroupJoin(HashMap<String, Object> map);
	//마이페이지 -> 스터디그룹 해체 
	void deleteStuGroup(HashMap<String, Object> map);
	void deleteStuGroup2(HashMap<String, Object> map);
	//스터디긔룹 채팅같은 게시판 
	void insertStuGroupMessage(HashMap<String, Object> map);
	//스터디 채팅 불러오기 
	List<StudyComm> selectStuGroupMessage(HashMap<String, Object> map);
	//스터디 채팅삭제
	void deletGroupMessage(HashMap<String, Object> map);
	// 나의 스터디 개수 
	int countMyStudy(HashMap<String, Object> map);
	//마이페이지 내 스터디 숨기기
	void updateStuGroupHide(HashMap<String, Object> map);
	//스터디 나의 학습목표 수정하기
	void updateStuGoal(HashMap<String, Object> map);
	//노트필기 경쟁대회 수상 3001
	List<StudyComm> selectEvent3001(HashMap<String, Object> map);
	//오답노트 3002  
	List<StudyComm> selectEvent3002(HashMap<String, Object> map);
	// 사이드바 사람 정보
	StudyComm selectStuSidebar(HashMap<String, Object> map);
	// 책 top5
	List<StudyComm> selectTop5(HashMap<String, Object> map);
}