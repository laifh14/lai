public class TestSwitch {
    public static void main(String[] args){
        int a=1,b=2;
        int choice=a^b;
        switch(choice){
            case 0:
                System.out.println("A");
                break;
            case 1:
                System.out.println("hello:"+(a>b?1:2));
                break;
            case 2:
            case 3:
            case 4:
                System.out.println("三个case");//多个结果一样可以合并表示
                break;                         //不要丢了break，否则程序会继续往下执行
            default:                           //最后记得加default情况，保证程序健壮性
                System.out.println("剩余情况");
        }
    }
}
