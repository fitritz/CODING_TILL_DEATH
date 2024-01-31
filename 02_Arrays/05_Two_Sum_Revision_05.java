import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class TwoSumRevision05 {

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
        int n = input.nextInt(), target = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = input.nextInt();
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int need = target - a[i];
            if (mp.containsKey(need)) { System.out.println(mp.get(need) + " " + i); return; }
            mp.putIfAbsent(a[i], i);
        }
        System.out.println("-1 -1");
    }

}
