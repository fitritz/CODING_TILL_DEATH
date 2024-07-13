import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class ReverseArrayInterview13 {

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
        int n = rd.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = rd.nextInt();
        StringBuilder out = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            if (out.length() > 0) out.append(' ');
            out.append(a[i]);
        }
        System.out.println(out);
    }

}
