import java.io.IOException;
import java.io.InputStream;

class KMPStringMatchingContest04 {

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

    static int[] lps(String p){
        int n=p.length(); int[] l=new int[n];
        for(int i=1,j=0;i<n;i++){
            while(j>0&&p.charAt(i)!=p.charAt(j)) j=l[j-1];
            if(p.charAt(i)==p.charAt(j)) j++;
            l[i]=j;
        }
        return l;
    }
    public static void main(String[] args) throws IOException {
        InputFast fs = new InputFast(System.in);
        String t = fs.next(), p = fs.next();
        int[] l = lps(p);
        for(int i=0,j=0;i<t.length();i++){
            while(j>0&&t.charAt(i)!=p.charAt(j)) j=l[j-1];
            if(t.charAt(i)==p.charAt(j)) j++;
            if(j==p.length()){ System.out.println(i-j+1); return; }
        }
        System.out.println(-1);
    }

}
