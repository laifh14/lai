import java.util.*;

public class TestTreeSet {
    public static void main(String[] args){
        SortedSet<Item> treeItemdefault=new TreeSet<>();
        treeItemdefault.add(new Item("xiao",1));
        treeItemdefault.add(new Item("da",2));
        treeItemdefault.add(new Item("ming",3));
        System.out.println("默认顺序： "+treeItemdefault);

        ItemComparator itemComparator=new ItemComparator();
        SortedSet<Item> treeItemSelfDef=new TreeSet<>(itemComparator);
        treeItemSelfDef.addAll(treeItemdefault);
        System.out.println("自定义顺序： "+treeItemSelfDef);

    }
}
class ItemComparator implements Comparator<Item>{
    @Override
    public int compare(Item o1, Item o2) {
        return o1.getNum()-o2.getNum();
    }
}
class Item implements Comparable<Item>{
    private String description;
    private int num;

    public Item(String des,int n){
        description=des;
        num=n;
    }

    public String getDescription() {
        return description;
    }

    public int getNum() {
        return num;
    }

    @Override
    public int compareTo(Item o) {
        return description.compareTo(o.getDescription());
    }

    @Override
    public String toString(){
        return "("+description+","+num+")";
    }
}