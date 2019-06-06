/*
  上机题Q25 客户端代码

  用Java SOCKET编程，实现简单的Echo功能
  如：当客户端从键盘输入hi（当用户输出exit推出程序），服务端响应为hi（服务器要求多线程）

  更新于2019.06.06

  Author：黄亮亮

 */
package TheExam1_2;

import java.io.*;
import java.net.Socket;

public class Q25Clinet {

    public static void main(String[] args)throws Exception
    {
        //创建server，构造远程机器名称和要连接的端口号
        Socket server=new Socket("localhost",8009);

        //创建in对象读取输入流文本
        BufferedReader in=new BufferedReader(new InputStreamReader(server.getInputStream()));

        //将server输出的格式打印到文本输出流out中
        PrintWriter out=new PrintWriter(server.getOutputStream());

        //接收控制台输入的文本输入流
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String str=br.readLine();
            out.println(str);
            out.flush();
            if(str.equals("exit")){
                break;   //当控制台输入为exit，跳出循环终结程序
            }
            System.out.println(in.readLine());    //ehco回应
        }
        server.close();
    }
}


