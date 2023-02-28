import java.util.Scanner;
import dataStructure.UnionFindSet;
public class Main {
    static int n, k;
    public static boolean illegal(int x) {
        return x < 0 || x >= n;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        UnionFindSet s = new UnionFindSet();
        s.init(3*n); //  0 ~ n-1, n ~ 2n-1, 2n ~ 3n-1 represent A, B, C respectively

        int count = 0;
        for (int i = 0; i < k; i++) {
            int t = in.nextInt(); // type of information i
            int x = in.nextInt()-1; // animal x
            int y = in.nextInt()-1; // animal y

            if  (illegal(x) || illegal(y)){
                count += 1;
                continue;
            }

            if (t == 1) { // type 1
                if (s.isSame(x, y+n) || s.isSame(x, y+2*n)) { // isSame(x, y+n) means x eats y
                    count += 1;
                } else {
                    s.unite(x, y);
                    s.unite(x+n, y+n);
                    s.unite(x+2*n, y+2*n);
                }
            } else { // type 2
                if (s.isSame(x, y) || s.isSame(x, y+2*n)) {
                    count += 1;
                } else {
                    s.unite(x, y+n);
                    s.unite(x+n, y+2*n);
                    s.unite(x+2*n, y);
                }
            }
        }
        System.out.println(count);
    }
}