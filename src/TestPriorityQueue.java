import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.PriorityQueue;

public class TestPriorityQueue {
    public static void main(String[] args){
        PriorityQueue<GregorianCalendar> gc=new PriorityQueue<>();
        gc.add(new GregorianCalendar(1998, Calendar.DECEMBER,10));
        gc.add(new GregorianCalendar(2012,Calendar.JULY,20));
        gc.add(new GregorianCalendar(2005,Calendar.OCTOBER,28));
        gc.add(new GregorianCalendar(2008,Calendar.NOVEMBER,19));

        System.out.println("iterator over gc");
        for(GregorianCalendar gr:gc){
            System.out.println(gr.get(Calendar.YEAR));
        }

        System.out.println("###############");

        Iterator<GregorianCalendar> iterator=gc.iterator();
        if(iterator.hasNext()){
            System.out.println("first delete: "+iterator.next().get(Calendar.YEAR));
            iterator.remove();
        }

        System.out.println("second delete: "+gc.remove().get(Calendar.YEAR));
    }
}
