public class TestException {
    public static void main(String[] args){
        int[] arr={1,2,3,4,5};
        int a=1;
        try{
            System.out.println(arr[8]);
        }catch (ArrayIndexOutOfBoundsException ai){
            System.out.println("数组越界");
            ai.printStackTrace();
        }
        try{
            System.out.println(a/0);
        }catch (ArithmeticException ae){
            System.out.println("出现除数为零");
            ae.printStackTrace();
        }
    }
}
