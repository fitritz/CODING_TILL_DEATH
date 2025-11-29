import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class OrientationOfThreePointsContest24 {

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

    static long cross(long x1,long y1,long x2,long y2,long x3,long y3){
        return (x2-x1)*(y3-y1)-(y2-y1)*(x3-x1);
    }
    public static void main(String[] args) throws IOException {
        Reader rd = new Reader();
        long x1=rd.nextInt(),y1=rd.nextInt(),x2=rd.nextInt(),y2=rd.nextInt(),x3=rd.nextInt(),y3=rd.nextInt();
        long c = cross(x1,y1,x2,y2,x3,y3);
        if (c==0) System.out.println("COLLINEAR");
        else if (c>0) System.out.println("COUNTER_CLOCKWISE");
        else System.out.println("CLOCKWISE");
    }

}
