package com.netshop.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.netshop.dao.impl.GoodsDao;
import com.netshop.entity.Goods;

public class GoodsServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String act = request.getParameter("action");
        GoodsDao goodsDao = new GoodsDao();
        if(act.equals("list"))
        {
            int typeId = Integer.parseInt(request.getParameter("typeId"));
            out.print(typeId);
            List<Goods> list = goodsDao.getGoodsList(typeId);
            request.setAttribute("list",list);
            request.getRequestDispatcher("../listGoods.jsp").forward(request,response);
        }
        else if(act.equals("detail"))
        {
            int goodsId =Integer.parseInt(request.getParameter("goodsId"));
            Goods goods = goodsDao.getGoodsById(goodsId);
            request.setAttribute("goods",goods);
            request.getRequestDispatcher("../detailGoods.jsp").forward(request,response);
        }
        else if(act.equals("add"))
        {

        }
    }
    public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        this.doPost(request, response);
    }
}
