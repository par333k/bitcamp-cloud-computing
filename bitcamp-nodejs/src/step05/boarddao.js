// 주제: DAO 모듈 만들기

var pool;

exports.setConnectionPool = (connectionPool) => {
	pool = connectionPool;
};

exports.list = (pageNo = 1, pageSize = 3, handler) => {
	 var startIndex = (pageNo - 1) * pageSize;
	    pool.query('select bno, titl, cdt from pms2_board limit ?, ?',
	        [startIndex, pageSize],
	        function(err, results) {
	      handler(err, results);
	    });
};

exports.add = (data, handler) =>{
	 pool.query('INSERT INTO pms2_board(titl,cont,cdt) VALUES (?,?,now())',
	        	[data.title, data.content],
	            function(err, result) {
		 handler(err, result);
	        });
};

exports.update = (data, handler) =>{
	pool.query('update pms2_board set titl=?, cont=?, cdt=now() where bno=?', 
    		[data.title,
    			data.content, data.no],
    	     function(err, result) {
    	        handler(err, result);	   
    });	
};

exports.remove = (data, handler) =>{
	 pool.query('delete from pms2_board where bno=?', 
	     		[data.no],
	     	     function(err, result) {
	     	  handler(err, result);
	     });
};

exports.selectOne = (data, handler) =>{
	 pool.query('select bno, titl, cont, cdt from pms2_board where bno=?', 
	     		[data.no],
	     	     function(err, results) {
	     	  handler(err, results);
	     });
};