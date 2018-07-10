package bitcamp.pms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.pms.domain.Board;

public class BoardDao {

    SqlSessionFactory sqlSessionFactory;
    
    public BoardDao(SqlSessionFactory sqlSessionFactory){
     this.sqlSessionFactory = sqlSessionFactory;
    }
    
    public int delete(int no) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            int count = sqlSession.delete("board.delete",no);
            sqlSession.commit();
            return count;
        }
    }
    
    public List<Board> selectList() throws Exception {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
         return sqlSession.selectList("board.selectList");   
        }
    }

    public int insert(Board board) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            int count = sqlSession.insert("board.insert", board);
            sqlSession.commit();
            return count;
        }
        
    }

    public int update(Board board) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            int count = sqlSession.update("board.update", board);
            sqlSession.commit();
            return count;
        }
    }

    public Board selectOne(int no) throws Exception {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            return sqlSession.selectOne("board.selectOne", no);   
           }
   
    }
}
