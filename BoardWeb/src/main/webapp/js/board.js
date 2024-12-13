/**
 * js/board.js
 * 사용페이지 : board.jsp
 */
console.log('start');

// 댓글 번호 기준 > 삭제되면 > retCode(OK 또는 Fail)
function deleteReply(rno = 1) {
	console.log('aasdsaddsa ');
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


// 댓글목록
fetch('replyList.do?bno=' + bno) // 각 페이지에 맞는 댓글을 불러오게 
	.then(result => result.json())
	.then(result => {
		console.log(result);
		for (let reply of result) {
			let html = `<li data-rno="${reply.replyNo}">
						<span class="col-sm-2">${reply.replyNo}</span>
						<span class="col-sm-5">${reply.reply}</span>
						<span class="col-sm-2">${reply.replyer}</span>
						<span class="col-sm-2"><button class="btn btn-danger" onclick="deleteReply(${reply.replyNo})">삭제</button></span>
					  </li>`;
			let target = document.querySelector('div.reply ul');
			target.insertAdjacentHTML('beforeend', html);
		}
	})
	
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
				let html = `<li data-rno="${reply.replyNo}">
									<span class="col-sm-2">${reply.replyNo}</span>
									<span class="col-sm-5">${reply.reply}</span>
									<span class="col-sm-2">${reply.replyer}</span>
									<span class="col-sm-2"><button class="btn btn-danger" onclick="deleteReply(${reply.replyNo})">삭제</button></span>
								  </li>`;
						let target = document.querySelector('div.reply ul.list');
						target.insertAdjacentHTML('afterbegin', html);	
						// 초기화
						document.querySelector('reply').value = '';
			} else {
				alert("등록실패");				
			}
		})
		.catch(err => console.log(err));
})
	
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
	
	