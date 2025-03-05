<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<jsp:include page="/layout/sharedHeader.jsp"></jsp:include>
	<title>첫번째 페이지</title>
</head>
<style>

	.header {
		    display: flex;
		    width: 100%;
		    height: 0%; /* 헤더 높이 설정 */
		    background-color: white; /* 헤더 배경색 */
		    color: black;
		    align-items: center;
		    padding: 0 20px;
		    box-shadow: 0 2px 4px rgba(0,0,0,0.1);
		    position: sticky;
		    top: 0;
		    z-index: 1000;
		}
		.study-group-list-content {
			width: 80%;
			margin: 40px auto;
			background: #ffffff;
			border-radius: 15px;
			padding: 30px;
			box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.1);
		}

		.study-group-list-search-bar {
			display: flex;
			justify-content: space-between;
			align-items: center;
			margin-bottom: 30px;
			gap: 15px;
		}

		.study-group-list-search-bar input[type="text"] {
			flex: 1;
			padding: 12px 16px;
			border: 1px solid #ddd;
			border-radius: 10px;
			font-size: 16px;
			transition: border 0.3s;
		}

		.study-group-list-search-bar input[type="text"]:focus {
			border-color: #007bff;
			outline: none;
		}

		.study-group-list-search-bar button {
			background:#343A40;
	       color: #fff;
	       border: none;
	       cursor: pointer;
	       transition: background-color 0.3s;
	       font-size: 1em; /* 글자 크기 조정 */
		}


		.study-group-list-grid {
			display: grid;
			grid-template-columns: repeat(auto-fill, minmax(320px, 1fr));
			gap: 30px;
		}

		.study-group-list-item {
			background: #f9f9f9;
			border-radius: 12px;
			box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.1);
			transition: transform 0.3s ease, box-shadow 0.3s ease;
		}

		.study-group-list-item:hover {
			transform: translateY(-10px);
			box-shadow: 0px 12px 24px rgba(0, 0, 0, 0.2);
		}

		.study-group-list-title {
			font-size: 20px;
			font-weight: bold;
			margin: 20px 0;
			padding: 0 20px;
			text-align: center;
			color: #333;
		}

		.study-group-list-details {
			font-size: 16px;
			color: #555;
			padding: 0 20px 20px;
			text-align: center;
			line-height: 1.6;
		}

		.study-group-list-details a {
			color: red;
			font-weight: bold;
		}

		/* Pagination 스타일 */
		   .stu-comm-list-pagination {
		       display: flex;
		       justify-content: center;
		       align-items: center;
		       margin: 30px 0;
		       gap: 10px;
			color: #000000;
		   }

		   .stu-comm-list-pagination button {
		       background-color: #ffffff;
		       border: 1px solid #dee2e6;
		   	 color: #000000;
		       padding: 10px 15px;
		       cursor: pointer;
		       transition: background-color 0.3s, color 0.3s;
		       border-radius: 4px;
		       font-size: 1em; /* 글자 크기 조정 */
		   }

		   .stu-comm-list-pagination button:hover {
		       background-color: #E0E0E0;
		       color: #ffffff;
		   }

		   .stu-comm-list-pagination button.active {
		       background-color: #000000;
		       color: #ffffff;
		       cursor: default;
		   }

		   .stu-comm-list-pagination button:disabled {
		       background-color: #e9ecef;
		       color: #6c757d;
		       cursor: not-allowed;
		       border: 1px solid #dee2e6;
		   }	

		.study-group-list-grid {
		    display: grid;
		    grid-template-columns: repeat(auto-fill, minmax(320px, 1fr));
		    gap: 30px;
		}

		.study-group-list-item {
		    background: #ffffff;
		    border-radius: 15px;
		    overflow: hidden;
		    box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.1);
		    transition: transform 0.3s ease, box-shadow 0.3s ease;
		    cursor: pointer;
		    display: flex;
		    flex-direction: column;
		    height: 100%;
		}

		.study-group-list-item:hover {
		    transform: translateY(-10px);
		    box-shadow: 0px 12px 24px rgba(0, 0, 0, 0.2);
		}

		.study-group-card {
		    display: flex;
		    flex-direction: column;
		    height: 100%;
		}

		.study-group-image-wrapper {
		    width: 100%;
			height:240px;
		    overflow: hidden;
		    position: relative;
		}

		.study-group-list-image {
		    width: 100%;
		    height: 100%;
		    object-fit: cover;
		    transition: transform 0.3s ease;
		}

		.study-group-list-image:hover {
		    transform: scale(1.05);
		}

		.study-group-content {
		    padding: 20px;
		    display: flex;
		    flex-direction: column;
		    flex-grow: 1;
		    justify-content: space-between;
		}

		.study-group-title {
		    font-size: 1.1em; /* 기존 글씨 크기 유지 */
		    font-weight: bold;
		    margin-bottom: 10px;
		    color: #333;
		    display: flex;
		    align-items: center;
		    gap: 5px;
		}

		/* 새로운 클래스 추가 */
		.enhanced-title {
		    color: #ffffff; /* 텍스트 색상 흰색으로 변경 */
		    background: rgba(0, 0, 0, 0.6); /* 반투명 검정 배경 */
		    padding: 8px 12px;
		    border-radius: 8px;
		    position: absolute; /* 이미지 위에 겹치도록 위치 설정 */
		    top: 10px; /* 이미지 하단에서 약간 위 */
		    left: 10px;
		    text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.7); /* 텍스트 그림자 추가 */
		    font-size: 1.1em; /* 글씨 크기 동일 유지 */
		}

		/* 이미지 래퍼에 상대 위치 지정 */
		.study-group-image-wrapper {
		    position: relative;
		    width: 100%;
		    height: 240px;
		    overflow: hidden;
		}
		.study-group-details {
		    font-size: 1em;
		    color: #555;
		    margin-bottom: 10px;
		    display: flex;
		    align-items: center;
		    gap: 10px;
		}

		.study-group-details span {
		    display: inline-flex;
		    align-items: center;
		    gap: 5px;
		}

		.study-group-schedule {
		    font-size: 0.9em;
		    color: #777;
		    margin-top: auto;
		}

		.no-results {
		    font-size: 1.2em;
		    color: #555;
		    text-align: center;
		    padding: 40px;
		}
	</style>
