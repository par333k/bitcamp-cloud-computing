package bitcamp.pms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.domain.Board;

public class BoardAddController implements PageController {
    BoardDao boardDao;
    

    public BoardAddController(BoardDao boardDao) {
        super();
        this.boardDao = boardDao;
    }


    public String service(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getMethod().equals("GET")) {
            return "/board/form.jsp";
        }
        
        
        Board board = new Board();
        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("content"));
        board.setCreatedDate(request.getParameter("cdt"));

        boardDao.insert(board);
        return "redirect:list";

    }
}
