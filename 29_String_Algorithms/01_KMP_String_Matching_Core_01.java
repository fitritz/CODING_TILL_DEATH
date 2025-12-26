import java.io.BufferedInputStream;
import java.io.IOException;

class KMPStringMatchingCore01 {

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
        Scan reader = new Scan();
        String t = reader.next(), p = reader.next();
        int[] l = lps(p);
        for(int i=0,j=0;i<t.length();i++){
            while(j>0&&t.charAt(i)!=p.charAt(j)) j=l[j-1];
            if(t.charAt(i)==p.charAt(j)) j++;
            if(j==p.length()){ System.out.println(i-j+1); return; }
        }
        System.out.println(-1);
    }

}
