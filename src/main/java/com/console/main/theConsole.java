package com.console.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.console.dao.AdminsDao;
import com.console.dao.UsersDao;
import com.console.entity.Admins;
import com.console.entity.Users;
import com.console.MD5.MD5;

public class theConsole {

    //单个查询(用户）
    private static Users getUser(Integer id) throws SQLException {

        UsersDao dao = new UsersDao();
        return dao.queryById(id);

    }

    //单个查询(管理员）
    private static Admins getAdmin(Integer id) throws SQLException {

        AdminsDao dao = new AdminsDao();
        return dao.queryById(id);

    }

    //用于登陆的函数(用户）
    private static boolean userLogin(Integer id) throws SQLException{

        Scanner in=new Scanner(System.in);

        //MD5加密
        MD5 getMD5 = new MD5();

        System.out.println("Please input password:");
        String PSW = in.next();

        if(getUser(id).getPassword().equals(getMD5.getMD5Code(PSW)))
        {
            return true;
        }
        else {
            return false;
        }
    }

    //用于登陆的函数(管理员）
    private static boolean adminLogin(Integer id) throws SQLException{

        Scanner in=new Scanner(System.in);

        //MD5加密
        MD5 getMD5 = new MD5();

        System.out.println("Please input password:");
        String PSW = in.next();

        if(getAdmin(id).getPassword().equals(getMD5.getMD5Code(PSW)))
        {
            return true;
        }
        else {
            return false;
        }
    }

    //登陆菜单
    private static void loginMenu(){

        System.out.println("--        Login       --");
        System.out.println("--    Please choose   --");
        System.out.println("--    1. user login   --");
        System.out.println("--    2. admin login  --");
        System.out.println("--    3. exit         --");

    }

    //用户菜单
    private static void userMenu(){

        System.out.println("--        User        --");
        System.out.println("--    Please choose   --");
        System.out.println("--    1. query        --");
        System.out.println("--    2. update       --");
        System.out.println("--    3. exit         --");

    }

    //管理员菜单
    private static void adminMenu(){

        System.out.println("--        Admin       --");
        System.out.println("--    Please choose   --");
        System.out.println("--    1. admin id query     --");
        System.out.println("--    2. admin query all    --");
        System.out.println("--    3. admin add user     --");
        System.out.println("--    4. admin update       --");
        System.out.println("--    5. admin delete       --");
        System.out.println("--    6. user id query      --");
        System.out.println("--    7. user query all     --");
        System.out.println("--    8. user add user      --");
        System.out.println("--    9. user update        --");
        System.out.println("--    10. user delete        --");
        System.out.println("--    11. exit               --");

    }

    /*
    现在数据库创建两个表
    admin，user
    两个不同登陆端
    admin可以进行对所有用户进行增删查改
    user只有查看和更改自己信息的权限
    */
    public static void main(String[] args) throws SQLException {

        Integer choose;
        Integer usid;
        Integer adid;
        Scanner input=new Scanner(System.in);

        while(true) {

            loginMenu();
            System.out.println("please choose:");
            choose = input.nextInt();
            switch (choose){

                case 1:
                    System.out.println("please input id:");
                    usid = input.nextInt();
                    if(userLogin(usid)){
                        while(true){
                            userMenu();
                            System.out.println("please choose:");
                            choose = input.nextInt();
                            switch (choose) {
                                case 1:
                                    System.out.println("Your information:");
                                    System.out.println("username:" + getUser(usid).getUsername());
                                    System.out.println("name:" + getUser(usid).getName());
                                    System.out.println("gender:" + getUser(usid).getGender());
                                    System.out.println("phone:" + getUser(usid).getPhone());
                                    break;
                                case 2:

                                    //MD5加密
                                    MD5 getMD5 = new MD5();

                                    UsersDao userDao = new UsersDao();
                                    Users USER = new Users();
                                    USER.setId(usid);
                                    String username;
                                    String password;
                                    String name;
                                    String gender;
                                    String phone;
                                    System.out.println("username:");
                                    username = input.next();
                                    System.out.println("password:");
                                    password = input.next();
                                    System.out.println("name:");
                                    name = input.next();
                                    System.out.println("gender:");
                                    gender = input.next();
                                    System.out.println("phone:");
                                    phone = input.next();
                                    USER.setUsername(username);
                                    //密码加密后再存入
                                    USER.setPassword(getMD5.getMD5Code(password));
                                    USER.setName(name);
                                    USER.setGender(gender);
                                    USER.setPhone(phone);
                                    userDao.updateUsers(USER);
                                    break;
                                case 3:
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println("Please choose right select !");
                            }
                        }
                    }
                    break;

                case 2:
                    adid = input.nextInt();
                    if(adminLogin(adid)) {
                        adminMenu();
                        choose = input.nextInt();
                        switch (choose) {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                break;
                            case 8:
                                break;
                            case 9:
                                break;
                            case 10:
                                break;
                            case 11:
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Please choose right select !");
                        }

                    }
                    break;

                case 3:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please choose right select !");
            }

        }

        /* if(userLogin(2))
        System.out.println("1213");*/

        /*UsersDao userDao = new UsersDao();
        List<Users> userList = userDao.query();

        for(Users users : userList)
        {
            System.out.println(users.getName());
        }*/
    }
}


/*author @theTuring*/
