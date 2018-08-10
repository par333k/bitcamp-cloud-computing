package bitcamp.as.controller.json;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.as.domain.Assignment;
import bitcamp.as.service.AssignmentService;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {

    @Autowired AssignmentService assignmentService;
    
    @RequestMapping("list")
    public Object list(
            @RequestParam(defaultValue="1") int page,
            @RequestParam(defaultValue="3") int size
            ) throws Exception {
        if (page < 1) page = 1;
        if (size < 1 || size > 20) size = 3;
        
        List<Assignment> list = assignmentService.list(page, size);
        
        HashMap<String, Object> data = new HashMap<>();
        data.put("list", list);
        data.put("page", page);
        data.put("size", size);
        data.put("totalPage", assignmentService.getTotalPage(size));

        return data;
    }
    
    @GetMapping("form")
    public void form() {
        
    }
    
    @PostMapping("add")
    public Object add(Assignment assignment) throws Exception{
        HashMap<String, Object> result = new HashMap<>();
        assignmentService.add(assignment);
        result.put("status", "success");
        return result;
    }
    
    @RequestMapping("delete")
    public Object delete(int no) throws Exception{
        HashMap<String, Object> result = new HashMap<>();
        if (assignmentService.delete(no) == 0) {
            result.put("status", "fail");
            result.put("error", "해당 게시글이 없습니다.");
        }else {
            result.put("status","success");
        }
        return result;
    }
    
    @RequestMapping("update")
    public Object update(Assignment assignment) throws Exception{
       HashMap<String, Object> result = new HashMap<>();
        if(assignmentService.update(assignment) == 0) {
            result.put("status", "fail");
            result.put("error", "해당 아이디가 없습니다.");
          }else {
            result.put("status","success");
          }
        return result;
    }
    
    @RequestMapping("view/{no}")
    public Object view(@PathVariable int no) throws Exception{
        HashMap<String, Object> data = new HashMap<>();
        data.put("assignment", assignmentService.view(no));
        return data;
    }
}
