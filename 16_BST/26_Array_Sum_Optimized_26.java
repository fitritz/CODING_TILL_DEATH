import java.util.Scanner;

class ArraySumOptimized26 {

    static class FastIn {
        private final Scanner sc = new Scanner(System.in);

        int nextInt() {
            return sc.nextInt();
        }

        String next() {
            return sc.next();
        }
    }

    public static void main(String[] args) throws Exception {
        FastIn io = new FastIn();
        int n = io.nextInt();
        long ans = 0;
        for (int i = 0; i < n; i++) ans += io.nextInt();
        System.out.println(ans);
    }

}
