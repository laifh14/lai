import static java.lang.Thread.sleep;

public class TestSynchronized {
    public static void main(String[] args){
        Ts ts=new Ts();
        Thread thread=new Thread(ts);
        thread.start();
        ts.method2();
        System.out.println("主线程 b= "+ts.b);
    }
}
class Ts implements Runnable{
        int b=10;
    public  synchronized void method1(){
        b=1000;
        try {
            sleep(5000);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
        System.out.println("method1 b= "+b);
    }
    public void method2(){

        try {
            sleep(1000);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
        b=2000;
        System.out.println("method2 b= "+b);
    }
    public void run(){
        try {
            method1();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
