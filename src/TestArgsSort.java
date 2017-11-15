import static java.lang.System.exit;

public class TestArgsSort {
    public static void main(String[] args){
        if(args.length<1){
            System.out.println("input the wrong count of parameter");
            exit(-1);
        }
        int count=args.length;
        int[] in=new int[count];
        try{
            for (int i=0;i<count;i++)
                in[i]=Integer.parseInt(args[i]);
        }catch (Exception e) {
            System.out.println("input wrong parameter");
            e.printStackTrace();
        }
        print(in);
        sort(in);
        print(in);
    }
    public static void sort(int[] in){
       int temp=0,k=0;
       for(int i=0;i<in.length-1;i++){
           k=i;
           for(int j=i+1;j<=in.length-1;j++){
               if(in[k]>in[j]){
                   k=j;
               }
           }
           if(k!=i){
               temp=in[i];
               in[i]=in[k];
               in[k]=temp;
           }
       }
    }
    public static void print(int[] in){
        for(int i=0;i<in.length;i++){
            System.out.print(in[i]+" ");
        }
        System.out.println();
    }
}
