import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TestUDPServer {
    public static void main(String[] args){
        byte[] buff=new byte[1024];
        try {
            DatagramPacket dp=new DatagramPacket(buff,buff.length);
            DatagramSocket ds=new DatagramSocket(5678);
            while(true){
                ds.receive(dp);
                ByteArrayInputStream byin=new ByteArrayInputStream(buff);
                DataInputStream dtin=new DataInputStream(byin);
                System.out.println("result is  "+dtin.readLong());
            }
        }catch (SocketException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
