import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class LongestUniqueSubstringCore01 {

    static class Reader {
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
        Reader rd = new Reader();
        String s = rd.next();
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
