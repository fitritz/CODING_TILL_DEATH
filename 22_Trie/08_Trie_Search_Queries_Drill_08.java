import java.io.BufferedInputStream;
import java.io.IOException;

class TrieSearchQueriesDrill08 {

    static class Input {
        private final BufferedInputStream in = new BufferedInputStream(System.in);
        private final byte[] data = new byte[1 << 16];
        private int idx = 0, size = 0;

        private int read() throws IOException {
            if (idx >= size) {
                size = in.read(data);
                idx = 0;
                if (size < 0) return -1;
            }
            return data[idx++];
        }

        int nextInt() throws IOException {
            int c;
            do c = read(); while (c <= 32 && c != -1);
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int x = 0;
            while (c > 32) {
                x = x * 10 + (c - '0');
                c = read();
            }
            return x * sign;
        }

        String next() throws IOException {
            int c;
            do c = read(); while (c <= 32 && c != -1);
            StringBuilder sb = new StringBuilder();
            while (c > 32) {
                sb.append((char) c);
                c = read();
            }
            return sb.toString();
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
        Input in = new Input();
        int n = in.nextInt(), q = in.nextInt();
        T root = new T();
        for (int i = 0; i < n; i++) ins(root, in.next());
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < q; i++) out.append(find(root, in.next()) ? "true" : "false").append('\n');
        System.out.print(out);
    }

}
