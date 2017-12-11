public class BankTest {
    public static void main(String[] args){
        int accountNum=100;
        double initialAmount=1000;
        for(int i=0;i<accountNum;i++) {
            TransferRunnable transferRunnable = new TransferRunnable(accountNum, initialAmount, i, 0.5*initialAmount);
            Thread thread=new Thread(transferRunnable);
            thread.start();
        }
    }
}

class Bank{
    private double[] account;

    public Bank(int num, double initial){
        account=new double[num];
        for(int i=0;i<num;i++){
            account[i]=initial;
        }
    }

    public void transfer(int from,int to,double amount){
        if(account[from]<=amount){
            System.out.println("账户余额不足！");
            return;
        }
        System.out.println("开始转账……");
        account[from]+=amount;
        account[to]-=amount;
        System.out.println(amount+" 从账户 "+to+" 转入到账户 "+from);
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

    public TransferRunnable(int num,double initial,int to,double maxAmount){
        bank=new Bank(num,initial);
        this.to=to;
        this.maxAmount=maxAmount;
        try {
            Thread.sleep(10);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }

    @Override
    public void run() {
        int from=(int)(bank.getSize()*Math.random());
        double amout=maxAmount*Math.random();
        bank.transfer(from,to,amout);
        System.out.println(Thread.currentThread().getName()+"总额为："+bank.getTotal());
    }
}