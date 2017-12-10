import static java.lang.Thread.sleep;
public class TestSync implements Runnable{
    private Timer timer=new Timer();
    public static void main(String[] args){
        TestSync test=new TestSync();
        Thread thread1=new Thread(test);
        Thread thread2=new Thread(test);
        thread1.setName("t1");
        thread2.setName("t2");
        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        timer.add(Thread.currentThread().getName());
    }
}
class Timer{
    private static int num=0;
    public  synchronized void add(String name){
        num++;
        try {
            sleep(1000);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
        System.out.println(name+": 你是第"+num+"个使用add方法的线程");
    }
}

