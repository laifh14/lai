public class TestProducerConsumer {
    public static void main(String[] args){
        Bread[] br=new Bread[6];
        BreadBasket bb=new BreadBasket(0,br);
        Producer pd=new Producer(bb);
        Consumer con=new Consumer(bb);
        Thread th1=new Thread(pd);
        Thread th2=new Thread(con);
        th1.start();
        th2.start();

    }
}
class BreadBasket{
    int index;
    Bread[] count;
    public BreadBasket(int ca,Bread[] br){
        index=ca;
        count=br;
    }
    public boolean isEmpty(){
        return this.index==0;
    }
    public boolean isFull(){
        return this.index==count.length;
    }
    public synchronized void push(Bread b){
        if (isFull()){
            try{
                this.wait();
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }

        }
        this.notify();
        count[index]=b;
        index++;
        System.out.println("生成面包 "+b);
    }

    public synchronized Bread consum() {
        if (isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }

        }
        this.notify();
        index--;
        Bread b = count[index];
        count[index] = null;
        System.out.println("消费面包 " + b);
        return b;
    }
}
class Bread{
    int id;
    Bread(int _id){
        id=_id;
    }
    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
class Producer implements Runnable{
//    Bread br;
    BreadBasket bb;
    Producer(BreadBasket nbb){
        bb=nbb;
    }
    @Override
    public void run() {
        for(int i=0;i<20;i++){
            Bread b=new Bread(i+1);
            bb.push(b);
        }
    }
}
class Consumer implements Runnable{
    BreadBasket bb;
    Consumer(BreadBasket nbb){
        bb=nbb;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            Bread b = bb.consum();
            System.out.println("消费面包 " + b);
        }
    }
}
