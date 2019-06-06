/*
   上机题Q23

   遍历文件夹下地所有文件目录及文件（文件夹从命令行输入）

   更新于2019.06.04

   Author：黄亮亮

 */

package TheExam1_2;

import java.io.File;
import java.util.Scanner;

public class Q23 {
    public static void main(String[] arg){

        Scanner sc = new Scanner(System.in);

        //提示输入
        System.out.println("请输入文件夹目录：");
        String sc1 = sc.nextLine();       //接收键盘录入

        //创建对象，接收控制台中的输入
        File file = new File(sc1);

        //调用listFile方法
        listFile(file);


    }

    static void listFile(File file){
        //判断文件是否存在
        if(file.exists()){
            //判断是文件还是文件目录
           if(file.isDirectory()){
             System.out.println("文件夹目录为："+ file.getPath());
             File[] f = file.listFiles();

             for(int i = 0;i<f.length;i++) {
                listFile(f[i]);    //递归输出文件目录
             }
           }
        else
            System.out.println("文件为："+file.getName()+"，此文件路径是"+file.getAbsolutePath());
        }
        else        //若文件不存在，输出
            System.out.println("文件不存在");

    }
}
