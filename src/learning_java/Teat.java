package learning_java;/*
 *@author lxin
 *$time  2019/5/31-22:36
 * java数组的学习
 * 关于数组的操作有两个类
 * ①java.util.Arrays的包是用来操作数组的 排序和二分法查找的
 * ②java.lang.reflect的包是用来修改和获取数组指定索引的值的
 */
//关于各种操作符的规范化，要是书写错误会导致程序崩溃

import java.util.Scanner;
import java.util.Arrays;

public class Teat{
    public static void main(String[] args) throws Exception{
        Search s=new Search();

    }
}
//类的定义中只有属性跟方法，任何操作都要放到方法里面
class Search{
    private static final int[] arr={1,10,8,9,5,6,7,2,3,4};

    //Arrays.sort(arr);  放在这个位置编译失败

    public Search(){
        Arrays.sort(arr);
        //二分法查找必须要排序之后才能查找

        Scanner in=new Scanner(System.in);
        System.out.println("请输入您要查找的值");
        while(in.hasNextInt()){
            int data=in.nextInt();
            int indexList=Arrays.binarySearch(arr,data);
            if(indexList>=0)
                System.out.printf("-----查找的值的索引为：%d\n",indexList);
            else
                System.out.println("-----列表中无此元素");
            System.out.println("\n请输入您要查找的值");
        }
    }
}