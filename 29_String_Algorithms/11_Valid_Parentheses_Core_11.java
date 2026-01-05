import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;

class ValidParenthesesCore11 {

    static class Fs {
        private final Scanner sc = new Scanner(System.in);

        int nextInt() {
            return sc.nextInt();
        }

        String next() {
            return sc.next();
        }
    }

    static boolean ok(char a, char b) {
        return (a=='('&&b==')')||(a=='['&&b==']')||(a=='{'&&b=='}');
    }
    public static void main(String[] args) throws IOException {
        Fs io = new Fs();
        String s = io.next();
        ArrayDeque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='('||c=='['||c=='{') st.push(c);
            else if (st.isEmpty() || !ok(st.pop(), c)) { System.out.println("false"); return; }
        }
        System.out.println(st.isEmpty() ? "true" : "false");
    }

}
