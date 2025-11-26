import java.io.IOException;
import java.util.Scanner;

class OrientationOfThreePointsCore21 {

    static class IO {
        private final Scanner sc = new Scanner(System.in);

        int nextInt() {
            return sc.nextInt();
        }

        String next() {
            return sc.next();
        }
    }

    static long cross(long x1,long y1,long x2,long y2,long x3,long y3){
        return (x2-x1)*(y3-y1)-(y2-y1)*(x3-x1);
    }
    public static void main(String[] args) throws IOException {
        IO io = new IO();
        long x1=io.nextInt(),y1=io.nextInt(),x2=io.nextInt(),y2=io.nextInt(),x3=io.nextInt(),y3=io.nextInt();
        long c = cross(x1,y1,x2,y2,x3,y3);
        if (c==0) System.out.println("COLLINEAR");
        else if (c>0) System.out.println("COUNTER_CLOCKWISE");
        else System.out.println("CLOCKWISE");
    }

}
