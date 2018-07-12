package bitcamp.pms.controller;

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


public class BoardUpdateController implements PageController{
    BoardDao boardDao;
    
    public BoardUpdateController(BoardDao boardDao) {
        super();
        this.boardDao = boardDao;
    }

    public String service (HttpServletRequest request, HttpServletResponse response) throws Exception {

        response.setContentType("text/html;charset=UTF-8");

                Board board = new Board();
                board.setNo(Integer.parseInt(request.getParameter("no")));
                board.setTitle(request.getParameter("title"));
                board.setContent(request.getParameter("content"));
                board.setCreatedDate(request.getParameter("createdDate"));
 
                if(boardDao.update(board) == 0) {
                  return "/board/updatefail.jsp";
                   
                }else {
                  return "redirect:list";
                }


    }
 }