<body>
    <main class="main-container">
        <aside class="sidebar">
            <jsp:include page="/layout/study-group-sidebar.jsp"></jsp:include>
        </aside>
        
		<div id="app" class="content">
			<div class="study-group-list-search-bar">
				<input type="text" placeholder="검색어를 입력하세요" v-model="search" @keyup.enter="fnGetList()">
				<button @click="fnGetList()">검색</button>
				<button @click="fnFullView()">전체보기</button>
				<button @click="fnStudyCreate()">스터디 등록</button>
			</div>
			<div class="study-group-list-container">
			    <div class="study-group-list-grid">
			        <div class="study-group-list-item" v-for="item in groupList">
			            <template v-if="item">
			                <div class="study-group-card" @click="fnDetail(item.studyGroupId)">
			                    <div class="study-group-image-wrapper">
									<h3 class="study-group-title enhanced-title">
									    {{item.name}}
									</h3>
			                        <template v-if="item.filePath">
			                            <img :src="item.filePath" alt="Study Group Image" class="study-group-list-image">
			                        </template>
			                        <template v-else>
			                            <img src="${uploadUrlPath}profile.png" alt="Default Image" class="study-group-list-image">
			                        </template>
			                    </div>
			                    <div class="study-group-content">
			                        <h3 class="study-group-title">
			                            {{item.studyName}}
			                        </h3>
			                        <p class="study-group-details">
			                            👫 {{item.genderGroup}} | 🧒 {{item.age}} | {{item.onOffMode}} |
			                            <span v-if="item.applyY != item.maxparticipants"> 👥 {{item.applyY}} / {{item.maxparticipants}}</span>
			                            <span v-else>❌ 참여 인원 마감</span>
			                        </p>
			                        <p class="study-group-schedule">
			                            📅 시작일 {{item.stgStartDate}} ~ | ⏰ 시간 {{item.stgStudyTime}} 
			                        </p>
			                    </div>
			                </div>
			            </template>
			            <template v-if="!item">
			                <div class="no-results">🔍 검색된 결과가 없습니다.</div>
			            </template>
			        </div>
			    </div>
			</div>
				<div class="stu-comm-list-pagination">
					<button @click="fnGetList(currentPage - 1)" :disabled="currentPage <= 1">이전</button>
					<button v-for="page in totalPages" :key="page" :class="{active: page == currentPage}" @click="fnGetList(page)">
						{{ page }}
					</button>
					<button @click="fnGetList(currentPage + 1)" :disabled="currentPage >= totalPages">다음</button>
				</div>
			</div>
		</div>
    </main>
    <jsp:include page="/layout/footer.jsp"></jsp:include>
