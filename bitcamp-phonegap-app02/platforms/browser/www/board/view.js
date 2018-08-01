"use strict"

var data = null;
var {no, page, size} = $.parseQuery(location.href);

if (no == undefined) { // 입력 폼
    $('.viewform').css('display', 'none');
    $(eNo).removeAttr("readonly");
    
} else { // 상세 보기 폼
    $('.newform').css('display', 'none');

    $.getJSON(serverApiAddr + `/json/board/view/${no}`, 
        function(result) {
	        data = result;
	        if (data.board == null) {
	            alert('게시물이 없습니다.');
	            location.href = "list.html";
	            return;
	        }
	        $(eNo).val(data.board.no);
	        $(eTitle).val(data.board.title);
	        $(eContent).val(data.board.content);
	        $(eCdt).val(data.board.createdDate);
    });
}

$(eListBtn).click(function() {
    if (page) {
        location.href = `list.html?page=${page}&size=${size}`;
    } else {
        location.href = 'list.html';
    }
});

$(eUpdateBtn).click(function() {
    $.post(serverApiAddr + '/json/board/update', 
        {
            no: $(eNo).val(), 
            title: $(eTitle).val(), 
            content: $(eContent).val(),
            createdDate: $(eCdt).val()
        },
        function(data) {
	        if (data.status == 'success') {
	            location.href = `list.html?page=${page}&size=${size}`;
	        } else {
	            alert('변경 오류입니다!');
	            console.log(data.error);
	        }
        },
        'json');
});

$(eDeleteBtn).click(function() {
    $.getJSON(serverApiAddr + `/json/board/delete?no=${eNo.value}`, 
        function(data) {
	        if (data.status == 'success') {
	            location.href = `list.html?page=${page}&size=${size}`;
	        } else {
	            alert('삭제 오류입니다!');
	            console.log(data.error);
	        }
    });
});

$(eAddBtn).click(function() {
    $.post(serverApiAddr + '/json/board/add', 
        {
         title: $(eTitle).val(), 
         content: $(eContent).val()
        },
        function(data) {
            location.href = 'list.html';
        },
        'json');
});
    