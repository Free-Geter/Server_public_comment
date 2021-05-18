package com.chenliang.Dao_imp;

import com.chenliang.Dao.CityDao;
import com.chenliang.Dao.City;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImp extends BaseDao implements CityDao {
    @Override
    public List<City> getCity() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<City> cities = null;

        try {
            connection = getConn();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from city order by city_skey");
            cities = new ArrayList<City>();

            while (resultSet.next()){
                City city = new City();
                city.setCity_id(resultSet.getInt("city_id"));
                city.setCity_name(resultSet.getString("city_name"));
                city.setCity_skey(resultSet.getString("city_skey"));
                cities.add(city);
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            close(resultSet,statement,connection);
        }
        return cities;
    }
}
