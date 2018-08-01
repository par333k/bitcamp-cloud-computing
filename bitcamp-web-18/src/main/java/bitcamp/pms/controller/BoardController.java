package bitcamp.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.pms.domain.Board;
import bitcamp.pms.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired BoardService boardService;
    
    @RequestMapping("list")
    public String list(
            @RequestParam(defaultValue="1") int page,
            @RequestParam(defaultValue="3") int size,
            Model model) throws Exception {
        
        if (page < 1) page = 1;
        if (size < 1 || size > 20) size = 3;
        
        List<Board> list = boardService.list(page, size);
        model.addAttribute("list", list);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPage", 
                boardService.getTotalPage(size));
        return "board/list";
    }
    
    @GetMapping("form")
    public void form() {
        
    }
    
    @PostMapping("add")
    public String add(Board board) throws Exception{
        boardService.add(board);
        return "redirect:list";
    }
    
    @RequestMapping("delete")
    public String delete(int no) throws Exception{
        boardService.delete(no);
        return "redirect:list";
    }
    
    @RequestMapping("update")
    public String update(Board board) throws Exception{
        if(boardService.update(board) == 0) {
            return "/board/updatefail.jsp";
             
          }else {
            return "redirect:list";
          }
    }
    
    @RequestMapping("view/{no}")
    public String view(@PathVariable int no, Model model) throws Exception{
        Board board = boardService.view(no);
        model.addAttribute("board", board);
        return "board/view";
    }
}
