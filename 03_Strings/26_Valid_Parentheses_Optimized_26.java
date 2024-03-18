import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayDeque;

class ValidParenthesesOptimized26 {

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

    static boolean ok(char a, char b) {
        return (a=='('&&b==')')||(a=='['&&b==']')||(a=='{'&&b=='}');
    }
    public static void main(String[] args) throws IOException {
        Scan reader = new Scan();
        String s = reader.next();
        ArrayDeque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='('||c=='['||c=='{') st.push(c);
            else if (st.isEmpty() || !ok(st.pop(), c)) { System.out.println("false"); return; }
        }
        System.out.println(st.isEmpty() ? "true" : "false");
    }

}
