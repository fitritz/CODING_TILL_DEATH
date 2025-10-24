import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class SieveOfEratosthenesInterview13 {

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
        Reader input = new Reader();
        int n = input.nextInt();
        boolean[] p = new boolean[n + 1];
        Arrays.fill(p, true);
        if (n >= 0) p[0] = false;
        if (n >= 1) p[1] = false;
        for (int i = 2; i * i <= n; i++) if (p[i]) for (int j = i * i; j <= n; j += i) p[j] = false;
        StringBuilder out = new StringBuilder();
        for (int i = 2; i <= n; i++) if (p[i]) { if (out.length() > 0) out.append(' '); out.append(i); }
        System.out.println(out);
    }

}
