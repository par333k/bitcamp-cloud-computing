"use strict"

var data = null;
var {no, page, size} = $.parseQuery(location.href);

if (no == undefined) { // 입력 폼
    $('.viewform').css('display', 'none');
    $(aNo).removeAttr("readonly");
    
} else { // 상세 보기 폼
    $('.newform').css('display', 'none');

    $.getJSON(serverApiAddr + `/json/assignment/view/${no}`, 
        function(result) {
	        data = result;
	        if (data.assignment == null) {
	            alert('명함이 없습니다.');
	            location.href = "list.html";
	            return;
	        }
	        $(aNo).val(data.assignment.no);
	        $(aName).val(data.assignment.name);
	        $(aEmail).val(data.assignment.email);
	        $(aPhone).val(data.assignment.phone);
	        $(aFaxno).val(data.assignment.fax);
	        $(aMemo).val(data.assignment.memo);
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
    $.post(serverApiAddr + '/json/assignment/update', 
        {
            no: $(aNo).val(), 
            name: $(aName).val(), 
            email: $(aEmail).val(),
            phone: $(aPhone).val(),
            fax: $(aFaxno).val(),
            memo: $(aMemo).val()
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
    $.getJSON(serverApiAddr + `/json/assignment/delete?no=${aNo.value}`, 
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
    $.post(serverApiAddr + '/json/assignment/add', 
        { 
        name: $(aName).val(), 
        email: $(aEmail).val(),
        phone: $(aPhone).val(),
        fax: $(aFaxno).val(),
        memo: $(aMemo).val()
        },
        function(data) {
            location.href = 'list.html';
        },
        'json');
});
    