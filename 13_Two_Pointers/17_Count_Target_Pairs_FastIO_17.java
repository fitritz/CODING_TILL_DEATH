import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

class CountTargetPairsFastIO17 {

    static class In {
        private final InputStream in;
        private final byte[] buf = new byte[1 << 15];
        private int ptr = 0, len = 0;

        In(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buf);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buf[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do c = read(); while (c <= 32 && c != -1);
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = 0;
            while (c > 32) {
                val = val * 10 + c - '0';
                c = read();
            }
            return val * sign;
        }

        String next() throws IOException {
            int c;
            do c = read(); while (c <= 32 && c != -1);
            StringBuilder s = new StringBuilder();
            while (c > 32) {
                s.append((char) c);
                c = read();
            }
            return s.toString();
        }
    }

    public static void main(String[] args) throws Exception {
        In fs = new In(System.in);
        int n = fs.nextInt(), target = fs.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = fs.nextInt();
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
