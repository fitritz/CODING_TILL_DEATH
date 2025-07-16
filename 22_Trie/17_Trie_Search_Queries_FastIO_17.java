import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class TrieSearchQueriesFastIO17 {

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

    static class T { T[] nx = new T[26]; boolean e; }
    static void ins(T r, String s) {
        T c = r;
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            if (c.nx[x] == null) c.nx[x] = new T();
            c = c.nx[x];
        }
        c.e = true;
    }
    static boolean find(T r, String s) {
        T c = r;
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            if (x < 0 || x > 25 || c.nx[x] == null) return false;
            c = c.nx[x];
        }
        return c.e;
    }
    public static void main(String[] args) throws Exception {
        DataIn rd = new DataIn();
        int n = rd.nextInt(), q = rd.nextInt();
        T root = new T();
        for (int i = 0; i < n; i++) ins(root, rd.next());
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < q; i++) out.append(find(root, rd.next()) ? "true" : "false").append('\n');
        System.out.print(out);
    }

}
