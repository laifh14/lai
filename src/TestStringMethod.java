public class TestStringMethod {
    public static void main(String[] args){
        char[] c={'a','b','c','d','e','f'};
        int in=6;
        String s1=new String(c);
        String s2=new String(c,0,2);
        String s3=new String(s1);
        String s4="bcd";
        char c1=s1.charAt(2);
        String s5=s1.concat(s2);
        StringBuffer sb=new StringBuffer(s1);
        String s6=s1.substring(1);
        String s7=s1.substring(1,4);
        String s8= "write once, run anywhere!";
        String s9 ="run";
        String s10="6";


        System.out.println("s1="+s1);
        System.out.println("s2="+s2);
        System.out.println("s3="+s3);
        System.out.println("c1="+c1);
        System.out.println("s5="+s5);
        System.out.println("s6="+s6);
        System.out.println("s7="+s7);
        System.out.println("s1.compareTo(s2): "+s1.compareTo(s2));//子序列，返回长度差
        System.out.println("s1.compareTo(s4): "+s1.compareTo(s4));//返回第一个不相等的字符差
        System.out.println("s1.compareTo(s3): "+s1.compareTo(s3));//相等返回0
        System.out.println("s1.contentEquals(sb): "+s1.contentEquals(sb));
        System.out.println("s1.equals(s3): "+s1.equals(s3));
        System.out.println("s1==s3: "+(s1==s3));
        System.out.println("s8.indexOf('w'): "+s8.indexOf('w'));
        System.out.println("s8.indexOf('r',2): "+s8.indexOf('r',2));
        System.out.println("s8.indexOf(s9): "+s8.indexOf(s9));
        System.out.println("s10.equals(String.valueOf(in)): "+s10.equals(String.valueOf(in)));







    }
}
