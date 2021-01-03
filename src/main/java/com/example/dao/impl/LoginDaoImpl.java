package com.example.dao.impl;

import com.example.dao.LoginDao;
import com.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao {


    @Override
    public boolean Login(String username, String password) throws SQLException {
        DBUtil dbutil=new DBUtil();
        Connection con=dbutil.getConn();
        String sql="select * from login where username=? and password=?";

        try {

            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,username);
            pst.setString(2,password);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbutil.Close(con);
        }

        return false;
    }
}
