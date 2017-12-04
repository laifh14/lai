import java.util.LinkedList;
import java.util.ListIterator;

public class TestLinkedList {
    public static void main(String[] args){
        LinkedList<String> a=new LinkedList<>();
        a.add("a");
        a.add("b");
        a.add("c");

        LinkedList<String> b=new LinkedList<>();
        b.add("A");
        b.add("B");
        b.add("C");

        ListIterator<String> aI=a.listIterator();
        ListIterator<String> bI=b.listIterator();

        while (aI.hasNext()){
            aI.next();
            if(bI.hasNext()){
                aI.add(bI.next());
            }
        }
        System.out.println("a与b合并后： "+a);

        ListIterator<String> bIter=b.listIterator();
        while (bIter.hasNext()){
            bIter.next();
            if(bIter.hasNext()){
                bIter.next();
                bIter.remove();
            }
        }
        System.out.println("b删除偶数位置元素后："+b);

        a.removeAll(b);
        System.out.println("a里删除b的元素后： "+a);
    }
}
