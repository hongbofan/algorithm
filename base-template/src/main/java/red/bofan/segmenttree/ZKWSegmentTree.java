package red.bofan.segmenttree;

import java.util.List;

/**
 * @author by hongbf on 2018/9/26.
 */
public class ZKWSegmentTree {

    private int[] nodes;
    private int t = 1;

    public ZKWSegmentTree() {
    }

    public void build(List<Integer> list) {
        int n = list.size();
        while (t < n) {
            t <<= 1;
        }
        nodes = new int[t + n];
        for (int i = t; i < t + n; i++) {
            nodes[i] = list.get(i - t);
        }
        //区间求和 或者最大值最小值...
        for (int i = t - 1; i > 0; i--) {
            nodes[i] = nodes[i << 1] + nodes[i << 1 | 1];
        }

    }

    public void change(int index, int value) {
        nodes[index = t + index - 1] = value;
        while ((index >>= 1) > 0) {
            nodes[index] = nodes[index << 1] + nodes[index << 1 | 1];
        }
    }

    public int query(int l, int r) {
        int ans = -1;
        for (l += t - 1, r += t + 1; (l ^ r ^ 1) != 0; l >>= 1, r >>= 1) {
            if ((~l & 1) == 0) {
                ans = Math.max(ans, nodes[l ^ 1]);
            }
            if ((r & 1) == 0) {
                ans = Math.max(ans, nodes[r ^ 1]);
            }
        }
        return ans;
    }
}
