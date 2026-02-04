import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class TreeDiameterOptimized16 {

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

    static List<List<Integer>> g;
    static int far, dist;
    static void dfs(int u, int p, int d){
        if(d>dist){ dist=d; far=u; }
        for(int v:g.get(u)) if(v!=p) dfs(v,u,d+1);
    }
    public static void main(String[] args) throws IOException {
        TokenReader reader = new TokenReader();
        int n = reader.nextInt();
        g = new ArrayList<>();
        for(int i=0;i<=n;i++) g.add(new ArrayList<>());
        for(int i=0;i<n-1;i++){ int u=reader.nextInt(),v=reader.nextInt(); g.get(u).add(v); g.get(v).add(u); }
        far=1; dist=-1; dfs(1,0,0); dist=-1; dfs(far,0,0);
        System.out.println(dist);
    }

}
