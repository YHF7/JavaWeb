package com.netshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ConnDB {
    private String className = "com.mysql.jdbc.Driver";
    private String connStr = "jdbc:mysql://localhost:3306/netshop?" + "useUnicode=true&characterEncoding-UTF_8";
    private String userName = "root";
    private String userPwd = "";

    private Connection conn = null;// 连接对象
    private Statement stm = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    // 建立连接，返回连接对象
    public Connection getConnection() {
        Connection conn1 = null;
        try {
            // 加载驱动类
            Class.forName(className);
            // 建立连接对象
            conn1 = DriverManager.getConnection(connStr, userName, userPwd);
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
        }
        return conn1;
    }

    // 带入非查询语句（无占位符）
    public int executeUpdate(String sql) {
        int x = 0;
        try {
            conn = this.getConnection();
            pstm = conn.prepareStatement(sql);
            x = pstm.executeUpdate();
        } catch (Exception e) {
            x = -1;
            System.err.print(e.getMessage());
        } finally {
            this.close();
        }
        return x;
    }

    // 带入非查询语句（有占位符）
    public int executeUpdate(String sql,Object[] objs) {
        int x = 0;
        try {
            conn = this.getConnection();
            pstm = conn.prepareStatement(sql);
            for(int i=0;i<objs.length;i++) {
                pstm.setObject(i+1,objs[i]);
            }
            x = pstm.executeUpdate();
        } catch (Exception e) {
            x = -1;
            System.err.print(e.getMessage());
        } finally {
            this.close();
        }
        return x;
    }

    // 带入一条批处理(有占位符)
    public int executeBatch(String sql,ArrayList<Object[]> al) {
        int x = 0;
        try {
            conn = this.getConnection();
            pstm = conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            for (int i = 0; i < al.size(); i++) {
                Object[] objs = al.get(i);
                for (int j = 0; j < objs.length; j++) {
                    pstm.setObject(j+1, objs[j]);
                }
                pstm.addBatch();
            }
            pstm.executeBatch();
            System.out.println("批处理命令执行成功");
            conn.commit();
            System.out.println("批处理命令提交成功");
            conn.setAutoCommit(true);
            x = 1;
        } catch (Exception e) {
            x = -1;
            try {
                if(conn.isClosed()) {
                    conn.rollback();
                    System.out.println("批处理失败，回滚!");
                    conn.setAutoCommit(true);
                }
            } catch (SQLException ex) {
                //TODO: handle exception
                ex.printStackTrace();
            }
        }finally {
            this.close();
        }
        return x;
    }

    // 待人查询语句（无占位符）
    public ResultSet executeQuery(String sql) {
        try {
            conn = this.getConnection();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            int x;
            if (rs != null) {
                x = 1;
            }else {
                x = 0;
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.err.print(e.getMessage());
        }
        return rs;
    }

    // 代入查询（有占位符）和参数，返回查询结果
    public ResultSet executeQuery(String sql,Object[] objs) {
        try {
            conn = this.getConnection();
            pstm = conn.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                pstm.setObject(i + 1, objs[i]);
            }
            rs = pstm.executeQuery();
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
        return rs;
    }

    // 代入查询语句（无占位符），判断是否查询
    public boolean hasRecord(String sql) {
        boolean flag = false;
        try {
            conn = this.getConnection();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            flag = rs.next();
        } catch (Exception e) {
            //TODO: handle exception
            System.err.print(e.getMessage());
        }
        finally{
            this.close();
        }
        return flag;
    }

    // 代入查询语句（有占位符），判断是否能查询
    public boolean hasRecord(String sql,Object[] objs) {
        boolean flag = false;
        try {
            conn = this.getConnection();
            pstm = conn.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                pstm.setObject(i+1, objs[i]);
            }
            rs = pstm.executeQuery();
            flag = rs.next();
        } catch (Exception e) {
            //TODO: handle exception
            System.err.print(e.getMessage());
        }finally {
            this.close();
        }
        return flag;
    }

    // 关闭所有数据库对象
    public void close() {
        try {
            if(rs != null) {
                rs.close();
                rs = null;
            }
            if (stm != null) {
                stm.close();
                stm = null;
            }
            if (pstm != null) {
                pstm.close();
                pstm = null;
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.err.println("关闭异常:" + e.getMessage());
        }
    }
}