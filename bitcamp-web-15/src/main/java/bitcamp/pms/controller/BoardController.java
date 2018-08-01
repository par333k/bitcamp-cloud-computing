package bitcamp.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.domain.Board;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired BoardDao boardDao;
    
    @RequestMapping("list")
    public String list(Model model) throws Exception {
        List<Board> list = boardDao.selectList();
        model.addAttribute("list", list);

        return "board/list";
    }
    
    @GetMapping("form")
    public void form() {
        
    }
    
    @PostMapping("add")
    public String add(Board board) throws Exception{
        boardDao.insert(board);
        return "redirect:list";
    }
    
    @RequestMapping("delete")
    public String delete(int no) throws Exception{
        boardDao.delete(no);
        return "redirect:list";
    }
    
    @RequestMapping("update")
    public String update(Board board) throws Exception{
        if(boardDao.update(board) == 0) {
            return "/board/updatefail.jsp";
             
          }else {
            return "redirect:list";
          }
    }
    
    @RequestMapping("view/{no}")
    public String view(@PathVariable int no, Model model) throws Exception{
        Board board = boardDao.selectOne(no);
        model.addAttribute("board", board);
        return "board/view";
    }
}
