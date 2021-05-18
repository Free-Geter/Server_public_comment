package com.chenliang.Dao_imp;

import com.chenliang.Dao.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class BaseDao {
    private static String url = null;
    private static String user = null;
    private static String password = null;

    static {
        try {
            // load properties for Database
             ResourceBundle bundle = ResourceBundle.getBundle("DataBase");
             String driver = bundle.getString("driver");
             url = bundle.getString("url");
             user = bundle.getString("username");
             password = bundle.getString("password");
             // load mysql driver
             Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // get DataBase Connection
    protected Connection getConn() throws Exception{
        
        return new Inner().getConn();
    }

    // close Connection object
    protected void close(ResultSet res, Statement stm, Connection conn) {
        new Inner().close(res,stm,conn);
    }

    private class Inner implements Dao {

        @Override
        public Connection getConn() throws Exception {
            return DriverManager.getConnection(url,user,password);
        }

        @Override
        public void close(ResultSet res, Statement stm, Connection conn) {
            if (res != null){
                try {
                    res.close();
                    res = null;
                }catch (Exception e){
                    e.printStackTrace();
                }
                if (stm != null){
                    try {
                        stm.close();
                        stm = null;
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                if (conn != null){
                    try {
                        conn.close();
                        conn = null;
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
