package bitcamp.pms.controller.json;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.pms.dao.ClassroomDao;
import bitcamp.pms.domain.Classroom;
import bitcamp.pms.service.ClassroomService;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {
    @Autowired ClassroomService classroomService;
    
    @RequestMapping("list")
    public Object list() throws Exception {
        List<Classroom> list = classroomService.list();
        
        HashMap<String, Object> data = new HashMap<>();
        data.put("list", list);
        return data;
    }

    @GetMapping("form")
    public void form() {

    }

    @PostMapping("add")
    public Object add(Classroom classroom) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        classroomService.add(classroom);
        result.put("status", "success");
        return result;
    }

    @RequestMapping("delete")
    public Object delete(int no) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        if(classroomService.delete(no) == 0) {
            result.put("status", "fail");
            result.put("error", "해당 수업이 없습니다.");
        }else {
            result.put("status", "success");
        }
        return result;
    }

    @RequestMapping("update")
    public Object update(Classroom classroom) throws Exception{
        HashMap<String, Object> result = new HashMap<>();
        if(classroomService.update(classroom) == 0) {
            result.put("status", "fail");
            result.put("error", "해당 수업이 없습니다.");
        }else {
            result.put("status", "success");
        }
        return result;
       
    }
    
    @RequestMapping("view/{no}")
    public Object view(
            @PathVariable int no) throws Exception {
        HashMap<String, Object> data = new HashMap<>();
        data.put("classroom", classroomService.view(no));
        return data;
    }
    
}
