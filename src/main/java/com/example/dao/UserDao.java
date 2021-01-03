package com.example.dao;

import com.example.bean.Page;
import com.example.bean.User;

import java.util.List;
import java.util.Map;

public interface UserDao  {
    public List<Map> findAll();
    public void Add(int id,String name,int age,String phone);
    public void Delete(int id);
    public void Update(int id,String name,int age,String phone);
    public List<Page> FindUserByPage(int currentPage,int rows);
    public User findById(int id);
    public List<User> findByName(String name);
    public User findByIdandName(int id,String name);
    public Page findUserByPage(int currentPage,int rows);

    public int findTotalCount();

    public List<User> findByPage(int start, int rows);
}
