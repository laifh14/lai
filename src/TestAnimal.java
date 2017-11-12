public class TestAnimal {
    public static void main(String[] args){
        Animal cat=new Cat("mi","blue");
        Animal dog=new Dog("wang","yellow");
        cat.enjoy();
        dog.enjoy();
        Cat c=(Cat)cat;
        c.catchs();
        Dog d=(Dog)dog;
        d.swims();
    }
}
class Animal{
    String name;
//    Animal(){}
    Animal(String s){
        name = s;
    }
    public void enjoy(){
        System.out.println("动物叫……");
    }
}
class Cat extends Animal{
    String eyescolor;
 //   Cat(){}
    Cat(String s1,String s2){
        super(s1);
        eyescolor=s2;
    }
    public void enjoy(){
        System.out.println("猫在叫……");
    }
    public void catchs(){
        System.out.println("会抓老鼠");
    }
}
class Dog extends Animal{
    String furcolor;
 //   Dog(){}
    Dog(String s1,String s2){
        super(s1);
        furcolor=s2;
    }
    public void enjoy(){
        System.out.println("狗在叫……");
    }
    public void  swims(){
        System.out.println("会游泳……");
    }
}