</body>
</html>
<script>
	 const app = Vue.createApp({
	        data() {
	            return {
					isLogin: false,
					sessionUserId: '',
					sessionUserNickName: '',
					groupList: [],
					age : '${age}',
					onOffMode : '${onOffMode}',
					subjectTypeId : '${subjectTypeId}',
					genderGroup : '${genderGroup}',
					startDate : '${startDate}' || new Date().toISOString().substring(0, 10), // 기본값 오늘 날짜로 설정
					startTime : '${startTime}',
					endTime : '${endTime}',
					participants :'${participants}',
					totalPages: 5,
	                currentPage: 1,      // 현재 페이지 
	                pageSize: 9,         // 한 페이지에 보여줄 개수 
					search:"",
					contextPath:'${pageContext.request.contextPath}'
	            };
	        },
	        methods: {
				fnDetail(boardId) {
					$.pageChange("${pageContext.request.contextPath}/study-group-detail", { boardNo: boardId });
				},
				fnFullView(){
					var self = this;
					self.age = '';
					self.onOffMode ='';
					self.subjectTypeId='';
					self.genderGroup='';
					self.startDate = new Date().toISOString().substring(0, 10);
					self.startTime = '';
					self.endTime='';
					self.participants='';
					self.fnGetList();
				},
				fnStudyCreate(){
					var self = this;
					if(!self.isLogin){
						alert("로그인 먼저 하세요.");
						document.getElementById('headerLoginModal').showModal();
						document.getElementById('inputId').focus();
						return;
					}else{
					location.href="${pageContext.request.contextPath}/study-group-insert";
					}
				},
				fnGetList(page = 1){
					var self = this;
					const startIndex = (page - 1) * self.pageSize;
	                const outputNumber = self.pageSize;
	                self.currentPage = page;
					var nparmap = { age : self.age, onOffMode : self.onOffMode, 
									genderGroup : self.genderGroup,subjectTypeId : self.subjectTypeId,
									startDate : self.startDate, startTime : self.startTime, endTime : self.endTime,
									participants : self.participants,startIndex: startIndex, 
									outputNumber: outputNumber , search : self.search
					};
					$.ajax({
						url:"${pageContext.request.contextPath}/selectStuGroupListSidebar.dox",
						dataType:"json",	
						type : "POST", 
						data : nparmap,
						success : function(data) { 

							self.groupList = data.groupList;
							self.groupListCnt = data.groupListCnt;
							self.totalPages = Math.ceil(self.groupListCnt / self.pageSize);
						}
					});
		        },
				fnSession(){
					var self = this;
					var nparmap = {
					};
					$.ajax({
						url:"${pageContext.request.contextPath}/sharedHeader.dox",
						dataType:"json",	
						type : "POST", 
						data : nparmap,
						success : function(data) {
							
							self.isLogin = data.isLogin 
							if(data.isLogin){
								self.sessionUserId = data.userId;
								self.sessionUserNickName = data.userNickName;
								self.isAdmin = data.isAdmin;
							
							} else {
								self.sessionUserId = '';
								self.sessionUserNickName = '';
							}
						
						}
					});
				},
	        },
	        mounted() {
	            var self = this;
				self.fnSession();
				self.fnGetList();
				// (추가) 로그인 상태가 변경되었을 때 세션 정보 다시 로드
				        window.addEventListener('loginStatusChanged', function () {
				            self.fnSession();  // (추가) 로그인 상태가 변경되었을 때 자동으로 세션 정보 업데이트
				        });
				window.addEventListener('loginStatusChanged', function(){
					if(window.sessionStorage.getItem("isLogin") === 'true'){
						self.isLogin = true;	
					} else{
						self.isLogin = false;
					};
					self.fnSession();
				});
				window.addEventListener('sideBarEventAge', function(){
					self.age = window.sessionStorage.getItem("age");
					self.fnGetList();
				});
				window.addEventListener('sideBarEventonOff', function(){
					self.onOffMode = window.sessionStorage.getItem("onOffMode");
					self.fnGetList();
				});
				window.addEventListener('sideBarEventboardTypeId', function(){
					self.subjectTypeId = window.sessionStorage.getItem("boardTypeId");
					self.fnGetList();
				});
				window.addEventListener('sideBarEventgenderGroup', function(){
					self.genderGroup = window.sessionStorage.getItem("genderGroup");
					self.fnGetList();
				});
				window.addEventListener('sideBarEventStartDate', function(){
					self.startDate = window.sessionStorage.getItem("startDate");
					self.fnGetList();
				});
				window.addEventListener('sideBarEventStartime', function(){
					self.startTime = window.sessionStorage.getItem("startTime");
					self.endTime = window.sessionStorage.getItem("endTime");
					self.fnGetList();
				});
				window.addEventListener('sideBarEventparticipants', function(){
					self.participants = window.sessionStorage.getItem("participants");
					self.fnGetList();
				});

	        }
	    });
	    app.mount('#app');
	</script>