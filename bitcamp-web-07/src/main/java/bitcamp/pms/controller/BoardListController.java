package bitcamp.pms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.domain.Board;

public class BoardListController implements PageController {
    BoardDao boardDao;

    public BoardListController(BoardDao boardDao) {
        super();
        this.boardDao = boardDao;
    }

    public String service(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");

        List<Board> list = boardDao.selectList();
        request.setAttribute("list", list);

        return "/board/list.jsp";

    }
}
