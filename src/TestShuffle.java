import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestShuffle {
    public static void main(String[] args){
        List<Integer> item=new ArrayList<>();
        for(int i=0;i<50;i++){
            item.add(i);
        }
        Collections.shuffle(item);
        System.out.println(item);

        List<Integer> it=item.subList(5,10);
        System.out.println("6 to 10 element is "+it);
        Collections.sort(it);
        System.out.println("sorted result: "+it);

        Collections.sort(it,Collections.reverseOrder());
        System.out.println("the reverse result is "+it);

    }
}
