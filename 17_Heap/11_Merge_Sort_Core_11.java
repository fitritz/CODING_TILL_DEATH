import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class MergeSortCore11 {

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

    static void ms(int[] a, int l, int r, int[] tmp) {
        if (l >= r) return;
        int m = (l + r) >>> 1;
        ms(a, l, m, tmp); ms(a, m + 1, r, tmp);
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) tmp[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        while (i <= m) tmp[k++] = a[i++];
        while (j <= r) tmp[k++] = a[j++];
        for (i = l; i <= r; i++) a[i] = tmp[i];
    }
    public static void main(String[] args) throws IOException {
        QuickReader rd = new QuickReader();
        int n = rd.nextInt();
        int[] a = new int[n], t = new int[n];
        for (int i = 0; i < n; i++) a[i] = rd.nextInt();
        ms(a, 0, n - 1, t);
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) { if (i > 0) out.append(' '); out.append(a[i]); }
        System.out.println(out);
    }

}
