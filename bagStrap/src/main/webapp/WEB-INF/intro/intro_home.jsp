<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/layout/sharedHeader.jsp"></jsp:include>
    <title>첫번째 페이지</title>
</head>
<style>
  
	* {
	    margin: 0;
	    padding: 0;
	    box-sizing: border-box;
	}

	body {
	    font-family: 'Noto Sans KR', sans-serif;
	    line-height: 1.6;
	    color: #333;
	    background-color: white; /* 화이트 테마 배경색 */
	    background-image: url('/src/인트로.jpg'); /* 배경 이미지 경로 */
	    background-size: cover;
	    background-repeat: no-repeat;
	    background-attachment: fixed;
	}

	/* 버튼 스타일 */
	.btn {
	    display: inline-block;
	    padding: 10px 20px;
	    background-color: #e74c3c;
	    color: #fff;
	    text-decoration: none;
	    border-radius: 5px;
	    transition: background-color 0.3s ease;
	}
	.header{
		height:150px;
	}

	.btn:hover {
	    background-color: #c0392b;
	}

	/* 히어로 섹션 */
	.hero {
	    position: relative;
	    background-color: rgba(255, 255, 255, 0.9); /* 약간 투명한 흰색 배경 */
	    height: 100vh;
	    display: flex;
	    align-items: center;
	    justify-content: center;
	    text-align: center;
	    padding: 0 20px;
		margin-top:-90px;
	}

	.hero-content h1 {
	    font-size: 3em;
	    margin-bottom: 20px;
	    color: #333;
	}

	.hero-content p {
	    font-size: 1.5em;
	    margin-bottom: 30px;
	    color: #555;
	}

	/* 소개 섹션 */
	.about {
		padding-top : 160px;
	    text-align: center;
	    background-color: rgba(255, 255, 255, 0.75);
		height:200px;
	}

	.about h2 {
	    font-size: 2.5em;
	    margin-bottom: 20px;
	    color: #333;
	}

	.about p {
	    max-width: 800px;
	    margin: 0 auto;
	    font-size: 1.5em;
	    color: #555;
	}

	/* 서비스 섹션 */
	.services {
	    padding: 0px 20px;
	    text-align: center;
		background-color: rgba(255, 255, 255, 0.75);
		height:40%;
	}

	.services h2 {
	    font-size: 2.5em;
	    margin-bottom: 20px;
	    color: #333;
	}

	.services-container {
	    display: flex;
	    flex-wrap: wrap;
	    justify-content: center;
	    gap: 20px;
	}

	.service-item {
	    background-color: #fff;
	    border: 1px solid #ddd;
	    border-radius: 10px;
	    width: 300px;
	    padding: 20px;
	    transition: transform 0.3s ease, box-shadow 0.3s ease;
	}

	.service-item:hover {
	    transform: translateY(-10px);
	    box-shadow: 0 4px 8px rgba(0,0,0,0.1);
	}

	.service-item img {
	    width: 100%;
	    border-radius: 10px;
	    margin-bottom: 15px;
	}

	.service-item h3 {
	    margin-bottom: 10px;
	    font-size: 1.5em;
	    color: #e74c3c;
	}

	.service-item p {
	    font-size: 1em;
	    color: #555;
	}

	/* 갤러리 섹션 */
	.gallery {
	    padding: 60px 20px;
	    text-align: center;
	    background-color: rgba(255, 255, 255, 0.75);
		height:10%;
	}

	.gallery h2 {
	    font-size: 2.5em;
	    margin-bottom: 40px;
	    color: #333;
	}

	.gallery-container {
	    display: flex;
	    flex-wrap: wrap;
	    justify-content: center;
	    gap: 15px;
	}

	.gallery-container img {
	    width: 100px;
	    height: 100px;
	    object-fit: cover;
	    border-radius: 10px;
	    transition: transform 0.3s ease, box-shadow 0.3s ease;
	}

	.gallery-container img:hover {
	    transform: scale(1.05);
	    box-shadow: 0 4px 8px rgba(0,0,0,0.2);
	}

	/* 연락처 섹션 */
	.contact {
	    padding: 60px 20px;
	    text-align: center;
	}

	.contact h2 {
	    font-size: 2.5em;
	    margin-bottom: 40px;
	    color: #333;
	}

	.contact form {
	    max-width: 600px;
	    margin: 0 auto;
	    text-align: left;
	}

	.contact label {
	    display: block;
	    margin-bottom: 5px;
	    font-weight: bold;
	    color: #333;
	}

	.contact input,
	.contact textarea {
	    width: 100%;
	    padding: 10px;
	    margin-bottom: 20px;
	    border: 1px solid #ddd;
	    border-radius: 5px;
	    font-size: 1em;
	}

	.contact button {
	    width: 100%;
	    padding: 15px;
	    background-color: #e74c3c;
	    color: #fff;
	    border: none;
	    border-radius: 5px;
	    font-size: 1.1em;
	    cursor: pointer;
	    transition: background-color 0.3s ease;
	}

	.contact button:hover {
	    background-color: #c0392b;
	}

	/* 푸터 섹션 */
	footer {
	    background-color: #fff;
	    color: #333;
	    padding: 20px;
	    text-align: center;
	    box-shadow: 0 -2px 4px rgba(0,0,0,0.1);
	}

	footer p {
	    margin-bottom: 10px;
	}

	footer .social-media a {
	    margin: 0 10px;
	    display: inline-block;
	}

	footer .social-media img {
	    width: 24px;
	    height: 24px;
	    transition: transform 0.3s ease;
	}

	footer .social-media a:hover img {
	    transform: scale(1.1);
	}
	.split-container {
	    position: relative;
	    width: 100%;
	    height: 20vh;
	    display: flex;
	}

	.split {
	    position: relative;
	    flex: 1;
	    overflow: hidden;
	    transition: flex 0.5s ease;
	}

	.split.left {
	    background-size: cover;
	}

	.split.right {

	    background-size: cover;
	}

	.split h2 {
	    position: absolute;
	    top: 50%;
	    left: 50%;
	    transform: translate(-50%, -50%);
	    color: #000000;
	    font-size: 3em;
	    text-shadow: 2px 2px 4px rgba(0,0,0,0.7);
	    opacity: 0;
	    transition: opacity 0.5s ease;
	}

	.split-link {
	    position: absolute;
	    top: 0;
	    left: 0;
	    width: 100%;
	    height: 100%;
	    text-decoration: none;
	}

	.split:hover {
	    flex: 1.5;
	}

	.split:hover h2 {
	    opacity: 1;
	}

	.split-container::before {
	    content: '';
	    position: absolute;
	    top: 0;
	    bottom: 0;
	    left: calc(50% - 1px);
	    width: 2px;
	    background: rgba(255, 255, 255, 0.7);
	    z-index: 2;
	}
