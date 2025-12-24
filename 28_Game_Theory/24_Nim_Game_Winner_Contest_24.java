import java.io.IOException;
import java.util.Scanner;

class NimGameWinnerContest24 {

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
        int n = sc.nextInt(), x = 0;
        for (int i = 0; i < n; i++) x ^= sc.nextInt();
        System.out.println(x == 0 ? "Second" : "First");
    }

}
