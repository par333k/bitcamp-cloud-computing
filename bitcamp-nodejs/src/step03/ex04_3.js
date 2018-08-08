// 주제: SQL 요청 처리하기 - 회원 변경하기
// [실행 URL]
// => http://localhost:8000/member/update?email=user99@test.com&id=user100
// [출력 결과]
// 변경 성공입니다.


const http = require('http')
const url = require('url')
const mysql = require('mysql');

var pool = mysql.createPool({
    connectionLimit: 10,
    host: '18.222.189.84', 
    //port: '3306',
    database: 'studydb',
    user: 'study',
    password: '1111'
});


const server = http.createServer((req, res) => {
    var urlInfo = url.parse(req.url, true);
    
    if (urlInfo.pathname === '/favicon.ico') {
        res.end();
        return;
    }
            
    res.writeHead(200, {
        'Content-Type': 'text/plain;charset=UTF-8'
    });
    
    if (urlInfo.pathname !== '/member/update') {
        res.end('해당 URL을 지원하지 않습니다!');
        return;
    }
    
    var email = urlInfo.query.email;
    var id = urlInfo.query.id;

    pool.query('update pms2_member set email=? where mid=?', 
    		[email,id],
    	     function(err) {
    	         if (err) throw err;
    	         
    	    res.write('변경 성공입니다');
            res.end();
    });
});

server.listen(8000, () => {
    console.log('서버가 시작됨!')
})









