import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class TreeDiameterCore21 {

    static class FastScanner {
        private final InputStream in;
        private final byte[] buf = new byte[1 << 15];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
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

    static List<List<Integer>> g;
    static int far, dist;
    static void dfs(int u, int p, int d){
        if(d>dist){ dist=d; far=u; }
        for(int v:g.get(u)) if(v!=p) dfs(v,u,d+1);
    }
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        g = new ArrayList<>();
        for(int i=0;i<=n;i++) g.add(new ArrayList<>());
        for(int i=0;i<n-1;i++){ int u=fs.nextInt(),v=fs.nextInt(); g.get(u).add(v); g.get(v).add(u); }
        far=1; dist=-1; dfs(1,0,0); dist=-1; dfs(far,0,0);
        System.out.println(dist);
    }

}
