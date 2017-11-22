import java.io.*;
import java.net.Socket;

public class TestClient{
    public static void main(String[] args){
        try {
            Socket s=new Socket("127.0.0.1", 8888);
            DataInputStream dis=new DataInputStream(s.getInputStream());
            OutputStream os=s.getOutputStream();
            DataOutputStream dos=new DataOutputStream(os);
            dos.writeUTF("hello server");
            String ds;
            if((ds=dis.readUTF())!=null){
                System.out.println(ds+": from"+s.getInetAddress()+":"+s.getPort());
            }
            dos.close();
            s.close();
        } catch (IOException ie) {
            ie.printStackTrace();
        }

    }
}