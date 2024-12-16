<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
	<div id="sidebar">
        <div class="stu_comm_profile">
            <div class="stu_comm_profile-info">
                <p><strong>{{}} 님</strong></p>
            </div>
        </div>
        <div>
            <p><strong>MyInfo</strong></p>
            <ul>
                <li><a href="javascript:;">회원정보 수정</a></li>
                <li><a href="javascript:;">내 활동내역</a></li>
            </ul>
        </div>
        <div>
            <hr>
            <p><strong>MyStudy</strong></p>
            <ul>
                <li><a href="javascript:;">마이 페이지</a></li>
                <li><a href="javascript:;">스터디 보기</a></li>
				<li><a href="javascript:;">게시글 보기</a></li>
            </ul>
        </div>
        <div>
            <hr>
            <p><strong>MyShop</strong></p>
            <ul>
                <li><a href="${pageContext.request.contextPath}/myshop/orders">내 주문내역</a></li>
                <li><a href="javascript:;">내 환불내역</a></li>
            </ul>
        </div>
        <div>
            <hr>
            <p><strong>CSCenter</strong></p>
            <ul>
                <li><a href="javascript:;">내 문의내역</a></li>
                <li><a href="javascript:;">내 환불기록</a></li>
            </ul>
        </div>
        <div>
            <hr>
            <p><strong>Admin/vif</strong></p>
            <ul>
                <li><a href="javascript:;">환불신청 관리</a></li>
                <li><a href="javascript:;">고객문의 관리</a></li>
                <li><a href="javascript:;">공지사항 관리?</a></li>
            </ul>
        </div>
    </div>

</body>
</html>
<script>
    const sidebarApp  = Vue.createApp({
        data() {
            return {
                item:{},
				boardTypelist : [],
				boardList : []
            };
        },
        methods: {
            fnboardtypeList(){
				var self = this;
				var nparmap = {
				};
				$.ajax({
					url:"${pageContext.request.contextPath}/selectStuCommType.dox",
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : function(data) {
						self.boardTypelist = data.boardTypelist; 
						self.boardList = data.boardList;
						

					}
				});
            },
			fnboardview(boardTypeId){
				$.pageChange("${pageContext.request.contextPath}/study_comm",{boardTypeId : boardTypeId});
			}
        },
        mounted() {
            var self = this;
			//self.fnboardtypeList();
        }
    });
    sidebarApp.mount('#sidebar');
</script>