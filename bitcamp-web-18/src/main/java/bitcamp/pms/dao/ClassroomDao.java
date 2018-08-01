package bitcamp.pms.dao;

import java.util.List;

import bitcamp.pms.domain.Classroom;

public interface ClassroomDao {
    int delete(int no);
    List<Classroom> selectList();
    Classroom selectOne(int no);
    int insert(Classroom classroom);
    int update(Classroom classroom);
}
