public class TestFlagBreakContinue {
    public static void main(String[] args){
        outer:
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if (j==3) continue outer;
//                if(j==3) break outer;
                System.out.println("i="+i+", j="+j);
            }
        }
    }
}
