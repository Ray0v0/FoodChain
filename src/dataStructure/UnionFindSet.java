package dataStructure;

import java.util.ArrayList;
import java.util.HashMap;

public class UnionFindSet {
    int size = 0;
    ArrayList<Integer> par = new ArrayList<>();
    HashMap<Integer, Integer> rank = new HashMap<>();
    public void init(int n) {
        this.size = n;
        for (int i = 0; i < n; i++){
            par.add(i);
            rank.put(i, i);
        }
    }
    public int find(int x) {
        if (par.get(x) == x) {
            return x;
        } else {
            par.set(x, find(par.get(x)));
            return par.get(x);
        }
    }
    public void unite(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return ;
        }
        if (rank.get(x) < rank.get(y)) {
            par.set(x, y);
        } else {
            par.set(y, x);
            if (rank.get(x).equals(rank.get(y))) {
                int rankTemp = rank.get(x);
                rank.remove(x);
                rank.put(x, rankTemp+1);
            }
        }
    }
    public void print() {
        System.out.println("This is the begin of print.");
        for (int i = 0; i < size; i++) {
            System.out.printf("Element %d\t is with element %d\t\n", i, find(i));
        }
        System.out.println("This is the end of print.");
    }
    public static void main(String[] args) {
        UnionFindSet s = new UnionFindSet();
        s.init(5);
        s.print();
        s.unite(1, 3);
        s.unite(2, 3);
        s.print();

    }
}
