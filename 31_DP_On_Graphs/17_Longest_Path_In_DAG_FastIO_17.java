import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class LongestPathInDAGFastIO17 {

    static class IO {
        private final Scanner sc = new Scanner(System.in);

        int nextInt() {
            return sc.nextInt();
        }

        String next() {
            return sc.next();
        }
    }

    public static void main(String[] args) throws IOException {
        IO io = new IO();
        int n = io.nextInt(), m = io.nextInt();
        List<List<Integer>> g = new ArrayList<>();
        for(int i=0;i<=n;i++) g.add(new ArrayList<>());
        int[] in = new int[n+1], dp = new int[n+1];
        for(int i=0;i<m;i++){ int u=io.nextInt(), v=io.nextInt(); g.get(u).add(v); in[v]++; }
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
