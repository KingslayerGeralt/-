package TheExam1_2;
/*
一个汉字两个字节
一个字母一个字节

汉字的unicode都是复数


 */



import java.io.IOException;
import java.util.Scanner;

public class Q24 {
    public static void main(String[] arg) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String str = sc.nextLine();
        System.out.println("请输入截取的字节长度：");
        int num = sc.nextInt();

        seperate(str,num);


    }
    public static void seperate(String str,int num)throws IOException{
        byte[] by = str.getBytes("GBK");
        int count=0;

        if(num>by.length||num<0){
            System.out.println("输入长度错误");
        }
        else{
            for(int i =0;i<num;i++)
            {if(by[i]<0)
                    count++;
            }
            if(count%2==0)
                System.out.println("结果为："+ new String(by,0,num,"GBK"));
            else
                System.out.println("结果为："+ new String(by,0,num-1,"GBK"));


        }




    }
}
