import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class ValidParenthesesFastIO07 {

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

    static boolean ok(char a, char b) {
        return (a=='('&&b==')')||(a=='['&&b==']')||(a=='{'&&b=='}');
    }
    public static void main(String[] args) throws Exception {
        DataIn input = new DataIn();
        String s = input.next();
        ArrayDeque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='('||c=='['||c=='{') st.push(c);
            else if (st.isEmpty() || !ok(st.pop(), c)) { System.out.println("false"); return; }
        }
        System.out.println(st.isEmpty() ? "true" : "false");
    }

}
