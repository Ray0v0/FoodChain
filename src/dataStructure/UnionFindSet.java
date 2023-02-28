package dataStructure;

import java.util.ArrayList;
import java.util.HashMap;

public class UnionFindSet {
    int size = 0;
    ArrayList<Integer> par = new ArrayList<>(); // store parent
    HashMap<Integer, Integer> rank = new HashMap<>(); // store the rank of a tree

    // initializing the UnionFindSet with n individuals
    public void init(int n) {
        this.size = n;
        for (int i = 0; i < n; i++){
            par.add(i);
            rank.put(i, i);
        }
    }

    // find x's ancestor
    public int find(int x) {
        if (par.get(x) == x) {
            return x;
        } else {
            par.set(x, find(par.get(x)));
            return par.get(x);
        }
    }

    // unite two trees x and y
    public void unite(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return ;
        }
        // always unite the small one under the big one to prevent degeneration
        if (rank.get(x) < rank.get(y)) {
            par.set(x, y);
            rank.remove(x);
        } else {
            par.set(y, x);
            rank.remove(y);
            if (rank.get(x).equals(rank.get(y))) {
                int rankTemp = rank.get(x);
                rank.remove(x);
                rank.put(x, rankTemp+1);
            }
        }
    }

    // print the relationship
    public void print() {
        System.out.println("This is the begin of print.");
        for (int i = 0; i < size; i++) {
            System.out.printf("Element %d\t is with element %d\t\n", i, find(i));
        }
        System.out.println("This is the end of print.");
    }

    // judge whether x and y come from the same tree
    public boolean isSame(int x, int y) {
        return find(x) == find(y);
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
