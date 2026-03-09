import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class LongestPathInDAGContest24 {

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

    public static void main(String[] args) throws IOException {
        QuickReader input = new QuickReader();
        int n = input.nextInt(), m = input.nextInt();
        List<List<Integer>> g = new ArrayList<>();
        for(int i=0;i<=n;i++) g.add(new ArrayList<>());
        int[] in = new int[n+1], dp = new int[n+1];
        for(int i=0;i<m;i++){ int u=input.nextInt(), v=input.nextInt(); g.get(u).add(v); in[v]++; }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=1;i<=n;i++) if(in[i]==0) q.offer(i);
        while(!q.isEmpty()){
            int u=q.poll();
            for(int v:g.get(u)){
                dp[v]=Math.max(dp[v],dp[u]+1);
                if(--in[v]==0) q.offer(v);
            }
        }
        int ans=0; for(int i=1;i<=n;i++) ans=Math.max(ans,dp[i]);
        System.out.println(ans);
    }

}
