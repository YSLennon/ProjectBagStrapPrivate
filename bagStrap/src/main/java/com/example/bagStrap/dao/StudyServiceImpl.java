package com.example.bagStrap.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bagStrap.mapper.StudyMapper;
import com.example.bagStrap.model.StudyComm;

@Service
public class StudyServiceImpl implements StudyService{

	@Autowired
	StudyMapper studyMapper;
	// ------------------------------- 스터디 커뮤니티 --------------------------------------
	
	//스터디 커뮤니티 사이드 
	@Override
	public HashMap<String, Object> selectStuComm(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		
		try {
			List<StudyComm> boardTypelist = studyMapper.selectStuComm(map);
			List<StudyComm> boardList = studyMapper.selectStuCommList(map);
			resultMap.put("result", true);
			resultMap.put("message", "성공~");
			resultMap.put("boardTypelist", boardTypelist);
			resultMap.put("boardList", boardList);
			
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		
		return resultMap;
	}

	// 스터디 커뮤니티 컨텐츠 부문
	@Override
	public HashMap<String, Object> selectStuCommListBoard(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			List<StudyComm> commlist = studyMapper.selectStuCommListBoard(map);
			int countCommList = studyMapper.countCommList(map);
			resultMap.put("result", true);
			resultMap.put("message", "성공~");
			resultMap.put("commlist", commlist);
			resultMap.put("cnt", countCommList);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	// 스터디 커뮤니티 나의 댓글,게시글 목록 및 카운트
	public HashMap<String, Object> myCnt(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			int countMyCommList = studyMapper.countMyCommList(map);
			int countMycommentList = studyMapper.countMycommentList(map);
			List<StudyComm> selectMyComm = studyMapper.selectMyComm(map);
			List<StudyComm> selectMyComment = studyMapper.selectMyComment(map);
			List<StudyComm> selectStuGroupMyPage = studyMapper.selectStuGroupMyPage(map);
			resultMap.put("countMyCommCnt", countMyCommList);
			resultMap.put("countMycommentCnt", countMycommentList);
			resultMap.put("selectMyCommList", selectMyComm);
			resultMap.put("selectMyCommentList", selectMyComment);
			resultMap.put("selectStuGroupList", selectStuGroupMyPage);
			resultMap.put("result", true);
			resultMap.put("message", "성공~");
		
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	//스터디 커뮤니티 상세 글
	@Override
	public HashMap<String, Object> selectCommView(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			studyMapper.updateCommViews(map);
			StudyComm selectCommView = studyMapper.selectCommView(map);
			List<StudyComm> selectViewComment = studyMapper.selectViewComment(map);
			resultMap.put("result", true);
			resultMap.put("message", "성공~");
			resultMap.put("viewList", selectCommView);
			resultMap.put("viewComment", selectViewComment);
		
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	//스터디 사이드바 cnt
	@Transactional
	@Override
	public HashMap<String, Object> sidebarCnt(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			StudyComm list = studyMapper.selectStuSidebar(map);
			int countMyCommList = studyMapper.countMyCommList(map);
			int countMycommentList = studyMapper.countMycommentList(map);
			int countMyStudy = studyMapper.countMyStudy(map);
			resultMap.put("countMyStudyCnt", countMyStudy);
			resultMap.put("countMyCommCnt", countMyCommList);
			resultMap.put("countMycommentCnt", countMycommentList);
			resultMap.put("sidebarSession", list);
			resultMap.put("result", true);
			resultMap.put("message", "성공~");
		
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	
	//스터디 커뮤니티 상세 글 - 댓글작성
	@Override
	public HashMap<String, Object> insertViewComment(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			studyMapper.insertViewComment(map);
			resultMap.put("idx",map.get("COMMENT_ID"));
			resultMap.put("result", true);
			resultMap.put("message", "댓글 작성 완료");
			System.out.println(resultMap);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	//스터디 커뮤니티 게시글 작성하기 카테고리  
	@Override
	public HashMap<String, Object> selectMyCommCategory(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			List<StudyComm> selectMyCommCategory = studyMapper.selectMyCommCategory(map);
			resultMap.put("categoryList", selectMyCommCategory);
			resultMap.put("result", true);
			resultMap.put("message", "댓글 작성 완료");
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	// 스터디 커뮤니티 게시글 작성
	@Override
	public HashMap<String, Object> insertComm(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			studyMapper.insertComm(map);
			resultMap.put("idx",map.get("board_Id"));
			resultMap.put("result", true);
			resultMap.put("message", "게시글 작성 완료");
			System.out.println(resultMap);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	// 스터디 커뮤니티 게시글 이미지 첨부
	@Override
	public HashMap<String, Object> addBoardFile(HashMap<String, Object> map) {
		studyMapper.insertBoardFile(map);
		return null;
	}
	// 스터디 커뮤니티 게시글 삭제 
	@Override
	public HashMap<String, Object> deleteBoard(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		 
		try {
			studyMapper.deleteBoard(map);
			resultMap.put("result", true);
			resultMap.put("message", "게시글 삭제 완료");
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	//스터디 커뮤니티 게시글 숨기기 및 해제 
	@Override
	public HashMap<String, Object> updateStatusBoard(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		 
		try {
			studyMapper.updateStatusBoard(map);
			resultMap.put("resultHide",map.get("BOARD_STATUS"));
			resultMap.put("result", true);
			resultMap.put("message", "ㅋㅋㅋ");
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	// 스터디 커뮤니티 업데이트
	@Override
	public HashMap<String, Object> updateComm(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			studyMapper.updateComm(map);
			resultMap.put("idx",map.get("board_Id"));
			resultMap.put("result", true);
			resultMap.put("message", "게시글 업데이트 완료");
			System.out.println(resultMap);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	// 스터디 커뮤티 게시글 댓글 숨기기
	@Override
	public HashMap<String, Object> updateStatusBoardComment(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			studyMapper.updateStatusBoardComment(map);
			 
			resultMap.put("commentStatus",map.get("COMMENTSTATUS"));
			resultMap.put("result", true);
			resultMap.put("message", "게시글 업데이트 완료");
			System.out.println(resultMap);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	// 스터디 커뮤니티 게시글 댓글 삭제
	@Override
	public HashMap<String, Object> deleteBoardComment(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			studyMapper.deleteBoardComment(map);
			resultMap.put("result", true);
			resultMap.put("message", "댓글 삭제 완료");
			System.out.println(resultMap);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	// 스터디 커뮤티 게시글 좋아요
	@Override
	public HashMap<String, Object> insertCommLike(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			studyMapper.insertCommLike(map);
			 
			resultMap.put("result", true);
			resultMap.put("message", "좋아요!");
			System.out.println(resultMap);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	// 스터디 커뮤니티 게시글 댓글 좋아요
	@Override
	public HashMap<String, Object> insertCommentLike(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			studyMapper.insertCommentLike(map);
			resultMap.put("result", true);
			resultMap.put("message", "좋아요!");
			System.out.println(resultMap);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	//스터디 커뮤니티 상세보기 좋아요 중복체크 
	@Override
	public HashMap<String, Object> selectLikeCheck(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			StudyComm selectLikeCheck = studyMapper.selectLikeCheck(map);
			resultMap.put("selectLikeCheck",selectLikeCheck);
			resultMap.put("result", true);
			resultMap.put("message", "전송완료");
			System.out.println(resultMap);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	// 스터디 커뮤니티 상세보기 좋아요 삭제
	@Override
	public HashMap<String, Object> deleteCommentLike(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			studyMapper.deleteCommentLike(map);
			resultMap.put("result", true);
			resultMap.put("message", "전송완료");
			System.out.println(resultMap);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	// 스터디 커뮤니티 좋아요수 갱신 
	@Override
	public HashMap<String, Object> selectgetLikeCount(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			StudyComm selectgetLikeCount = studyMapper.selectgetLikeCount(map);
			resultMap.put("result", true);
			resultMap.put("message", "조회완료");
			resultMap.put("likeCnt", selectgetLikeCount);
			System.out.println(resultMap);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	// 스터디 커뮤니티  댓글 수정모드
	@Override
	public HashMap<String, Object> updateComment(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			System.out.println("이거보면돼 --> " + map);

			studyMapper.updateComment(map);
			resultMap.put("result", true);
			resultMap.put("message", "조회완료");
			System.out.println(resultMap);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	// 스터디 커뮤니티  답글 수정모드 세트 바로위에거랑 같이 동작하는거임 일부러 같이 안넣음 
	@Override
	public HashMap<String, Object> updateCommentNO(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			studyMapper.updateCommentNO(map);
			resultMap.put("result", true);
			resultMap.put("message", "조회완료");
			System.out.println(resultMap);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	// 스터디 커뮤니티 수정완료처리
	@Override
	public HashMap<String, Object> updateCommentResult(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			studyMapper.updateCommentResult(map);
			resultMap.put("result", true);
			resultMap.put("message", "성고옹~");
			resultMap.put("idx",map.get("COMMENT_ID"));
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	// 스터디 커뮤니티 답글 세트
	@Override
	public HashMap<String, Object> updateCommentRENO(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			studyMapper.updateCommentRENO(map);
			resultMap.put("result", true);
			resultMap.put("message", "성고옹~");
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	// 스터디 커뮤니티 답글 모드
	@Override
	public HashMap<String, Object> updateCommentREY(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			studyMapper.updateCommentREY(map);
			resultMap.put("result", true);
			resultMap.put("message", "성고옹~");
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;

	}
	//스터디 커뮤니티 답글 마무뤼
	@Override
	public HashMap<String, Object> updateCommentReResult(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		 
		try {
			studyMapper.updateCommentReResult(map);
			resultMap.put("result", true);
			resultMap.put("message", "답글 완");
			resultMap.put("idx",map.get("COMMENT_ID"));
			System.out.println(resultMap);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	// ------------------------------- 스터디 그룹 --------------------------------------
	//스터디 그룹 리스트(책 불러오기)
	@Override
	public HashMap<String, Object> selectStuGroupInsertBoardType(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		 
		try {
			List<StudyComm> selectStuGroupInsertBoardType = studyMapper.selectStuGroupInsertBoardType(map);
			resultMap.put("result", true);
			resultMap.put("message", "완료");
			resultMap.put("typeList",selectStuGroupInsertBoardType);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	//스터디 그룹 만들기(책 불러오기)
	@Override
	public HashMap<String, Object> insertStuGroup(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		 
		try {
			studyMapper.insertStuGroup(map);
			resultMap.put("idx",map.get("STUDY_GROUP_ID"));
			resultMap.put("result", true);
			resultMap.put("message", "그룹 개설 완료");
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	//스터디 그룹 리스트 
	@Override
	public HashMap<String, Object> selectStuGroupListSidebar(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		 
		try {
			int cntlist= studyMapper.selectStuGroupListSidebarCnt(map);
			List<StudyComm> list = studyMapper.selectStuGroupListSidebar(map);
			resultMap.put("result", true);
			resultMap.put("message", "조회완료");
			resultMap.put("groupListCnt", cntlist);
			resultMap.put("groupList", list);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
		
	}
	//스터디 그룹 상세정보
	@Override
	public HashMap<String, Object> selectStuGroupDetail(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		 
		try {
			StudyComm list = studyMapper.selectStuGroupDetail(map);
			resultMap.put("result", true);
			resultMap.put("message", "조회완료");
			resultMap.put("detailList", list);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	//스터디 신청하기 
	@Override
	public HashMap<String, Object> insertStuGroupApply(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		System.out.println("신청목록 확인 ===> " + map);
		try {
			studyMapper.insertStuGroupApply(map);
			resultMap.put("result", true);
			resultMap.put("message", "신청완료 방장의 승인 후 가입되십니다.");
			System.out.println("신청결과확인 ====>" +  resultMap);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	//스터디 중복신청
	@Override
	public HashMap<String, Object> selectStuGroupSubscription(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		System.out.println("스터디 중복신청 확인 ====>" + map);
		try {
			StudyComm list = studyMapper.selectStuGroupSubscription(map);
			resultMap.put("result", true);
			resultMap.put("message", "확인 완료");
			resultMap.put("Subscription", list);
			System.out.println("결과확인 ===>" + resultMap.get("Subscription"));
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	//스터디 방장 자동가입
	@Override
	public HashMap<String, Object> insertStuGroupKingApply(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			studyMapper.insertStuGroupKingApply(map);
			resultMap.put("result", true);
			resultMap.put("message", "방장 자동가입");
			
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
}
	//스터디 사람검색
	@Override
	public HashMap<String, Object> selectStuGroupUserSearch(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			StudyComm adminlist = studyMapper.selectStuGroupUserSearch(map);
			StudyComm selectStuGroupUserApplSearch = studyMapper.selectStuGroupUserApplSearch(map);
			List<StudyComm> selectStuGroupSubscriptionSearch = studyMapper.selectStuGroupSubscriptionSearch(map);
			List<StudyComm> selectStuGroupSubscriptionSearchN = studyMapper.selectStuGroupSubscriptionSearchN(map);
			List<StudyComm> selectStuGroupSubscriptionSearchL = studyMapper.selectStuGroupSubscriptionSearchL(map);
			int selectStuGroupSubscriptionSearchCnt = studyMapper.selectStuGroupSubscriptionSearchCnt(map);
			resultMap.put("adminlist", adminlist);
			resultMap.put("searchUserlist", selectStuGroupUserApplSearch);
			resultMap.put("searchjoinGroup", selectStuGroupSubscriptionSearch);
			resultMap.put("searchnotjoinGroup", selectStuGroupSubscriptionSearchN);
			resultMap.put("searchnotLeaveGroup", selectStuGroupSubscriptionSearchL);
			resultMap.put("applyY", selectStuGroupSubscriptionSearchCnt);
			resultMap.put("result", true);
			resultMap.put("message", "디테일 정보 검색");
			
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	//마이페이지 -> 스터디그룹 수정
	@Override
	public HashMap<String, Object> updateStuGroup(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		 
		try {
			studyMapper.updateStuGroup(map);
			resultMap.put("idx",map.get("studyGroupId"));
			resultMap.put("result", true);
			resultMap.put("message", "그룹 수정 완료");
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	//마이페이지 -> 스터디 강퇴
	@Override
	public HashMap<String, Object> updateStuGroupLeave(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		 
		try {
			studyMapper.updateStuGroupLeave(map);
			resultMap.put("result", true);
			resultMap.put("message", "유저 강퇴 완료");
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	
	//마이페이지 -> 스터디 강퇴 모드
	@Override
	public HashMap<String, Object> updateStuGroupLeaveMode(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		 
		try {
			studyMapper.updateStuGroupLeaveModeNo(map);
			studyMapper.updateStuGroupLeaveMode(map);
			resultMap.put("result", true);
			resultMap.put("message", "유저 강퇴 사유 입력");
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	//마이페이지 -> 스터디 차단 풀기
	@Override
	public HashMap<String, Object> deleteStuGroupUnblocking(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		 
		try {
			studyMapper.deleteStuGroupUnblocking(map);
			resultMap.put("result", true);
			resultMap.put("message", "유저 강퇴 사유 입력");
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	//마이페이지 -> 스터디 그룹장 위임
	@Override
	public HashMap<String, Object> updateStuGroupBossDelegation(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		 
		try {
			studyMapper.updateStuGroupBossDelegation(map);
			resultMap.put("result", true);
			resultMap.put("message", "그룹장 위임 완료");
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	//마이페이지 -> 스터디 가입 승인
	@Override
	public HashMap<String, Object> updateStuGroupJoin(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		 
		try {
			studyMapper.updateStuGroupJoin(map);
			resultMap.put("result", true);
			resultMap.put("message", "그룹 승인 완료");
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	//마이페이지 -> 스터디그룹 해체 
	@Override
	public HashMap<String, Object> deleteStuGroup(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		 
		try {
			studyMapper.deleteStuGroup(map);
			studyMapper.deleteStuGroup2(map);
			resultMap.put("result", true);
			resultMap.put("message", "그룹 삭제 완료");
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "에러가 발생했습니다. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	//스터디긔룹  채팅같은 게시글 쓰기 
	@Override
	public HashMap<String, Object> insertStuGroupMessage(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		 
		try {
			studyMapper.insertStuGroupMessage(map);
			resultMap.put("idx",map.get("MESSAGEID"));
			resultMap.put("result", true);
			resultMap.put("message", "채팅작성완룡");
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "채팅 인서트 에러. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	//스터디 채팅 불러오기 
	@Override
	public HashMap<String, Object> selectStuGroupMessage(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		 
		try {
			List<StudyComm> list = studyMapper.selectStuGroupMessage(map);
			resultMap.put("messagelist", list);
			resultMap.put("result", true);
			resultMap.put("message", "불러오기완료");
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "채팅불러오기에러. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	//스터디 채팅삭제 
	@Override
	public HashMap<String, Object> deletGroupMessage(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		 
		try {
			studyMapper.deletGroupMessage(map);
			resultMap.put("result", true);
			resultMap.put("message", "채팅삭제");
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "채팅 인서트 에러. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	//마이페이지 내 스터디 숨기기
	@Override
	public HashMap<String, Object> updateStuGroupHide(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		 
		try {
			studyMapper.updateStuGroupHide(map);
			resultMap.put("result", true);
			resultMap.put("message", "처리완료");
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "채팅 인서트 에러. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	//스터디 나의 학습목표 수정하기
	@Override
	public HashMap<String, Object> updateStuGoal(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		 
		try {
			studyMapper.updateStuGoal(map);
			resultMap.put("result", true);
			resultMap.put("message", "수정완료");
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "채팅 인서트 에러. 에러 코드를 확인해주세요");
		}
		return resultMap;
	}
	//노트필기 경쟁대회 수상 
	@Override
	public HashMap<String, Object> selectEvent3001(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			 
			List<StudyComm> list = studyMapper.selectEvent3001(map);
			List<StudyComm> list2 = studyMapper.selectEvent3002(map);
			resultMap.put("event3001", list);
			resultMap.put("event3002", list2);
			resultMap.put("result", true);
			resultMap.put("message", "수상목록 확인");
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "수상 에러");
		}
		return resultMap;
	}
	//유저목록 페이징
	@Override
	public HashMap<String, Object> selectStuGroupSubscriptionSearchPage(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		try {
			System.out.println(map);
			List<StudyComm> list = studyMapper.selectStuGroupSubscriptionSearchPage(map);
			int list2 = studyMapper.selectStuGroupSubscriptionSearchCnt(map);
			resultMap.put("userList", list);
			resultMap.put("applyY", list2);
			resultMap.put("result", true);
			resultMap.put("message", "유저목록 페이징처리");
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "페이징실패");
		}
		return resultMap;
	}
	// 책5 조회
	@Override
	public HashMap<String, Object> selectTop5(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap();
		System.out.println("이거보면돼" + map);
		try {		 
			List<StudyComm> list2 = studyMapper.selectTop5(map);
			resultMap.put("selectTop5", list2);
			resultMap.put("result", true);
			resultMap.put("message", "책5");
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			resultMap.put("result", false);
			resultMap.put("message", "책 가져오기 에러 ");
		}
		return resultMap;
	}
}
