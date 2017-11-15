import static java.lang.System.exit;

public class TestArgs {
    public static void main(String[] args){
        TestArgs.compute(args);
    }
    private static void compute(String[] args){
        if(args.length!=3){
            System.out.println("input the wrong count of parameter");
            exit(-1);
        }
        double d1=0,d2=0;
        try {
            d1=Double.parseDouble(args[0]);
            d2=Double.parseDouble(args[2]);
        }catch (Exception e){
            System.out.println("input wrong parameter");
            e.printStackTrace();
        }
        double d=0;
        switch (args[1]){
            case "+":
                d=d1+d2;
                break;
            case "-":
                d=d1-d2;
                break;
            case "x":
                d=d1*d2;
                break;
            case "/":
                d=d1/d2;
                break;
            default:
                System.out.println("input wrong operation parameter");
                exit(-1);
        }
        System.out.println("result= "+d);
    }
}
