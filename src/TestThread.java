public class TestThread {
    public static void main(String[] args){
        TestRun test=new TestRun();
        Thread thread=new Thread(test);
        thread.start();
        for (int i=0;i<100000;i++) {
            if(i%10000==0&&i>0) System.out.println("主线程 " + i);
        }
        test.shutDown();
    }
}
class TestRun implements Runnable{
    boolean flag=true;
    @Override
    public void run() {
            int i=0;
            while (flag){
            System.out.println("次线程 " + i++);
        }
    }
    public void shutDown(){
        flag=false;
    }
}
