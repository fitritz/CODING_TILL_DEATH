import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Arrays;

class LongestUniqueSubstringDrill08 {

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
        TokenReader in = new TokenReader();
        String s = in.next();
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
