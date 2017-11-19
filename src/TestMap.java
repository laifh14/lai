import java.util.*;

public class TestMap {
    public static void main(String[] args){
        Map<String,Integer> map1=new HashMap<>();
        Map<String,Integer> map2=new TreeMap<>();
        map1.put("one",1);
        map1.put("two",2);
        map1.put("three",3);
        map2.put("ok",4);
        map2.put("yes",5);
        System.out.println(map1.size());
        System.out.println(map1.containsKey("two"));
        System.out.println(map2.containsValue(5));
        if(map1.containsKey("three")){
            int i=map1.get("three");
            System.out.println("i= "+i);
        }
        Map<String,Integer> map3=map1;
        map3.putAll(map2);
        System.out.println(map3);
    }
}
