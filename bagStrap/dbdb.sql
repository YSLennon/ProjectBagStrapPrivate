--------------------------------------------------------
--  기존 권한이 있는 DB에서 아래 명령어 실행 후 작업
--  ALTER USER ADMIN QUOTA UNLIMITED ON USERS;
--  계정의 경우 이름: ADMIN, 비밀번호: team2_!2#4
--------------------------------------------------------

--------------------------------------------------------
--  파일이 생성됨 - 월요일-10월-14-2024   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence ANSWER_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."ANSWER_SEQ"  MINVALUE 1 MAXVALUE 9999 INCREMENT BY 1 START WITH 22 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence BOARDFILE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."BOARDFILE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 623 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence COMMENT_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."COMMENT_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 200000306 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence FAQ_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."FAQ_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 13 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence INQUIRY_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."INQUIRY_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 28 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence MESSAGESEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."MESSAGESEQ"  MINVALUE 1000000000 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1000000420 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence NOTICE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."NOTICE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 56 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence REFUND_FILE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."REFUND_FILE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 800000055 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence REFUND_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."REFUND_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence REVIEW_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."REVIEW_ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SEQ_ADDRESS
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."SEQ_ADDRESS"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 7 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SEQ_BOARD_ID
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."SEQ_BOARD_ID"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 189 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SEQ_FETCHAPPLICATIONID
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."SEQ_FETCHAPPLICATIONID"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 447 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SEQ_LIKEID
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."SEQ_LIKEID"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 441 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence STUDY_GROUP_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."STUDY_GROUP_ID_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 400000220 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence USER_NO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."USER_NO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 600000019 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Table TBL_ADDRESS
--------------------------------------------------------

  CREATE TABLE "ADMIN"."TBL_ADDRESS" 
   (	"ADDRESS_NO" NUMBER GENERATED BY DEFAULT AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE , 
	"USER_ID" VARCHAR2(50 BYTE), 
	"USER_NAME" VARCHAR2(50 BYTE), 
	"PHONE" VARCHAR2(15 BYTE), 
	"ADDRESS" VARCHAR2(255 BYTE), 
	"ADDRESS_DETAIL" VARCHAR2(255 BYTE), 
