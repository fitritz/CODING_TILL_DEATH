import java.util.Scanner;

class KMPStringMatchingPractice02 {

    static class FastIn {
        private final Scanner sc = new Scanner(System.in);

        int nextInt() {
            return sc.nextInt();
        }

        String next() {
            return sc.next();
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
    public static void main(String[] args) throws Exception {
        FastIn sc = new FastIn();
        String t = sc.next(), p = sc.next();
        int[] l = lps(p);
        for(int i=0,j=0;i<t.length();i++){
            while(j>0&&t.charAt(i)!=p.charAt(j)) j=l[j-1];
            if(t.charAt(i)==p.charAt(j)) j++;
            if(j==p.length()){ System.out.println(i-j+1); return; }
        }
        System.out.println(-1);
    }

}
