package com.console.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.console.db.DBUtil;
import com.console.entity.Users;

public class UsersDao {

    //全部查询
    public List<Users> query() throws SQLException{

        List<Users> usersList = new ArrayList<Users>();

        //获取数据库连接
        Connection conn = DBUtil.getConnection();

        StringBuilder sb = new StringBuilder();
        sb.append("select * from user");

        // 通过数据库的连接操作数据库，实现增删改查
        PreparedStatement ptmt = conn.prepareStatement(sb.toString());

        ResultSet rs = ptmt.executeQuery();

        Users users = null;

        while(rs.next()){

            users = new Users();

            users.setId(rs.getInt("id"));
            users.setUsername(rs.getString("username"));
            users.setPassword(rs.getString("password"));
            users.setName(rs.getString("name"));
            users.setGender(rs.getString("gender"));
            users.setPhone(rs.getString("phone"));

            usersList.add(users);

        }

        return usersList;
    }

    //单个查询
    public Users queryById(Integer id) throws SQLException{

        Users u = null;

        Connection conn = DBUtil.getConnection();

        String sql = "select * from user where id=?";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setInt(1,id);

        ResultSet rs = ptmt.executeQuery();

        while(rs.next()){

            u = new Users();

            u.setId(rs.getInt("id"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setName(rs.getString("name"));
            u.setGender(rs.getString("gender"));
            u.setPhone(rs.getString("phone"));

        }

        conn.close();
        return u;
    }

    //添加功能
    public void addUsers(Users users) throws SQLException{

        // 获得数据库连接
        Connection conn = DBUtil.getConnection();

        String sql = "insert into users(username,password,name,gender,phone)values(?,?,?,?,?)";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1,users.getUsername());
        ptmt.setString(2,users.getPassword());
        ptmt.setString(3,users.getName());
        ptmt.setString(4,users.getGender());
        ptmt.setString(5,users.getPhone());

        ptmt.execute();
        conn.close();
    }

    //修改用户资料
    public void updateUsers(Users users) throws SQLException{

        // 获得数据库连接
        Connection conn = DBUtil.getConnection();

        String sql = "update user set username=?,password=?,name=?,gender=?,phone=? where id=?";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1,users.getUsername());
        ptmt.setString(2,users.getPassword());
        ptmt.setString(3,users.getName());
        ptmt.setString(4,users.getGender());
        ptmt.setString(5,users.getPhone());

        ptmt.setInt(6,users.getId());

        ptmt.execute();
        conn.close();
    }

    //删除用户
    public void deleteUsers(Integer id) throws SQLException{

        // 获得数据库连接
        Connection conn = DBUtil.getConnection();

        String sql = "delete from user where id=?";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setInt(1, id);

        ptmt.execute();

        conn.close();
    }
}
