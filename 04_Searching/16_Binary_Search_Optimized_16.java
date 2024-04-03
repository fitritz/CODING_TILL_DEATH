import java.io.BufferedInputStream;
import java.io.IOException;

class BinarySearchOptimized16 {

    static class TokenReader {
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

    public static void main(String[] args) throws IOException {
        TokenReader reader = new TokenReader();
        int n = reader.nextInt(), t = reader.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = reader.nextInt();
        int l = 0, r = n - 1, ans = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (a[m] == t) { ans = m; break; }
            if (a[m] < t) l = m + 1; else r = m - 1;
        }
        System.out.println(ans);
    }

}
