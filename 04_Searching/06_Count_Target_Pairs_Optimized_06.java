import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class CountTargetPairsOptimized06 {

    static class IO {
        private final Scanner sc = new Scanner(System.in);

        int nextInt() {
            return sc.nextInt();
        }

        String next() {
            return sc.next();
        }
    }

    public static void main(String[] args) throws IOException {
        IO sc = new IO();
        int n = sc.nextInt(), target = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        Arrays.sort(a);
        int l = 0, r = n - 1; long ans = 0;
        while (l < r) {
            long s = (long) a[l] + a[r];
            if (s == target) { ans++; l++; r--; }
            else if (s < target) l++; else r--;
        }
        System.out.println(ans);
    }

}
