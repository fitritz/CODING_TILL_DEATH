import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class TreeDiameterInterview13 {

    static class QuickReader {
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

    static List<List<Integer>> g;
    static int far, dist;
    static void dfs(int u, int p, int d){
        if(d>dist){ dist=d; far=u; }
        for(int v:g.get(u)) if(v!=p) dfs(v,u,d+1);
    }
    public static void main(String[] args) throws IOException {
        QuickReader rd = new QuickReader();
        int n = rd.nextInt();
        g = new ArrayList<>();
        for(int i=0;i<=n;i++) g.add(new ArrayList<>());
        for(int i=0;i<n-1;i++){ int u=rd.nextInt(),v=rd.nextInt(); g.get(u).add(v); g.get(v).add(u); }
        far=1; dist=-1; dfs(1,0,0); dist=-1; dfs(far,0,0);
        System.out.println(dist);
    }

}
