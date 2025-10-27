import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Arrays;

class SieveOfEratosthenesOptimized16 {

    static class Scan {
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
        Scan in = new Scan();
        int n = in.nextInt();
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
