package bitcamp.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.pms.dao.ClassroomDao;
import bitcamp.pms.domain.Classroom;

@Service
public class ClassroomService {

    @Autowired ClassroomDao classroomDao;
    

    public List<Classroom> list() {

        return classroomDao.selectList();
    }

  
    public void add(Classroom classroom) {
        classroomDao.insert(classroom);
       
    }

    public int delete(int no) {
        int count = classroomDao.delete(no);
        return count;
    }

    public int update(Classroom classroom) {
       int count = classroomDao.update(classroom);
       return count;
       
    }
    
    public Classroom view(int no) {
        return classroomDao.selectOne(no);
    }
}
