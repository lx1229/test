package lx.test.table;/*
 *@author lxin
 *$time  2019/5/23-22:19
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
    /**
     * JDBC的静态常量就是url,数据库的用户名和密码
     */
    public static final String URL = "jdbc:mysql://localhost:3306/localhost_3306.学生信息表";
    public static final String USER = "root";
    public static final String PASSWORD = "1229";

    public static void main(String[] args) throws Exception {
        /**
         * 驱动的加载
         */
       String Sdrive= "com.mysql.jdbc.Driver";
       Class.forName(Sdrive);

        /**
         * 建立连接
         */
        Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
        /**
         * 连接可以创建声明
         * 创建声明，声明的静态方法可以执行sql语句
         */
       Statement state=con.createStatement();
       String sqlquery="select * from student";
       ResultSet set=state.executeQuery(sqlquery);
        /**
         * 遍历结果集并输出
         */
       while(set.next())
       {
           String id=set.getString(1);
           String name=set.getString(2);
           System.out.printf("%d %s\n",id,name);
       }
        /**
         * 结束之后一定要关闭连接
         * 也要关闭声明
         */
    con.close();;
    state.close();;

    }
}