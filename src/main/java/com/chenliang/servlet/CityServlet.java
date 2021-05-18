package com.chenliang.servlet;

import com.chenliang.Dao.City;
import com.chenliang.Dao.CityDao;
import com.chenliang.Dao_imp.CityDaoImp;
import com.chenliang.entity.ResponseObject;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CityServlet extends HttpServlet {

    private static final long serialVersionUID = -7116871746241279602L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        CityDao dao = new CityDaoImp();
        List<City> list = dao.getCity();

        ResponseObject result = null;
        if (list != null && list.size() > 0){
            result = new ResponseObject(1,list);
        }else {
            result = new ResponseObject(0,"fail to get City info");
        }
        // convert result into a json
        out.println(new GsonBuilder().create().toJson(result));
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
