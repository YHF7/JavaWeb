package com.netshop.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.netshop.dao.impl.UserDao;
import com.netshop.entity.User;

public class UserServlet extends HttpServlet{


    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String act = request.getParameter("action");
        UserDao userDao = new UserDao();
        if(act.equals("login"))
        {
            String userName = request.getParameter("userName");
            String userPwd = request.getParameter("userPwd");

            User user = userDao.login(userName, userPwd);
            session.setAttribute("user",user);
              request.getRequestDispatcher("GoodstypeServlet?action=listAll").forward(request,response);

        }
        else if(act.equals("logout"))
        {
            if(session.getAttribute("user") != null)
            {
                session.removeAttribute("user");
                request.getRequestDispatcher("GoodstypeServlet?action=listAll").forward(request, response);
            }
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
}

