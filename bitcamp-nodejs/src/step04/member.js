//주제 : /member/* 요청을 처리할 라우터 만들기

const express =require('express')

const router = express.Router();

router.use((req, res, next) => {
	console.log('member.js 실행!')
	next();
	
});


router.get('/list', (req,res) => {
	res.writeHead(200, {'Content-Type':'text/plain;charset=UTF-8'});
	res.write('회원 목록입니다.');
	res.end();
});

router.get('/view', (req,res) => {
	res.writeHead(200, {'Content-Type':'text/plain;charset=UTF-8'});
	res.write('회원 상세 정보 입니다.');
	res.end();
});
//라우터는 모듈 생략하면 안됨
module.exports = router;