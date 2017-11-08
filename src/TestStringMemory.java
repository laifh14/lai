public class TestStringMemory {
    public static void main(String[] args){
        String s1=new String("abc");
        String s2=new String("abc");
        System.out.println("s1==s2:"+(s1==s2));//s1,s2指向堆中不同对象
        String s3="abc";
        System.out.println("s3==s1:"+(s3==s1));//s3,s1指向不同对象，一个在堆中，一个在常量池中
        String s4="abc";
        System.out.println("s3==s4:"+(s3==s4));//s3,s4指向同一个对象，都在常量池中
    }
}
