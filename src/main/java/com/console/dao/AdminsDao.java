package com.console.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.console.db.DBUtil;
import com.console.entity.Admins;
import com.console.entity.Users;

public class AdminsDao {

    //全部查询
    public List<Admins> query() throws SQLException{

        List<Admins> adminsList = new ArrayList<Admins>();

        //获取数据库连接
        Connection conn = DBUtil.getConnection();

        StringBuilder sb = new StringBuilder();

        sb.append("select * from admin");

        // 通过数据库的连接操作数据库，实现增删改查
        PreparedStatement ptmt = conn.prepareStatement(sb.toString());

        ResultSet rs = ptmt.executeQuery();

        Admins admins = null;

        while(rs.next()){

            admins = new Admins();

            admins.setId(rs.getInt("id"));
            admins.setUsername(rs.getString("username"));
            admins.setPassword(rs.getString("password"));

            adminsList.add(admins);

        }

        return adminsList;

    }

    //单个查询
    public Admins queryById(Integer id) throws SQLException{

        Admins u = null;

        Connection conn = DBUtil.getConnection();

        String sql = "select * from admin where id=?";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setInt(1,id);

        ResultSet rs = ptmt.executeQuery();

        while(rs.next()){

            u = new Admins();

            u.setId(rs.getInt("id"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));

        }

        return u;
    }

    //添加功能
    public void addAdmins(Admins admins) throws SQLException{

        // 获得数据库连接
        Connection conn = DBUtil.getConnection();

        String sql = "insert into admin(username,password)values(?,?)";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1,admins.getUsername());
        ptmt.setString(2,admins.getPassword());

        ptmt.execute();

        conn.close();
    }

    //修改管理员
    public void updateAdmins(Admins admins) throws SQLException{

        // 获得数据库连接
        Connection conn = DBUtil.getConnection();

        String sql = "update admin set username=?,password=?where id=?";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1,admins.getUsername());
        ptmt.setString(2,admins.getPassword());

        ptmt.setInt(3,admins.getId());

        ptmt.execute();

        conn.close();
    }

    //删除管理员
    public void deleteAdmins(Integer id) throws SQLException{

        // 获得数据库连接
        Connection conn = DBUtil.getConnection();

        String sql = "delete from admin where id=?";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setInt(1, id);

        ptmt.execute();

        conn.close();
    }
}
