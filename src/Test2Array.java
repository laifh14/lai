import static java.lang.System.arraycopy;

public class Test2Array {
    public static void main(String[] args){
        int[][] in1={{1,3},{2,5,6},{3,8,9}};
        print(in1);
        int[][] in2=new int[3][];
        arraycopy(in1,0,in2,0,3);
        in2[2][1]=100;
        print(in1);
    }
    private static void  print(int[][] a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

