<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<jsp:include page="/layout/sharedHeader.jsp"></jsp:include>
	<title>첫번째 페이지</title>
	<style>

		.ordered-list-container {
		    display: flex;
		    border-bottom: 1px solid #eee;
		    padding: 20px;
		    margin-bottom: 20px;
		}

		.left-section {
		    flex: 3;
		    padding-right: 20px;
		    border-right: 1px solid #eee; /* Border between left and right section */
		}

		.right-section {
		    flex: 1;
		    display: flex;
		    flex-direction: column;
		    justify-content: space-between;
		    padding-left: 20px;
		}

		.status {
		    font-weight: bold;
		    margin-bottom: 5px;
		}

		.arrival-time {
		    color: green;
		    margin-bottom: 10px;
		}

		.ordered-product {
		    display: flex;
		    margin-bottom: 10px;
		}

		.ordered-product-image {
			width:80px;
		    height: 100px;
		    margin-right: 20px;
		}

		.ordered-product-info {
			flex:1;
		    display: flex;
		    flex-direction: column;
		    justify-content: space-between;
		}

		.ordered-product-name {
		    font-size: 18px;
		    margin-bottom: 10px;
		}

		.ordered-product-detail-info {
		    position: relative;
		    justify-content: space-between;
		    font-size: 16px;
		}

		.relative-right{
			position: absolute;
			right:0px;
			bottom:0px
		}
		.ordered-button {
		    padding: 10px;
		    background-color: #f0f0f0;
		    border: 1px solid #ddd;
		    cursor: pointer;
		    text-align: center;
		}
	</style>
</head>
<body>
		<main class="main-container">
			
	        <aside class="sidebar">
				<jsp:include page="/layout/header_sidebar.jsp"></jsp:include>
	        </aside>
			

	        <div class="content">
				<div id="app">
<!--
					<div v-if="isLogin">
						<div v-if="isOrderExists">
							
							<div id="order-list-by-date" v-for="(items, date) in groupedByDate" :key="date">
								<span class="ordered-date">주문 번호: {{date}}</span>
								<div class="ordered-date">주문일: {{items[0].orderdateYear}}</div	>
								<div class="ordered-list-container round">
								     Left Section 
								    <div class="left-section">
										<div class="status">
											{{items[0].status}}
											<span class="arrival-time">{{items[0].arriveddateDay}} 도착</span>
										</div>
								        <div class="ordered-product" v-for="item in items">
								            <img class="ordered-product-image" :src="item.image" :alt="item.title">
											<div class="ordered-product-info">
								                <div class="ordered-product-name">{{item.title}}</div>											
								                <div class="ordered-product-detail-info">
								                    <span>{{item.price}}</span> / <span>{{item.quantity}}</span> 
													<button class="ordered-button" @click="goToReview(item)">
														 {{ item.rating === 0 ? '리뷰 작성하기' : '리뷰 수정하기' }}
													</button>
	
													<button class="ordered-button relative-right">장바구니에 추가</button>
								                </div>
								            </div>
								        </div>
								    </div>
								     Right Section 
								    <div class="right-section">
										<button class="ordered-button" @click="fnSubmitRefund(items[0].orderId, items[0].imp)">교환, 반품 신청</button>
								    </div>
									
								</div>
							</div>
						</div>
					</div>
-->
					
		        </div>
			</div>

	    </main>

		
	<jsp:include page="/layout/footer.jsp"></jsp:include>

</body>
</html>
<script>
	//localStorage.setItem('data', JSON.stringify(data));
	// JSON.parse(localStorage.getItem('data')).result
    const app = Vue.createApp({
        data() {
            return {
				//가변값 넣어라
				isLogin : false,
                isOrderExists : true,
				year: '',
				orderYear: [],
				orderList: [],
				comparedList: JSON.parse('${orderList}'),
				priceSum: '${priceSum}',
				orderId: '${orderId}',
				list : {},
				codeList : {},
				selectedCodes : [],
				currentPage: 1,
				totalPages: 1,
				pageSize: 10,
				maxPageDisplay: 10
				
            };
        },
		computed: {
		    groupedByDate() {
				var self = this;
		        return self.orderList.reduce((acc, item) => {
		            if (!acc[item.orderId]) {
		                acc[item.orderId] = [];
		            }
		            acc[item.orderId].push(item);
		            return acc;
		        }, {});
		    }
		},
        methods: {
            fnGetList(){
				var self = this;
				var nparmap = {
				};
				$.ajax({
					url:"/selectOrderComplete.dox",
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : function(data) { 
						console.log(data);
						if(data.orderList){
						self.orderList = data.orderList;
						self.orderYear = data.orderYear;
						alert(self.orderId)
						console.log(self.orderList)
							
						}

					}
				});
            }
        },
        mounted() {
            var self = this;
			self.fnGetList();
			window.addEventListener('loginStatusChanged', function(){
				if(window.sessionStorage.getItem("isLogin") === 'true'){
					self.isLogin = true;	
				} else{
					self.isLogin = false;
				};
				self.fnGetList();	
			});
			window.addEventListener('adminStatusChanged', function(){
				if(window.sessionStorage.getItem("isAdmin") === 'true'){
					self.isAdmin = true;	
				} else{
					self.isAdmin = false;
				};
				self.fnGetList();	
			})
        }
    });
    app.mount('#app');
</script>