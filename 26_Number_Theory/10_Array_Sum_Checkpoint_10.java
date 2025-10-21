import java.io.IOException;
import java.util.Scanner;

class ArraySumCheckpoint10 {

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
        int n = sc.nextInt();
        long ans = 0;
        for (int i = 0; i < n; i++) ans += sc.nextInt();
        System.out.println(ans);
    }

}
