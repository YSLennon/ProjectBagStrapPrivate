package com.example.bagStrap.model;

import lombok.Data;

@Data
//TBL_STU_COMM
public class StudyComm {
	private String boardId;
	private String boardType;
	private String title;
	private String content;
	private String author;
	private String createdDate;
	private String updateDate;
	private int views;
	private int likes;
	private String createdDateFormatted;
	private int cnt;
	private int cnt2;
	private int cnt3;
	
//TBL_STU_COMMENTS
	private String commentId;
	private String postId;
	private String parentCommentId;
	private String comcontents;
	private String comCreateDay;
	private String comUpdateDay;
//
//TBL_STU_COMM_BOARD_TYPES
	private int boardTypeId;
	private String name;
	
//USERS
	private String userId;
	private String userName;
	private String userNickName;
	private String password;
	private String email;
	private String addr;
	private String ban;
	private String status;
	private String phoneNum;
	private String cDatetime;
	private String uDatetime;

	
	public String getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public String getPassword() {
		return password;
	}
	public String getAddr() {
		return addr;
	}
	public String getBan() {
		return ban;
	}
	public String getStatus() {
		return status;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public String getcDatetime() {
		return cDatetime;
	}
	public String getuDatetime() {
		return uDatetime;
	}
	
}
	

