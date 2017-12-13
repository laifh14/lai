import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankTest {
    public static void main(String[] args){
        int accountNum=100;
        double initialAmount=1000;
        Bank b=new Bank(accountNum,initialAmount);
        for(int i=0;i<accountNum;i++) {
            TransferRunnable transferRunnable = new TransferRunnable(b, i, 0.3*initialAmount);
            Thread thread=new Thread(transferRunnable);
            thread.start();
        }
    }
}

class Bank{
    private double[] account;
    private Lock bankLock=new ReentrantLock();
    private Condition sufficientFunds=bankLock.newCondition();

    public Bank(int num, double initial){
        account=new double[num];
        for(int i=0;i<num;i++){
            account[i]=initial;
        }
    }

    public  void transfer(int from,int to,double amount){
        try {
            if(account[from]<=amount){
                System.out.println("账户余额不足！");
                sufficientFunds.await();
             }
            bankLock.lock();
            System.out.println("开始转账……");
            account[from]+=amount;
            Thread.sleep(300);
            account[to]-=amount;
            System.out.println(amount+" 从账户 "+to+" 转入到账户 "+from);
            System.out.println(Thread.currentThread().getName()+"：总余额为："+getTotal());
            sufficientFunds.signalAll();
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }finally {
            bankLock.unlock();
        }
    }

    public double getTotal(){
        double sum=0;
        for(int i=0;i<this.getSize();i++){
            sum+=account[i];
        }
        return sum;
    }

    public int getSize(){
        return account.length;
    }
}
class TransferRunnable implements Runnable{
    private Bank bank;
    private int to;
    private double maxAmount;

    public TransferRunnable(Bank b,int to,double maxAmount){
        bank=b;
        this.to=to;
        this.maxAmount=maxAmount;

    }

    @Override
    public void run() {
        try {
        while(true) {
            int from = (int) (bank.getSize() * Math.random());
            double amout = maxAmount * Math.random();
            bank.transfer(from, to, amout);
            Thread.sleep(30);
        }
        }catch (InterruptedException ie){
                ie.printStackTrace();
        }
    }
}