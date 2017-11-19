import java.io.*;

public class TestPrintStream {
    public static void main(String[] args){
        PrintStream ps=null;

        try{
            FileOutputStream fs=new FileOutputStream("E:\\learning\\tsinghua\\javaProject\\testData\\log.txt");
            ps=new PrintStream(fs);
        }catch (IOException i){
            i.printStackTrace();
        }

        if(ps!=null){
            System.setOut(ps);
        }

        int putin=0;

        for(char c=0;c<60000;c++){
            System.out.print(c);
            if(putin++>100){
                System.out.println();
                putin=0;
            }
        }
    }
}
