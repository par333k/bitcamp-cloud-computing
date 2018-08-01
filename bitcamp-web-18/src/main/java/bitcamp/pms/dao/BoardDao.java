package bitcamp.pms.dao;

import java.util.List;
import java.util.Map;

import bitcamp.pms.domain.Board;

public interface BoardDao {
    List<Board> selectList(Map<String, Object> params);
    Board selectOne(int no);
    int update(Board board);
    int insert(Board board);
    int delete(int no);
    int countAll();
}
