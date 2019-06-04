package TheExam1_2;


import java.io.*;
import java.net.*;
public class Q25 {
    //服务器程序
    public static class Server extends Thread{
        private Socket cq;
        public Server(Socket cq){
            this.cq = cq ;
        }

        public void run(){
            try {
                   BufferedReader in=new BufferedReader(new InputStreamReader(cq.getInputStream()));
                   PrintWriter out = new PrintWriter(cq.getOutputStream());
         while (true){
                    String str = in.readLine();
                    System.out.println(str);
                    out.println("message: " + str);
                    out.flush();
                    if (str.equals("exit"))
                    break;}

                }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
            }



    }
    public static void main(String[] arg)throws IOException {
        ServerSocket server = new ServerSocket(8009);
        while(true){
            Socket s = server.accept();
            new Server(s).start();
        }

    }


}


