import java.io.IOException;
import java.util.Scanner;

class ReverseArrayContest04 {

    static class Fs {
        private final Scanner sc = new Scanner(System.in);

        int nextInt() {
            return sc.nextInt();
        }

        String next() {
            return sc.next();
        }
    }

    public static void main(String[] args) throws IOException {
        Fs sc = new Fs();
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        StringBuilder out = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            if (out.length() > 0) out.append(' ');
            out.append(a[i]);
        }
        System.out.println(out);
    }

}
