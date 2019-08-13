package Game;/*
 *@author lxin
 *$time  2019/5/28-22:28
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomNumber {
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        System.out.printf("请输入角色的人数\n");
        int num = in.nextInt();

        RandNumber roleList = new RandNumber();
        roleList.RandNumber1(num);
        Role outcome = new Role();
        outcome.Role1(roleList.list,num);
        for (int count = 0; count < num; count++) {
            System.out.printf("序号  %-5d 角色  %5s\n",count+1,outcome.rolePlayList.get(count));
        }

    }
}
//随机序列生成类
class RandNumber {
    public ArrayList<Integer> list = new ArrayList<Integer>();
    // 列表的可动态扩展特性真是不错的

    //构造方法运用失败，只能用方法来修改属性、

    public  void RandNumber1(int n) {
        Random gene =new Random();//构建一个随机数生成器
            while (true) {
                if (this.list.size() == n )
                    break;
                int tmp = gene.nextInt(n);
                if (!this.list.contains(tmp))
                this.list.add(tmp);
        }
    }
}
//角色生成类
class Role {
    public ArrayList<String> rolePlayList = new ArrayList<String>();

    public void Role1(ArrayList<Integer> list1, int num) {
        for (int count = 0; count < num; count++) {
            int tmp = list1.get(count);
            if (tmp >= 0 && tmp <= 4)
                this.rolePlayList.add("狼人");
            else if (tmp >= 5 && tmp <= 8)
                this.rolePlayList.add("村民");
            else if (tmp == 9)
                this.rolePlayList.add("女巫");
            else if (tmp == 10)
                this.rolePlayList.add("猎人");
            else if (tmp == 11)
                this.rolePlayList.add("预言家");
            else if (tmp == 12)
                this.rolePlayList.add("纵火者");
            else if (tmp == 13)
                this.rolePlayList.add("守卫");
            else if (tmp == 14)
                this.rolePlayList.add("混子");

        }
    }
}