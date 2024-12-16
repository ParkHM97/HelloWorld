/**
 * js/board.js
 * 사용페이지 : board.jsp
 */
console.log('start');

// 페이지 정보 지정
let page = 1;
// 댓글 정보 -> row 생성 
function makeRow(reply = {}){ // {} > 객체 
	let html = `<li data-rno="${reply.replyNo}">
				  <span class="col-sm-2">${reply.replyNo}</span>
				  <span class="col-sm-5">${reply.reply}</span>
				  <span class="col-sm-2">${reply.replyer}</span>
				  <span class="col-sm-2"><button class="btn btn-danger" onclick="deleteReply(${reply.replyNo})">삭제</button></span>
				</li>`;
	let target = document.querySelector('div.reply ul.list');
	target.insertAdjacentHTML('beforeend', html);	// target 태그의 제일 마지막 위치에 놓임 <tag><li/><li/>...</tag> 
} // end of makeRow


// 댓글 번호 기준 > 삭제되면 > retCode(OK 또는 Fail)
function deleteReply(rno = 1) {

	fetch('removeReply.do?rno=' + rno)
		.then(result => result.json())
		.then(result => {
			console.log(result);
			if (result.retCode == 'OK') {
				alert("삭제 완료");
				document.querySelector('li[data-rno="' + rno + '"]').remove();
			} else {
				alert("삭제 실패");
			}
		})
		.catch(err => console.log(err))
}

// 댓글 목록 5건씩 출력
function showReplyList(){
	fetch('replyList.do?bno=' + bno + '&page=' + page) // 각 페이지에 맞는 댓글을 불러오게 
				.then(result => result.json())
				.then(result => {
					document.querySelector('ul.list').innerHTML = ''; // 기존목록 clear
					console.log(result);
					for (let reply of result) {
						makeRow(reply); // 댓글정보 > list를 생성
					}
					// 페이지 생성
					createPageList();
				})
				.catch(err => console.log(err));
} 

// 글번호 파라미터로 전달하면 전체 건수를 활용해서 페이지 계산하는 함수 
function createPageList(){
	fetch('getCount.do?bno=' + bno)
	.then(result => result.json())
	.then(result => {
		let totalCnt = result.replyCount; // 댓글 전체 건수 75건 (15 페이지)
		// 이전, 이후 페이지 여부, 첫번째 ~ 마지막 페이지 
		let prev, next; // 이전, 이후
		let startPage, endPage, realEnd;
		endPage = Math.ceil(page / 10) * 10; // 현재 페이지 기준으로 마지막 페이지 계산
		startPage = endPage - 9;
		if(startPage > 1){
			prev = true; 
		}
		realEnd = Math.ceil(totalCnt / 5);
		if(endPage > realEnd) { // 현재 페이지 13 
			endPage = realEnd;
		}
		if (endPage < realEnd){ // 이후 목록 있는지 
			next = true;
		}
		// 목록 작성
		let pagination = document.querySelector('ul.pagination');
		pagination.innerHTML = '';
		// 이전 
		if(prev){
			let html = `<li class="page-item" data-page="${startPage - 1}">
			      		 <a class="page-link" href="#" aria-label="Previous">
			        	  <span aria-hidden="true">&laquo;</span>
			             </a>
			            </li>`;
			pagination.insertAdjacentHTML('beforeend', html);
		}
		// 목록 건수 (반복문)
		for(let p = startPage; p <= endPage; p++){
			let html = `<li class="page-item" data-page="${p}"><a class="page-link" href="#">${p}</a></li>`;			
			pagination.insertAdjacentHTML('beforeend', html);
		}	
		//이후 
		if(next){
			let html = `<li class="page-item" data-page="${endPage + 1}">
			              <a class="page-link" href="#" aria-label="Next">
			               <span aria-hidden="true">&raquo;</span>
			              </a>
			            </li>`;
			pagination.insertAdjacentHTML('beforeend', html);
		}	
		// 페이징 a 태그 클릭
		document.querySelectorAll('ul.pagination a').forEach(item => { // item => a 태그를 가리킴
			console.log(item);
			item.addEventListener('click', function(e){//클릭이벤트가 발생했을 때 실행할 이벤트 핸들러 e
				e.preventDefault(); // 기본 기능 차단 후 아래를 실행하겠습니다
				page = item.parentElement.getAttribute('data-page');
				console.log(item.parentElement.getAttribute('data-page'))
				showReplyList();
			})
		})
	})
	.catch(err => console.log(err));
} // end of createPageList().



// 댓글목록
fetch('replyList.do?bno=' + bno + '&page=' + page) // 각 페이지에 맞는 댓글을 불러오게 
	.then(result => result.json())
	.then(result => {
		console.log(result);
		for (let reply of result) {
			makeRow(reply); // 댓글정보 > list를 생성
		}
	})
	.catch(err => console.log(err));
	
	
	
	
// 댓글등록 이벤트 
document.querySelector("#addBtn").addEventListener('click', function(e) {
	// 로그인 정보, 원본글 정보, 댓글 내용 board에 선언한 변수(logId, bno/reply는 여기서)
	let reply = document.querySelector('#reply').value;
	// 필수항목 확인
	if (!logId || !reply) {
		alert("필수입력값을 확인하세요")
		return; // 함수 종료
	}
	fetch('addReply.do?bno=' + bno + '&replyer=' + logId + '&reply=' + reply)
		.then(result => result.json())
		.then(result => {
			console.log(result); // 등록되면 화면에 나오게(결과확인) retCode:OK
			let reply = result.retVal;
			if(result.retCode == 'OK'){
				alert("등록성공");
				makeRow(reply);
						// 초기화
						document.querySelector('#reply').value = '';
			} else {
				alert("등록실패");				
			}
		})
		.catch(err => console.log(err));
})

showReplyList();
	
	//fetch('addReply.do?bno=' + bno + '&replyer=' + logId + '&reply=' + reply)
	//.then(result => result.json())
	//	.then(result => {
	//		console.log(result);
	//	if(result.retCode == 'OK'){
	//		
	//	} else {
	//		
	//	}
	//})	
	//.catch(err => console.log(err));
	
	