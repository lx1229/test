package lx.test.table;/*
 *@author lxin
 *$time  2019/5/24-16:46
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PackageTest {

    public static void main(String[] args) throws Exception{
    Connection1 con1 = new Connection1();

    }
}
//社么是对象？？ 可以提供特定服务的操作的一种实例化抽象个体
//特定服务这个词一定要好好理解，可以理解一个类为可以执行特定操作并提供返回结果的一个封装
class  Connection1{
    //关于URL的参数问题  现在的操作必须非得加上时区设置
    //市区设置为UTC世界统一时间，时区有好多种 除了世界统一时间，其他的还有很多的时区设置
    //时区也可以设置为GMT（格林威治时间），程序也可以运行


    private static final String URL = "jdbc:mysql://localhost:3306/game?serverTimezone=GMT";
    /**
     * 问号(?)分隔URL和查询
     */
    private static final String USER = "root";
    private static final String PASS= "1229";
    private String querystring="select * from  data order by scores asc";
    //访问区域限制符也不能随便加 在类中的局部变量就不允许加
    //而成员变量可以加
    public Connection1() throws Exception{

            Connection con =DriverManager.getConnection(URL,USER,PASS);
            Statement state = con.createStatement();
            ResultSet set=state.executeQuery(querystring);

            System.out.printf("学号  姓名   成绩\n");
            set.afterLast();
            set.previous();
            int a =set.getInt(1);
            String s=set.getString(2);
            int c=set.getInt(3);
            System.out.printf("%2d%6s%5d\n",a,s,c);

    }
}
class update1{

}