/*
  上机题Q24

  编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节获取的字符串，但要保证汉字不被截半个，如
  “我ABC”，4，应该截成“我AB”，输入“我ABC汉DEF”，6，应该输出为“我ABC”而不是“我ABC+汉地半个”

  更新于2019.06.04

  Author：黄亮亮

 */
package TheExam1_2;

import java.io.IOException;
import java.util.Scanner;

public class Q24 {
    public static void main(String[] arg) throws IOException {
        //创建Scanner对象
        Scanner sc = new Scanner(System.in);

        //提示从键盘输入要截取的字符串
        System.out.println("请输入字符串：");
        String str = sc.nextLine();

        //提示从键盘输入要截取字符串的个数
        System.out.println("请输入截取的字节长度：");
        int num = sc.nextInt();

        //调用seperate方法
        seperate(str,num);
    }


public static void seperate(String str,int num) throws IOException{

        byte[] by = str.getBytes("GBK");  //告诉虚拟机将中文以“GBK”方式转换为数组，一个汉字占两个字节
        int count=0;

        if(num>by.length||num<0){        //判断字符串长度和分割数是否适用
            System.out.println("输入长度错误");
        }
        else{
            for(int i =0;i<num;i++) {
                if(by[i]<0){
                    count++;  //汉字的Unicode为负数，以此判断存放的数组元素是否为汉字
                }
            }
            if(count%2==0)    //每当运算完上一个循环后给count对2取余数就可以知道是否有汉字存在
                System.out.println("结果为："+ new String(by,0,num,"GBK"));
            else
                System.out.println("结果为："+ new String(by,0,num-1,"GBK"));


        }




    }
}
