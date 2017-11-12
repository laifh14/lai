public class TestCirclePoint {
    public static void main(String[] args){
        Point2 point=new Point2(2.0,3.0);
        Circle circle=new Circle(new Point2(0.0,0.0),5.0);
        System.out.println("点point在圆o里面："+circle.contains(point));


    }
}
class Point2{
    private double x;
    private double y;
//    Point2(){};
    Point2(double x,double y){
        this.x=x;
        this.y=y;
    }
 /*   public void setX(double _x){
        x=_x;
    }
    public void setY(double _y){
        y=_y;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }      */
    double computeDistanceSquares(Point2 p){
        return (this.x-p.x)*(this.x-p.x)+(this.y-p.y)*(this.y-p.y);
    }
}
class Circle{
    private Point2 o;
    private double r;
//    Circle(){};
    Circle(Point2 p,double r){
        o=p;
        this.r=r;
    }
    public boolean contains(Point2 p){
        return o.computeDistanceSquares(p)<=(r*r);
    }
}
