package Game;
/*
 *@author lxin
 *$time  2019/5/24-18:49
 *数据库的链接及相关的数据操作
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DatabasePart {
    public static void main(String[] args) throws Exception{
        Connectionjdbc jdbcc=new Connectionjdbc();

        String sql="select * from gamedata order by scores asc";
        jdbcc.sqlQuery(sql);
        String sql1="update gamedata set scores=scores+1 where id =4";
        jdbcc.connectionUpdate(sql1);
        jdbcc.sqlQuery(sql);

        jdbcc.ConnectionBreak();
    }

}
class Connectionjdbc{
    /**
     * 此类为数据库链接类
     * 可执行的操作的数据的查询
     * 和jdbc接口的关闭
     */
    private static final String URL="jdbc:mysql://localhost:3306/game?serverTimezone=GMT";
    private static final String USER="root";
    private static final String PASS="1229";
    private Statement stm;
    private Connection con;
    private ResultSet set;
    public Connectionjdbc() throws Exception{
        this.con=DriverManager.getConnection(URL,USER,PASS);
        this.stm=con.createStatement();
    }
    public void sqlQuery(String sqlString) throws Exception{

        System.out.printf("%5s %5s %5s\n","学号","姓名","成绩");
        this.set=this.stm.executeQuery(sqlString);
        while(set.next()) {
            int num=set.getInt(1);
            String name=set.getString(2);
            int score=set.getInt(3);
            System.out.printf("%-5d %5s %4d\n",num,name,score);

        }

    }
    public void connectionUpdate(String upsql) throws Exception{
        this.stm.executeUpdate(upsql);
    }
    public void others(String othersql) throws Exception{
        this.stm.execute(othersql);
    }
    public void ConnectionBreak() throws Exception {
        this.con.close();
        this.set.close();
        this.stm.close();
    }

}