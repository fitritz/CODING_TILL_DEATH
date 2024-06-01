import java.io.IOException;
import java.io.InputStream;

class MergeSortInterview23 {

    static class InputFast {
        private final InputStream in;
        private final byte[] buf = new byte[1 << 15];
        private int ptr = 0, len = 0;

        InputFast(InputStream is) {
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

    static void ms(int[] a, int l, int r, int[] tmp) {
        if (l >= r) return;
        int m = (l + r) >>> 1;
        ms(a, l, m, tmp); ms(a, m + 1, r, tmp);
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) tmp[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        while (i <= m) tmp[k++] = a[i++];
        while (j <= r) tmp[k++] = a[j++];
        for (i = l; i <= r; i++) a[i] = tmp[i];
    }
    public static void main(String[] args) throws IOException {
        InputFast fs = new InputFast(System.in);
        int n = fs.nextInt();
        int[] a = new int[n], t = new int[n];
        for (int i = 0; i < n; i++) a[i] = fs.nextInt();
        ms(a, 0, n - 1, t);
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) { if (i > 0) out.append(' '); out.append(a[i]); }
        System.out.println(out);
    }

}
