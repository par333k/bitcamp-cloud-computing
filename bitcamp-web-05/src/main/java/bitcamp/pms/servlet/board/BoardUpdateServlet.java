package bitcamp.pms.servlet.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.domain.Board;

@SuppressWarnings("serial")
@WebServlet("/board/update")
public class BoardUpdateServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        
        try {
                Board board = new Board();
                board.setNo(Integer.parseInt(request.getParameter("no")));
                board.setTitle(request.getParameter("title"));
                board.setContent(request.getParameter("content"));
                board.setCreatedDate(request.getParameter("createdDate"));
                
                BoardDao boardDao = (BoardDao) getServletContext().getAttribute("boardDao");
                
                if(boardDao.update(board) == 0) {
                    RequestDispatcher rd = request.getRequestDispatcher("/board/updatefail.jsp");
                    rd.forward(request, response);
                }else {
                    response.sendRedirect("list");
                }

        } catch (Exception e) {
          request.setAttribute("error", e);
          RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
          rd.forward(request, response);
        }

    }
 }

