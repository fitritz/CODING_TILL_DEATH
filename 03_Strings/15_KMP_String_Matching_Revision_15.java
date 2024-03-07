import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class KMPStringMatchingRevision15 {

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
        QuickReader rd = new QuickReader();
        String t = rd.next(), p = rd.next();
        int[] l = lps(p);
        for(int i=0,j=0;i<t.length();i++){
            while(j>0&&t.charAt(i)!=p.charAt(j)) j=l[j-1];
            if(t.charAt(i)==p.charAt(j)) j++;
            if(j==p.length()){ System.out.println(i-j+1); return; }
        }
        System.out.println(-1);
    }

}
