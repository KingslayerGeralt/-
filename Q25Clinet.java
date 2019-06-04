package TheExam1_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.*;
import java.io.*;
public class Q25Clinet {

    public static void main(String[] args)throws Exception
    {
        Socket server=new Socket("localhost",8009);
        BufferedReader in=new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter out=new PrintWriter(server.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String str=br.readLine();
            out.println(str);
            out.flush();
            if(str.equals("exit")){
                break;
            }
            System.out.println(in.readLine());
        }
        server.close();
    }
}