</style>
<body>
		
    <div id="app">
			    <!-- 히어로 섹션 -->
			    <section class="hero">
			        <div class="hero-content">
			            <h1>환영합니다!</h1>
			            <p>현이의 가방끈은 엄선된 책과 열정적인 스터디를 제공합니다.</p>
			            <a href="#about" class="btn" style="background-color: rgba(255, 255, 255, 0.9); color: #333;" >자세히 보기</a>
			        </div>
			    </section>

			    <!-- 소개 섹션 -->
			    <section id="about" class="about">
			    </section>

			    <!-- 서비스 섹션 -->
			    <section id="services" class="services">
			        <h2>신간 도서</h2>
			        <div class="services-container">
			            <div class="service-item" v-for="item in introBook">
			                <img :src=item.image alt="서비스 1" @click="fnView(item.bookId)"> 
			            </div>
			        </div>
			    </section>

				<!-- 갤러리 섹션 -->
				<section id="gallery" class="gallery">
				    <div class="split-container">
				        <div class="split left">
				            <h2>북스토어</h2>
				            <a href="/shop/list" class="split-link"></a>
				        </div>
				        <div class="split right">
				            <h2>스터디그룹</h2>
				            <a href="/study-group-list" class="split-link"></a>
				        </div>
				    </div>
				</section>

			    <!-- 푸터 섹션 -->
			    <footer>
			    </footer>
			</body>
        </main>
    </div>
    <jsp:include page="/layout/footer.jsp"></jsp:include>


	</body>
	</html>
	<script>
	    const app = Vue.createApp({
	        data() {
	            return {
					isLogin : false,
	              sessionUserId : '',
				  introBook : []
				};
	        },
	        methods: {
				fnView(bookId) {
					$.pageChange("/bagStrap/shop/detail", { bookId: bookId });
				},
				fnIntroList(){
	                var self = this;
	                var nparmap = {};
	                $.ajax({
	                    url:"bagStrap/selectIntroBook.dox",
	                    dataType:"json",
	                    type : "POST",
	                    data : nparmap,
	                    success : function(data) {
	                      
							self.introBook = data.introBook;
	                    }
	                });
	            },
	            fnGetList(){
	                var self = this;
	                var nparmap = {};
	                $.ajax({
	                    url:"bagStrap/intro.dox",
	                    dataType:"json",
	                    type : "POST",
	                    data : nparmap,
	                    success : function(data) {
	                       
	                    }
	                });
	            },
				fnSession(){
	                var self = this;
	                var nparmap = {};
	                $.ajax({
	                    url:"bagStrap/sharedHeader.dox",
	                    dataType:"json",    
	                    type : "POST", 
	                    data : nparmap,
	                    success : function(data) {
	                       
	                        self.isLogin = data.isLogin; 
	                        if(data.isLogin){
	                            self.sessionUserId = data.userId;
	                            self.sessionUserNickName = data.userNickName;
	                            self.isAdmin = data.isAdmin;
	                           
	                        } else {
	                            self.sessionUserId = '';
	                            self.sessionUserNickName = '';    
	                            self.isAdmin = '';            
	                        }
	                    }
	                });
	            },
	            fnShop(){
	                location.href="/bagStrap/shop";
	            },
	            fnStudy(){
	                location.href="/bagStrap/study";
	            }
	        },
	        mounted() {
	            var self = this;
				self.fnSession();
				self.fnGetList();
				self.fnIntroList();
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
		       }
		   });
	    app.mount('#app');
	</script>
	  