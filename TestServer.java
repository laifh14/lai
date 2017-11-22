import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer{
    public static void main(String[] args){
        try {
            ServerSocket ss=new ServerSocket(8888);

            while (true) {
                Socket s=ss.accept();
                DataInputStream dis=new DataInputStream(s.getInputStream());
                OutputStream os=s.getOutputStream();
                DataOutputStream dos=new DataOutputStream(os);
                String ds;
                if((ds=dis.readUTF())!=null){
                    System.out.println(ds+": from"+s.getInetAddress()+":"+s.getPort());
                    dos.writeUTF("hello:"+s.getInetAddress());

                }
                dos.close();
                s.close();
            }
        }catch(IOException ie){
            ie.printStackTrace();
        }

    }
}