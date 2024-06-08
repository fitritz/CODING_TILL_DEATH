import java.io.IOException;
import java.util.Scanner;

class NimGameWinnerContest04 {

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
        Fs io = new Fs();
        int n = io.nextInt(), x = 0;
        for (int i = 0; i < n; i++) x ^= io.nextInt();
        System.out.println(x == 0 ? "Second" : "First");
    }

}
