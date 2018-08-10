//주제 : /member/* 요청을 처리할 라우터 만들기

const express =require('express')

const router = express.Router();

router.use((req, res, next) => {
	console.log('team.js 실행!')
	next();
	
});

router.get('/list', (req,res) => {
	res.writeHead(200, {'Content-Type':'text/plain;charset=UTF-8'});
	res.write('팀 목록입니다.');
	res.end();
});

router.get('/view', (req,res) => {
	res.writeHead(200, {'Content-Type':'text/plain;charset=UTF-8'});
	res.write('팀 상세 정보 입니다.');
	res.end();
});

module.exports = router;