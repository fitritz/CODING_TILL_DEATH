import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class CountTargetPairsMastery19 {

    static class QuickReader {
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) throws IOException {
        QuickReader input = new QuickReader();
        int n = input.nextInt(), target = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = input.nextInt();
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
