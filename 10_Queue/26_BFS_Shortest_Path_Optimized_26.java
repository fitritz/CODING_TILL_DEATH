import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class BFSShortestPathOptimized26 {

    static class FastIn {
        private final Scanner sc = new Scanner(System.in);

        int nextInt() {
            return sc.nextInt();
        }

        String next() {
            return sc.next();
        }
    }

    public static void main(String[] args) throws Exception {
        FastIn sc = new FastIn();
        int n = sc.nextInt(), m = sc.nextInt(), src = sc.nextInt(), dst = sc.nextInt();
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
        for (int i = 0; i < m; i++) { int u = sc.nextInt(), v = sc.nextInt(); g.get(u).add(v); g.get(v).add(u); }
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
