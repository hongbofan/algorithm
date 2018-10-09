package red.bofan.disjointset;

/**
 * @author by hongbf on 2018/10/9.
 */
public class DisJointSet {
    private int[] parents;

    public DisJointSet(int n) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public boolean union(int x,int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            parents[px] = py;
        }
        return true;
    }

    public int find(int index) {
        if (parents[index] != index) {
            return find(parents[index]);
        }
        return index;
    }
    public boolean isConnected(int x,int y) {
        return find(x) == find(y);
    }
}
