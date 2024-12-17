<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<script src='./dist/index.global.js'></script>
<script>
// .then(result => result.json())  ===== .then(function(result){return result.json()})
  document.addEventListener('DOMContentLoaded', function() {
	  let eventData = '';
	  console.log('1', eventData);
	  // eventData에 저장하기 (fullData.do)
	  fetch('fullData.do')
	  .then(result => result.json()) 
	  .then(result => {
		 eventData = result;
		 console.log('3', eventData);

	  
	  console.log('2', eventData);
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
      headerToolbar: {
        left: 'prev,next today', // ,는 붙여서, 공백은 띄워서 (html 화면에서)
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay'
      },
      initialDate: '2024-12-12',
      navLinks: true, // can click day/week names to navigate views
      selectable: true,
      selectMirror: true,
      select: function(arg) {
        var title = prompt('이벤트를 등록하세요');
    	  if (title) {
        	console.log(arg); // arg 확인
        	// AJAX 호출 
    	 	fetch ('addEvent.do?a=' + title + '&b=' + arg.startStr + '&c=' + arg.endStr)
    	 	.then(result => result.json())
    	 	.then(result => {
    	 		if(result.retCode == 'OK') {
         			 calendar.addEvent({ // 이벤트 등록
          			 title: title,
          			 start: arg.start,
          			 end: arg.end,
          			 allDay: arg.allDay
         			 }) // 이벤트 객체     	 		
    	 		} // end of retCode == 'OK'
    	 		
    	 	})
    	 	.catch(err => console.log(err));
        } // 화면에 등록된 값 출력 (end of if)
        calendar.unselect()
      },
      eventClick: function(arg) {
    	console.log(arg);
    	var deleteD = confirm('일정을 삭제하시겠습니까?');
        if (deleteD) {
        	fetch('removeData.do?a=' + arg.title + '&b=' + arg.startStr + '&c=' + arg.endStr)
        	.then(result => result.json())
        	.then(result => {
        		console.log(result);
        		if(result.retCode == 'OK'){
         		 arg.event.remove() // 화면에서만 삭제         			
        		}
        	})
        	.catch(err => console.log(err));
        }
      },
      editable: true,
      dayMaxEvents: true, // allow "more" link when too many events
      events: eventData // [{}, {}, {}]
     
    });

    calendar.render();
    console.log('4', eventData);
  })

  .catch(err => console.log(err));
  });
</script>
<style>
body {
	margin: 40px 10px;
	padding: 0;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 1100px;
	margin: 0 auto;
}
</style>
</head>
<body>

	<div id='calendar'></div>

</body>
</html>
