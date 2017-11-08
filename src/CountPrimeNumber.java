public class CountPrimeNumber {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder("2");
        int count = 3;
        while (count <= 100) {
            boolean f = true;
            for (int i = 2; i < count; i++) {
                if (count % i == 0) {
                    f=false;
                    break;
                }
            }
            if (f) result.append(",").append(count);
            count++;
        }
        System.out.println(result);
    }
}
