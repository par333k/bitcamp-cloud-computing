package bitcamp.as.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.as.dao.AssignmentDao;
import bitcamp.as.domain.Assignment;


@Service
public class AssignmentService {

    @Autowired AssignmentDao assignmentDao;
    
    public List<Assignment> list(int page, int size) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("startIndex", (page - 1) * size);
        params.put("pageSize", size);
      
        return assignmentDao.selectList(params);
    }

    public void add(Assignment board) {
        assignmentDao.insert(board);
    }
    

    public int delete(int no) {
        return assignmentDao.delete(no);  
    }
    

    public int update(Assignment board) {
        int count = assignmentDao.update(board);
        return count;
    }
    

    public Assignment view(int no){
      return assignmentDao.selectOne(no);
    }
    
    public int getTotalPage(int size) {
        int count = assignmentDao.countAll();
        int totalPage = count / size;
        if (count % size > 0)
            totalPage++;
        return totalPage;
    }
    
}
