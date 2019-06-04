package TheExam1_2;

import java.io.File;
import java.nio.channels.FileLockInterruptionException;
import java.util.Scanner;

public class Q23 {
    public static void main(String[] arg){

        Scanner sc = new Scanner(System.in);

            System.out.println("请输入文件夹目录：");
            String sc1 = sc.nextLine();

            //创建对象，接收控制台中的输入
            File file = new File(sc1);

            listFile(file);


    }

    static void listFile(File file){
        if(file.exists()){
        if(file.isDirectory()){   //判断是文件还是文件目录
            System.out.println("文件夹目录为："+ file.getPath());
            File[] f = file.listFiles();
            for(int i = 0;i<f.length;i++)
                listFile(f[i]);  //递归输出文件目录


        }
        else
            System.out.println("文件为："+file.getName()+"，此文件路径是"+file.getAbsolutePath());
        }
        else
            System.out.println("文件不存在");

    }
}
