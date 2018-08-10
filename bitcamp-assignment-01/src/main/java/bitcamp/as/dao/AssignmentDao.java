package bitcamp.as.dao;

import java.util.List;
import java.util.Map;

import bitcamp.as.domain.Assignment;


public interface AssignmentDao {
    List<Assignment> selectList(Map<String, Object> params);
    Assignment selectOne(int no);
    int update(Assignment assignment);
    int insert(Assignment assignment);
    int delete(int no);
    int countAll();
}
