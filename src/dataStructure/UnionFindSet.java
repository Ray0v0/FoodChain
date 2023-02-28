package dataStructure;

import java.util.ArrayList;
import java.util.HashMap;

public class UnionFindSet {
    ArrayList<Integer> par = new ArrayList<>();
    HashMap<Integer, Integer> rank = new HashMap<>();
    public void init(int n) {
        for (int i = 0; i < n; i++){
            par.set(i, i);
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
}
