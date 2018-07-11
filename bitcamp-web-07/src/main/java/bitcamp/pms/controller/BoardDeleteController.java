package bitcamp.pms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.dao.BoardDao;

public class BoardDeleteController implements PageController {

    BoardDao boardDao;

    public BoardDeleteController(BoardDao boardDao) {
        super();
        this.boardDao = boardDao;
    }

    public String service(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");

        boardDao.delete(Integer.parseInt(request.getParameter("no")));
        return "redirect:list";

    }
}
