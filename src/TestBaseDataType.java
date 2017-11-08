public class TestBaseDataType {
    public static void main(String[] args){
        byte i=(byte)(130*0.1);//算出来是doouble类型，需强制转换
        byte j=96;
        byte h=(byte) (i+j);//默认是\int类型，需强制转换，整型可以有大转换小，直接砍掉
        char c1='\u630e';//    Unicode转义符
        double d=1e200;
        float f=(float)1e200;//大转小，会溢出，输出显示：infinity
        //long l=12888888888888L;//需加上L，否则默认int类型，超出范围
        char c2='c',c3='d';
        char c4=(char)(c2+c3);//默认int，需强制转换
        System.out.println("c1="+c1);
        System.out.println(f);
        System.out.println("h="+h);
        System.out.println("d="+d);
        System.out.println("f="+f);
        System.out.println("c4="+c4);
    }
}
