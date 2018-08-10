// 주제: DAO 분리

const mysql = require('mysql');
const express = require('express');
const router = express.Router();
const classroomdao = require('./classroomdao')


var pool = mysql.createPool({
    connectionLimit: 10,
    host: '18.222.189.84', 
    // port: '3306',
    database: 'studydb',
    user: 'study',
    password: '1111'
});

classroomdao.setConnectionPool(pool);



router.get('/list', (req, res) =>{

	classroomdao.list(req.query, (err, results) => {
    	if (err) {
    		res.end('DB 조회 중 예외 발생!')
    		return;
    	}
    	
    	for (var row of results) {
    		res.write(`${row.crno}, ${row.titl}, ${row.sdt}, ${row.edt},${row.room}\n`);
    	}
    	res.end();
    	
    });
    
	
});
router.get('/add', ( req, res) =>{
	res.writeHead(200, {'Content-Type':'text/plain;charset=UTF-8'});
	classroomdao.add(req.query, (err, result) => {
		  if (err) {
          res.end('데이터 처리 중 예외 발생!');
          return;
		  }
		  res.write('등록 성공입니다.');
		  res.end();
	});
});

router.get('/update', (req, res) =>{
	res.writeHead(200, {'Content-Type':'text/plain;charset=UTF-8'});
	classroomdao.update(req.query, (err, result) => {
		if(err) {
			res.end('DB 조회 중 예외 발생!')
			return;
		}
		res.write('변경 성공입니다.');
		res.end();
	});

});
    
router.get('/delete', ( req, res) =>{
	res.writeHead(200, {'Content-Type':'text/plain;charset=UTF-8'});
	classroomdao.remove(req.query, (err, result)=>{
		if(err){
			res.end('DB 조회 중 예외 발생!')
			return;
		}
		res.write('삭제 성공!')
		res.end();
	});
});

router.get('/view', (req, res) =>{
	res.writeHead(200, {'Content-Type':'text/plain;charset=UTF-8'});
	classroomdao.selectOne(req.query, (err, results)=>{
		if (err) {
    		res.end('DB 조회 중 예외 발생!')
    		return;
    	}
    	
    	for (var row of results) {
    		res.write(`${row.crno}, ${row.titl}, ${row.sdt}, ${row.edt},${row.room} \n`);
    	}
    	res.end();
	});
});
module.exports = router;


