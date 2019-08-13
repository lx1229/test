package lx.test.table;/*
 *@author 刘鑫
 *$time  2019/5/23-16:07
 * JTable的使用
 * JFrame的使用
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class t1{
    public static void main(String[] args){
        System.out.printf("请输入数字\n");
        Scanner in =new Scanner(System.in);
        int num=in.nextInt();
        ArrayList<Integer> role=new ArrayList<Integer>();

        while(true)
        {
            Random gene=new Random();
            if(role.size()==num-1)
                break;
            int tmp=gene.nextInt(num);
            if(!role.contains(tmp))
                role.add(tmp);
        }
    for(int count=0;count<num;count++)
        System.out.println(role.get(count));
    }
    }
