/*
  上机题Q25 服务器代码

  用Java SOCKET编程，实现简单的Echo功能
  如：当客户端从键盘输入hi（当用户输出exit推出程序），服务端响应为hi（服务器要求多线程）

  更新于2019.06.06

  Author：黄亮亮

 */
package TheExam1_2;

import java.io.*;
import java.net.*;

public class Q25 {
        //服务器程序继承Thread类
    public static class Server extends Thread{
        private Socket cq;
        //构造Server方法
        public Server(Socket cq){

            this.cq = cq ;
        }
        //重写run方法
        public void run(){
            try {
                   //创建in对象读取输入流文本
                   BufferedReader in=new BufferedReader(new InputStreamReader(cq.getInputStream()));
                   //将cq输出的格式打印到文本输出流out中
                   PrintWriter out = new PrintWriter(cq.getOutputStream());
                 while (true){
                    String str = in.readLine();   //将in的数据赋值给str
                    System.out.println(str);
                    out.println("message: " + str);
                    out.flush();
                    if (str.equals("exit")){
                    break;    //当接收到客户端的输入到服务器端的消息为exit时，跳出循环终结程序
                    }
                 }

                }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
            }



    }
    public static void main(String[] arg)throws IOException {
        //创建服务器套接字对象，等待网络进入请求，监听端口为8009
        ServerSocket server = new ServerSocket(8009);

        while(true){
            Socket s = server.accept(); //等待客户端，连接8009端口
            new Server(s).start();
        }

    }


}


