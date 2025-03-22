import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class BFSShortestPathRevision05 {

    static class Reader {
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
        Reader input = new Reader();
        int n = input.nextInt(), m = input.nextInt(), src = input.nextInt(), dst = input.nextInt();
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
        for (int i = 0; i < m; i++) { int u = input.nextInt(), v = input.nextInt(); g.get(u).add(v); g.get(v).add(u); }
        int[] d = new int[n + 1];
        Arrays.fill(d, -1);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        d[src] = 0; q.offer(src);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g.get(u)) if (d[v] == -1) { d[v] = d[u] + 1; q.offer(v); }
        }
        System.out.println(d[dst]);
    }

}
