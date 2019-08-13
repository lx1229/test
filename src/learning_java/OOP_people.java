package learning_java;/*
 *@author lxin
 *$time  2019/6/1-9:12
 * 多个类放在一个包中跟放在一个代码页引用都是一样的
 * 这一节主要是练习静态方法的使用
 */

import java.util.Scanner;

public class OOP_people{
    public static void main(String[] args){
        System.out.println("请输入工人姓名");
        Scanner in =new Scanner(System.in);
        People man = new People();
        String name;
        while(in.hasNext()) {
            name=in.next();
            if(name.compareToIgnoreCase("刘鑫")==0)
                man.openFrigerator(name);
            if(name.compareToIgnoreCase("大狗")==0)
                man.letElephantIn(name);
            if(name.compareToIgnoreCase("二狗")==0)
                man.closeFrigerator(name);
        }
    }
}
class People {
    protected  void openFrigerator(String name){
        System.out.println(name+"打开了冰箱");
        Frigerator.open();
    }
    public   void letElephantIn(String name){
        System.out.println(name+"把大象放进了了冰箱");
        Elephant.inFrigerator();
    }
    public   void closeFrigerator(String name){
        System.out.println(name+"关闭了冰箱");
        Frigerator.close();

    }
}
class Elephant {
    public static void inFrigerator(){
        System.out.println("大象进入冰箱了");
    }
}
class Frigerator {
    public static void open(){
        System.out.println("冰箱打开了");

    }
    public static void close(){
        System.out.println("冰箱关上了\n");
    }
}
