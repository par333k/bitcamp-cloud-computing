package bitcamp.pms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.domain.Board;

public class BoardViewController implements PageController {
    BoardDao boardDao;

    public BoardViewController(BoardDao boardDao) {
        super();
        this.boardDao = boardDao;
    }

    public String service(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int no = Integer.parseInt(request.getParameter("no"));
        response.setContentType("text/html;charset=UTF-8");

        Board board = boardDao.selectOne(no);
        request.setAttribute("board", board);

        return "/board/view.jsp";

    }
}
