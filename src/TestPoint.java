public class TestPoint {

    public static void main(String[] args){
        Point point1=new Point(1,2,3);
        Point point2=new Point(3);
        Point point3=new Point();
        System.out.println("point1"+point1.displayPoint());
        System.out.println("point2"+point2.displayPoint());
        System.out.println("point3"+point3.displayPoint());//成员变量不定义，系统会给默认值
    }
}
class Point{
    private double x;
    private double y;
    private double z;

    Point(double _x,double _y,double _z){
        x=_x;
        y=_y;
        z=_z;
    }

    Point(double _x){
        x=_x;
    }

    Point(){}                     //功能类似默认构造函数，不写不存在，除非自己没有定义构造函数，系统会给默认构造函数
    String  displayPoint(){
        return ("("+x+","+y+","+z+")");
    }
}