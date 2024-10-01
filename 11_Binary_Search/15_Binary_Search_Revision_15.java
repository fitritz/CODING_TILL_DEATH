import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BinarySearchRevision15 {

    static class DataIn {
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

    public static void main(String[] args) throws Exception {
        DataIn rd = new DataIn();
        int n = rd.nextInt(), t = rd.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = rd.nextInt();
        int l = 0, r = n - 1, ans = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (a[m] == t) { ans = m; break; }
            if (a[m] < t) l = m + 1; else r = m - 1;
        }
        System.out.println(ans);
    }

}
