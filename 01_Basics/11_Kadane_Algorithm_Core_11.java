import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class KadaneAlgorithmCore11 {

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
        int n = rd.nextInt();
        long best = Long.MIN_VALUE, cur = 0;
        for (int i = 0; i < n; i++) {
            long x = rd.nextInt();
            cur = Math.max(x, cur + x);
            best = Math.max(best, cur);
        }
        System.out.println(best);
    }

}
