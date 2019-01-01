package com.netshop.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.netshop.dao.impl.GoodstypeDao;
import com.netshop.entity.Goodstype;

public class GoodstypeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String act = request.getParameter("action");	//servlet后的参数action
        GoodstypeDao goodstypeDao = new GoodstypeDao();	//后面要用到GoodstypeDao操作数据库
        if(act.equals("listAll"))		//列出所有商品类型
        {
            List<Goodstype> list = goodstypeDao.getAllGoodstype(0);	//一级商品类型的父类型编号为0
            request.setAttribute("list", list);	//将所有商品类型带到首页显示
            request.getRequestDispatcher("../index.jsp").forward(request, response);
        }
        else if(act.equals("goAdd"))	//去到添加页面前
        {
            //GoodstypeDao goodstypeDao = new GoodstypeDao();	//已在前面定义
            List<Goodstype> list = goodstypeDao.getGoodstypeList(0);			//查询所有一级类型
            request.setAttribute("list", list);
            request.getRequestDispatcher("../admin/addGoodstype.jsp").forward(request, response);
        }
        else if(act.equals("add"))
        {
            int firstType = Integer.parseInt(request.getParameter("firstType"));	//一级类型编号
            int secondType = Integer.parseInt(request.getParameter("secondType"));	//二级类型编号
            String newType = request.getParameter("newType");	//将要添加的一批新类型，去除首尾空格
            String[] typeNames = newType.split("\n");	//用换行将字符串切成字符串数组
            int parentId = 0;	//上级类型编号，第一级类型的上级编号为0
            if(firstType==0)
                parentId = 0;	//如果没有选定一级类型，说明新添加的是一级类型编号，它们的上一级的类型号应该是0
            else
            {
                if(secondType==0)
                    parentId = firstType;	//如果没有选定二级类型，说明新添加的是二级类型
                else
                    parentId = secondType;	//选了二级类型，说明新添加的是三级类型
            }
            //调用Dao类的方法，向数据库中添加
            int x = goodstypeDao.add(parentId, typeNames);	//添加新类型

            if(x == 1)
            {
                request.setAttribute("msg", "添加成功！");
                request.getRequestDispatcher("GoodstypeServlet?action=goAdd").forward(request, response);
            }
            else if(x == -1)
            {
                request.setAttribute("msg", "操作异常！");
                request.getRequestDispatcher("../admin/addGoodstype.jsp").forward(request, response);
            }
        }
        else if(act.equals("listSub"))		//列出某类型的所有子类型，返回json字符串
        {
            int parentId = Integer.parseInt(request.getParameter("parentId"));	//传递的父类型编号
            String json = goodstypeDao.getGoodstypeJsonText(parentId);	//查询子类型，返回json字符串
            out.print(json);	//输出
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

}
