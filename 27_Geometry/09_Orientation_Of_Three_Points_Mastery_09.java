import java.io.IOException;
import java.util.Scanner;

class OrientationOfThreePointsMastery09 {

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
        IO sc = new IO();
        long x1=sc.nextInt(),y1=sc.nextInt(),x2=sc.nextInt(),y2=sc.nextInt(),x3=sc.nextInt(),y3=sc.nextInt();
        long c = cross(x1,y1,x2,y2,x3,y3);
        if (c==0) System.out.println("COLLINEAR");
        else if (c>0) System.out.println("COUNTER_CLOCKWISE");
        else System.out.println("CLOCKWISE");
    }

}
