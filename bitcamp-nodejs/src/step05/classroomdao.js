// 주제: DAO 모듈 만들기

var pool;

exports.setConnectionPool = (connectionPool) => {
	pool = connectionPool;
};

exports.list = (data, handler) => {
	    pool.query('select crno,titl,sdt,edt,room from pms2_classroom',
	        function(err, results) {
	      handler(err, results);
	    });
};

exports.add = (data, handler) =>{
	 pool.query('INSERT INTO pms2_classroom(titl,sdt,edt,room) values(?,?,?,?)',
	        	[data.title, data.sdt, data.edt, data.room],
	            function(err, result) {
		 handler(err, result);
	        });
};

exports.update = (data, handler) =>{
	pool.query('update pms2_classroom set titl=?, sdt=?, edt=?, room=? where crno=?', 
    		[data.title, data.sdt, data.edt, data.room, data.no],
    	     function(err, result) {
    	        handler(err, result);	   
    });	
};

exports.remove = (data, handler) =>{
	 pool.query('delete from pms2_classroom where crno=?', 
	     		[data.no],
	     	     function(err, result) {
	     	  handler(err, result);
	     });
};

exports.selectOne = (data, handler) =>{
	 pool.query('select crno,titl,sdt,edt,room from pms2_classroom where crno=?', 
	     		[data.no],
	     	     function(err, results) {
	     	  handler(err, results);
	     });
};