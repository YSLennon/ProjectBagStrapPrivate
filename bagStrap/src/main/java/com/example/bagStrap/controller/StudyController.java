package com.example.bagStrap.controller;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.bagStrap.dao.StudyService;
import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class StudyController {

	@Autowired
	StudyService studyService; 
	@Autowired
	HttpSession session;

	private String path=System.getProperty("user.dir")+"/";
	@Value("${upload.path}")
	private String uploadpath;
	@Value("${upload.url.path}")
	private String uploadUrl;

	// ---------------------------------------------------------- 스터디 커뮤니티 ---------------------------------------------------------------------	
	@RequestMapping("/defaultView") 
    public String defaultView(Model model) throws Exception{
         return "study/defaultView";
    }
	@RequestMapping("/study") 
    public String mainz(Model model) throws Exception{
         return "study/study_home";
    }
	// 스터디 커뮤니티 
	@RequestMapping("/study-comm") 
	 public String study_comm(HttpServletRequest request, Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		 request.setAttribute("boardTypeId", map.get("boardTypeId")); 
		request.setAttribute("boardTypeId2", map.get("boardTypeId2"));
		 request.setAttribute("name2", map.get("name"));
		return "study/study-comm";
	}
	// 스터디 커뮤니티 게시글 상세보기 
	@RequestMapping("/study-comm-detail") 
	 public String study_comm_default(HttpServletRequest request, Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		 request.setAttribute("boardId", map.get("boardId"));
       return "study/study-comm-detail";
	}       
	// 스터디 커뮤니티 나의 게시글, 댓글 
	@RequestMapping("/study-comm-myboard") 
    public String study_comm_myboard(HttpServletRequest request, Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		 request.setAttribute("itemMode", map.get("itemMode"));
		 request.setAttribute("author", map.get("author"));
		 request.setAttribute("userNickName", map.get("userNickName"));
		return "study/study-comm-myboard";
    }
	// 스터디 커뮤니티 게시글 작성
	@RequestMapping("/commInsert") 
    public String commInsert(Model model) throws Exception{
         return "study/study-comm-insert";
    }
	// 스터디 커뮤니티 게시글 수정 
	@RequestMapping("/study-comm-Update") 
    public String commUpdate(HttpServletRequest request, Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		 request.setAttribute("boardId", map.get("boardId"));
         return "study/study-comm-update";
    }

	// ---------------------------------------------------------- 스터디 그룹 ---------------------------------------------------------------------
	// 스터디 그룹 만들기 
	@RequestMapping("/study-group-insert") 
    public String study_group_insert(Model model) throws Exception{
         return "study/study-group-insert";
    }
	// 스터디 그룹 리스트 
	@RequestMapping("/study-group-list") 
	 public String study_group_list(HttpServletRequest request, Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		 request.setAttribute("Age", map.get("Age"));
         return "study/study-group-list";
    }
//	// 스터디 그룹 사이드바
//	@RequestMapping("/study-group-sidebar")
//    public String study_group_sidebar(Model model) throws Exception{
//         return "../layout/study-group-sidebar";
//    }
	// 스터디 그룹 상세페이지
	@RequestMapping("/study-group-detail") 
    public String studygroupdetail(HttpServletRequest request, Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		 request.setAttribute("boardNo", map.get("boardNo"));
         return "study/study-group-detail";
    }
	// 나의 마이스터디 상세 페이지 
	@RequestMapping("/study-mygroup-detail") 
    public String study_mygroup_detail(HttpServletRequest request, Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		 request.setAttribute("studyGroupId", map.get("studyGroupId"));
         return "study/study-mygroup-detail";
    }
	// 스터디 그룹 이벤트
	@RequestMapping("/study-group-event") 
    public String study_group_event(Model model) throws Exception{
         return "study/study-group-event";
    }
	
	
	
	@RequestMapping(value = "/study.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String study(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		System.out.println(map);
		HashMap<String, Object> resultMap = new HashMap();
		return new Gson().toJson(resultMap);
	}
	
	//스터디 커뮤니티 사이드바 카테고리 타입 (사이드바)
	@RequestMapping(value = "/selectStuCommType.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String selectStuCommType(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap();
		System.out.println(map);
		resultMap = studyService.selectStuComm(map);
		return new Gson().toJson(resultMap);
	}
	
	//스터디 커뮤니티 리스트
	@RequestMapping(value = "/selectStuCommListBoard.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String selectStuCommListBoard(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap();
		System.out.println(map);
		resultMap = studyService.selectStuCommListBoard(map);
		return new Gson().toJson(resultMap);
	}
	//스터디 사이드바 나의 게시글, 댓글 목록 개수 (사이드바)
	@RequestMapping(value = "/sidebarCnt.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String sidebarCnt(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap();
		System.out.println(map);
		resultMap = studyService.sidebarCnt(map);
		return new Gson().toJson(resultMap);
		}
	//스터디 커뮤니티 디테일 나의 게시글, 댓글 목록 개수
	@RequestMapping(value = "/myCnt.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String myCnt(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap();
		System.out.println(map);
		resultMap = studyService.myCnt(map);
		return new Gson().toJson(resultMap);
		}
	//스터디 커뮤니티 상세 글 
	@RequestMapping(value = "/selectCommView.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String selectCommView(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap();
		System.out.println(map);
		resultMap = studyService.selectCommView(map);
		return new Gson().toJson(resultMap);
	}
	//스터디 커뮤니티 상세 글 - 댓글작성
		@RequestMapping(value = "/insertViewComment.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String insertViewComment(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			System.out.println(map);
			resultMap = studyService.insertViewComment(map);
			return new Gson().toJson(resultMap);
		}
	//스터디 커뮤니티 게시글 작성 하기 - 카테고리 불러오기 
	@RequestMapping(value = "/selectMyCommCategory.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String selectMyCommCategory(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap();
		System.out.println(map);
		resultMap = studyService.selectMyCommCategory(map);
		return new Gson().toJson(resultMap);
	}
	//스터디 커뮤니티 게시글 작성 하기 
	@RequestMapping(value = "/insertComm.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String insertComm(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap();
		System.out.println(map);
		resultMap = studyService.insertComm(map);

		return new Gson().toJson(resultMap);
	}
	
	//스터디 커뮤니티 게시글 숨기기 
	@RequestMapping(value = "/updateStatusBoard.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String updateStatusBoard(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap();
		resultMap = studyService.updateStatusBoard(map);

		return new Gson().toJson(resultMap);
	}

	//스터디 게시글 작성하기 이미지 첨부
	 @RequestMapping("/fileUpload.dox")
	 @ResponseBody
	    public HashMap<String, Object> result(@RequestParam("file1") MultipartFile multi, @RequestParam("idx") int idx, HttpServletRequest request,HttpServletResponse response, Model model)
	    {
	        HashMap<String, Object> resultMap = new HashMap<>();

			try {
	            String originFilename = multi.getOriginalFilename();
	            String extName = originFilename.substring(originFilename.lastIndexOf("."));
	            long size = multi.getSize();
	            String saveFileName = genSaveFileName(extName);

	            if(!multi.isEmpty()){
					File file = new File(path + uploadpath, saveFileName);
					System.out.println("filePath: " + file.getAbsolutePath());
	                multi.transferTo(file);
	                
	                HashMap<String, Object> map = new HashMap<String, Object>();
	                map.put("fileName", saveFileName);
	                map.put("filePath", uploadUrl+saveFileName);
	                map.put("idx", idx);
	                map.put("fileOrgName", originFilename);
	                map.put("fileSize", size);
	                map.put("fileExt", extName);
	                // insert 쿼리 실행         
	                studyService.addBoardFile(map);
	                
	                model.addAttribute("filename", multi.getOriginalFilename());
	                model.addAttribute("uploadPath", file.getAbsolutePath());

					resultMap.put("result", true);
					return resultMap;
	            }
	        }catch(Exception e) {
	            e.printStackTrace();
	        }
			resultMap.put("result", false);

	        return resultMap;
	    }
	    
	    // 현재 시간을 기준으로 파일 이름 생성
	    private String genSaveFileName(String extName) {
	        String fileName = "";
	        
	        Calendar calendar = Calendar.getInstance();
	        fileName += calendar.get(Calendar.YEAR);
	        fileName += calendar.get(Calendar.MONTH);
	        fileName += calendar.get(Calendar.DATE);
	        fileName += calendar.get(Calendar.HOUR);
	        fileName += calendar.get(Calendar.MINUTE);
	        fileName += calendar.get(Calendar.SECOND);
	        fileName += calendar.get(Calendar.MILLISECOND);
	        fileName += extName;
	        
	        return fileName;
	    }
	  //스터디 커뮤니티 게시글 삭제 하기 
		@RequestMapping(value = "/deleteBoard.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String deleteBoard(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.deleteBoard(map);

			return new Gson().toJson(resultMap);
		}
		//스터디 커뮤니티 게시글 업데이트
		@RequestMapping(value = "/updateComm.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String updateComm(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.updateComm(map);
			return new Gson().toJson(resultMap);
		}
		// 스터디 커뮤티 게시글 댓글 숨기기
		@RequestMapping(value = "/updateStatusBoardComment.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String updateStatusBoardComment(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.updateStatusBoardComment(map);

			return new Gson().toJson(resultMap);
		}
		// 스터디 커뮤니티 게시글 댓글 삭제
		@RequestMapping(value = "/deleteBoardComment.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String deleteBoardComment(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.deleteBoardComment(map);
			return new Gson().toJson(resultMap);
		}
		// 스터디 커뮤티 게시글 좋아요
		@RequestMapping(value = "/insertCommLike.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String insertCommLike(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.insertCommLike(map);

			return new Gson().toJson(resultMap);
		}
		// 스터디 커뮤니티 게시글 댓글 좋아요
		@RequestMapping(value = "/insertCommentLike.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String insertCommentLike(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.insertCommentLike(map);
			return new Gson().toJson(resultMap);
		}
		// 스터디 커뮤니티 게시글 댓글 좋아요 체크
		@RequestMapping(value = "/selectLikeCheck.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String selectLikeCheck(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.selectLikeCheck(map);
			return new Gson().toJson(resultMap);
		}
		// 스터디 커뮤니티 상세보기 좋아요 삭제
		@RequestMapping(value = "/deleteCommentLike.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String deleteCommentLike(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.deleteCommentLike(map);
			return new Gson().toJson(resultMap);
		}
		// 스터디 커뮤니티 좋아요수 갱신 
		@RequestMapping(value = "/selectgetLikeCount.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String selectgetLikeCount(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.selectgetLikeCount(map);
			return new Gson().toJson(resultMap);
		}
		// 스터디 커뮤니티  댓글 수정모드
		@RequestMapping(value = "/updateComment.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String updateComment(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.updateComment(map);
			return new Gson().toJson(resultMap);
		}
		// 스터디 커뮤니티  댓글 수정모드 N 
		@RequestMapping(value = "/updateCommentNO.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String updateCommentNO(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.updateCommentNO(map);
			return new Gson().toJson(resultMap);
		}
		// 스터디 커뮤니티  댓글 수정완료처리
		@RequestMapping(value = "/updateCommentResult.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String updateCommentResult(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.updateCommentResult(map);
			return new Gson().toJson(resultMap);
		}
		// 스터디 커뮤니티  답글 세트
		@RequestMapping(value = "/updateCommentRENO.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String updateCommentRENO(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.updateCommentRENO(map);
			return new Gson().toJson(resultMap);
		}
		// 스터디 커뮤니티 답글 모드
		@RequestMapping(value = "/updateCommentREY.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String updateCommentREY(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.updateCommentREY(map);
			return new Gson().toJson(resultMap);
		}
		// 스터디 커뮤니티 답글 수정완료처리
		@RequestMapping(value = "/updateCommentReResult.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String updateCommentReResult(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.updateCommentReResult(map);
			return new Gson().toJson(resultMap);
		}
// ---------------------------------------------------------- 스터디 그룹 ---------------------------------------------------------------------
		//스터디 그룹 만들기 ( 과목 불러오기)
		@RequestMapping(value = "/selectStuGroupInsertBoardType.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String selectStuGroupInsertBoardType(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.selectStuGroupInsertBoardType(map);
			return new Gson().toJson(resultMap);
		}
		//스터디 그룹 만들기
		@RequestMapping(value = "/insertStuGroup.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String insertStuGroup(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.insertStuGroup(map);
			return new Gson().toJson(resultMap);
		}
		//스터디 그룹 리스트 사이드바 
		@RequestMapping(value = "/selectStuGroupListSidebar.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String selectStuGroupListSidebar(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.selectStuGroupListSidebar(map);
			return new Gson().toJson(resultMap);
		}
		//스터디 그룹 리스트 사이드바 
		@RequestMapping(value = "/selectStuGroupDetail.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String selectStuGroupDetail(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.selectStuGroupDetail(map);
			return new Gson().toJson(resultMap);
		}
		//스터디 신청하기
		@RequestMapping(value = "/insertStuGroupApply.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String insertStuGroupApply(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.insertStuGroupApply(map);
			return new Gson().toJson(resultMap);
		}
		//스터디 중복신청
		@RequestMapping(value = "/selectStuGroupSubscription.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String selectStuGroupSubscription(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.selectStuGroupSubscription(map);
			return new Gson().toJson(resultMap);
		}
		//스터디 방장 자동가입
		@RequestMapping(value = "/insertStuGroupKingApply.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String insertStuGroupKingApply(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.insertStuGroupKingApply(map);
			return new Gson().toJson(resultMap);
		}
		//스터디 사람검색
		@RequestMapping(value = "/selectStuGroupUserSearch.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String selectStuGroupUserSearch(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.selectStuGroupUserSearch(map);
			return new Gson().toJson(resultMap);
		}
		//마이페이지 -> 스터디그룹 수정
		@RequestMapping(value = "/updateStuGroup.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String updateStuGroup(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.updateStuGroup(map);
			return new Gson().toJson(resultMap);
		}
		//마이페이지 -> 스터디 강퇴
		@RequestMapping(value = "/updateStuGroupLeave.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String updateStuGroupLeave(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.updateStuGroupLeave(map);
			return new Gson().toJson(resultMap);
		}
		//마이페이지 -> 스터디 강퇴 모드
		@RequestMapping(value = "/updateStuGroupLeaveMode.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String updateStuGroupLeaveMode(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.updateStuGroupLeaveMode(map);
			return new Gson().toJson(resultMap);
		}
		//마이페이지 -> 스터디 차단 풀기
		@RequestMapping(value = "/deleteStuGroupUnblocking.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String deleteStuGroupUnblocking(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.deleteStuGroupUnblocking(map);
			return new Gson().toJson(resultMap);
		}
		//마이페이지 -> 스터디 그룹장 위임
		@RequestMapping(value = "/updateStuGroupBossDelegation.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String updateStuGroupBossDelegation(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.updateStuGroupBossDelegation(map);
			return new Gson().toJson(resultMap);
		}
		//마이페이지 -> 스터디 가입 승인 
		@RequestMapping(value = "/updateStuGroupJoin.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String updateStuGroupJoin(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.updateStuGroupJoin(map);
			return new Gson().toJson(resultMap);
		}
		//마이페이지 -> 스터디 그룹 삭제  
		@RequestMapping(value = "/deleteStuGroup.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String deleteStuGroup(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.deleteStuGroup(map);
			return new Gson().toJson(resultMap);
		}
		//스터디긔룹  채팅같은 게시글 쓰기  
		@RequestMapping(value = "/insertStuGroupMessage.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String insertStuGroupMessage(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.insertStuGroupMessage(map);
			return new Gson().toJson(resultMap);
		}
		//스터디 채팅 불러오기 
		@RequestMapping(value = "/selectStuGroupMessage.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String selectStuGroupMessage(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.selectStuGroupMessage(map);
			return new Gson().toJson(resultMap);
		}
		//스터디 채팅 삭제
		@RequestMapping(value = "/deletGroupMessage.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String deletGroupMessage(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.deletGroupMessage(map);
			return new Gson().toJson(resultMap);
		}
		//마이페이지 내 스터디 숨기기
		@RequestMapping(value = "/updateStuGroupHide.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String updateStuGroupHide(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.updateStuGroupHide(map);
			return new Gson().toJson(resultMap);
		}
		//스터디 나의 학습목표 수정하기
		@RequestMapping(value = "/updateStuGoal.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String updateStuGoal(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.updateStuGoal(map);
			return new Gson().toJson(resultMap);
		}
		//노트필기 경쟁대회 수상 
		@RequestMapping(value = "/selectEvent3001.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String selectEvent3001(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.selectEvent3001(map);
			return new Gson().toJson(resultMap);
		}
		//유저목록 페이징 
		@RequestMapping(value = "/selectStuGroupSubscriptionSearchPage.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String selectStuGroupSubscriptionSearchPage(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.selectStuGroupSubscriptionSearchPage(map);
			return new Gson().toJson(resultMap);
		}
		//책5
		@RequestMapping(value = "/selectTop5.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String selectTop5(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
			HashMap<String, Object> resultMap = new HashMap();
			resultMap = studyService.selectTop5(map);
			return new Gson().toJson(resultMap);
		}

}
