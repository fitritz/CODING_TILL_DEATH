import java.util.Scanner;

class BinarySearchDrill08 {

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
        int n = io.nextInt(), t = io.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = io.nextInt();
        int l = 0, r = n - 1, ans = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (a[m] == t) { ans = m; break; }
            if (a[m] < t) l = m + 1; else r = m - 1;
        }
        System.out.println(ans);
    }

}
