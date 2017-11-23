import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TestUDPClient {
    public static void main(String[] args){
        try {
            DatagramSocket ds=new DatagramSocket(9999);
            BufferedReader din=new BufferedReader(new InputStreamReader(System.in));
            ByteArrayOutputStream bao=new ByteArrayOutputStream();
            DataOutputStream dos=new DataOutputStream(bao);
            dos.writeLong(Long.parseLong(din.readLine()));
            byte[] buff=bao.toByteArray();
            DatagramPacket dp=new DatagramPacket(buff,buff.length,new InetSocketAddress("127.0.0.1",5678));
            ds.send(dp);
            din.close();
            ds.close();
        }catch (SocketException se){
            se.printStackTrace();
        }catch (IOException ie){
            ie.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
