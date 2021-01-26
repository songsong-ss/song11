package com.example.dao.impl;

import com.example.bean.Page;
import com.example.bean.User;
import com.example.dao.UserDao;
import com.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    DBUtil dbutil=new DBUtil();
    Connection con=dbutil.getConn();
    PreparedStatement pst=null;
    @Override
    public List<Map> findAll() {
        String sql="select * from user";
        List<Map> list=new ArrayList<Map>();
        try {
            pst=con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                int age=rs.getInt("age");
                String phone=rs.getString("phone");
                Map map=new HashMap();
                map.put("id",id);
                map.put("name",name);
                map.put("age",age);
                map.put("phone",phone);
                list.add(map);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public void Add(int id, String name, int age, String phone) {
        String sql="insert into user (id,name,age,phone) values(?,?,?,?)";
        try {

            pst=con.prepareStatement(sql);
            pst.setInt(1,id);
            pst.setString(2,name);
            pst.setInt(3,age);
            pst.setString(4,phone);
            pst.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void Delete(int id) {
        String sql="delete from user where id="+id;
        try {
            pst=con.prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void Update(int id, String name, int age, String phone) {
        String sql="update user set name=?,age=?,phone=? where id=?";
        try {
            pst=con.prepareStatement(sql);
            pst.setString(1,name);
            pst.setInt(2,age);
            pst.setString(3,phone);
            pst.setInt(4,id);
            pst.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public List<Page> FindUserByPage(int currentPage, int rows) {
        return null;
    }

    @Override
    public User findById(int id) {
        String sql="select * from user where id="+id;
        User user = null;
        try {
            pst= con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                user=new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setAge(rs.getInt(3));
                user.setPhone(rs.getString(4));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;

    }

    @Override
    public List<User> findByName(String name) {
        String sql="select * from user where name="+name;
        List<User> list=new ArrayList<User>();
        try {
            pst= con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                User user=new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setAge(rs.getInt(3));
                user.setPhone(rs.getString(4));
                list.add(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public User findByIdandName(int id, String name) {
        String sql="select * from user where id=? and name=?";
        User user=null;
        try {
            pst= con.prepareStatement(sql);
            pst.setInt(1,id);
            pst.setString(2,name);
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                user=new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setAge(rs.getInt(3));
                user.setPhone(rs.getString(4));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public Page findUserByPage(int currentPage, int rows) {
        UserDao dao=new UserDaoImpl();
        Page pb=new Page();
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        int totalCount=dao.findTotalCount();
        pb.setTotalCount(totalCount);
        int start=(currentPage-1)*rows;
        List<User> list=dao.findByPage(start,rows);
        pb.setList(list);
        int totalPage=totalCount%rows==0?totalCount/rows:totalCount/rows+1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public int findTotalCount() {
        String sql="select count(*) from user";
        int count=0;
        try {
            count=pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    @Override
    public List<User> findByPage(int start, int rows) {
        String sql="select * from user limit ?,?";
        List<User> list=new ArrayList<User>();
        try {
            pst=con.prepareStatement(sql);
            pst.setInt(1,start);
            pst.setInt(2,rows);
            ResultSet rs= pst.executeQuery();
            while (rs.next()){
                User user=new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setAge(rs.getInt(3));
                user.setPhone(rs.getString(4));
                list.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return list;
    }


}
