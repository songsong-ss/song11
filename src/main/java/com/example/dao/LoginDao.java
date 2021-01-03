package com.example.dao;

import java.sql.SQLException;

public interface LoginDao {
    public boolean Login(String username,String password) throws SQLException;
}
