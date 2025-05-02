import java.util.Arrays;
import java.util.Scanner;

class LongestUniqueSubstringCheckpoint20 {

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
        String s = io.next();
        int[] last = new int[256];
        Arrays.fill(last, -1);
        int l = 0, ans = 0;
        for (int r = 0; r < s.length(); r++) {
            int c = s.charAt(r);
            if (last[c] >= l) l = last[c] + 1;
            last[c] = r;
            ans = Math.max(ans, r - l + 1);
        }
        System.out.println(ans);
    }

}
