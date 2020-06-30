package cn.itcast.Day19.Homework3;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/*
【编号2106】请编写程序，分别模拟使用TCP协议传输数据的客户端和服务器端，完成文件上传。
客户端获取键盘录入的文件路径，将文件上传给服务器端，服务器端获取到数据后，保存到当前模块目录下，
并给出反馈。其中，上传的文件仅允许jpg格式的图片，保存到服务器端的文件，为防止重名覆盖，可使用32位UUID作为文件名。
在实际生产中，服务器端有可能接收多个客户端的上传请求，所以服务器端可以使用多线程实现，为每个客户端开启一条线程完成上传。
 */
public class ClientDemo3 {
    public static void main(String[] args) throws IOException {
        Socket s=new Socket("www.CoderWang.com",10000);
        Scanner cin=new Scanner(System.in);
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(cin.next()));
        BufferedOutputStream bos=new BufferedOutputStream(s.getOutputStream());
        byte []bys=new byte[1024];
        int b;
        while ((b=bis.read(bys))!=-1){
            bos.write(bys,0,b);
            bos.flush();
        }
        s.shutdownInput();
        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        System.out.println(br.readLine());
        br.close();
        s.close();
    }
}
