public class SelfdefineException {
    public static void main(String[] args){
        int[] in={2,3,0,4};
        try {
            System.out.println("result= "+Test.testMethod(in,1,2));
        }catch (DivisionException d){
            System.out.println("出现除数为零");
            d.printStackTrace();
        }catch (ArrayoutException a) {
            System.out.println("数组索引越界");
            a.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("finally");
        }

    }
}
class DivisionException extends Exception{
    DivisionException(String msg){
        super(msg);
    }
}
class ArrayoutException extends Exception{
    ArrayoutException(String msg){
        super(msg);
    }
}
class Test{
    public static int testMethod(int[] a,int index1,int index2)throws DivisionException,ArrayoutException{
        if(index1>=a.length||index2>=a.length)
            throw new ArrayoutException("数组索引越界");
        if(a[index2]==0)
            throw new DivisionException("出现除数为零");
        return a[index1]/a[index2];
    }
}