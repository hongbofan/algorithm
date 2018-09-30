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
        while (t < n + 2) {
            t <<= 1;
        }
        //TODO
        nodes = new int[100000];
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

    /**
     * 先将 l r 闭合区间 赋值为线段树的开区间
     * ~l & 1 != 0 等价于 l % 2 == 0 等价于 判断区间l 是否为偶数 等价于 判断区间l 是否为左儿子
     * 同理 r & 1 != 0
     * 取左端是左儿子的右兄弟 取右端是右儿子的左兄弟 作为目标节点
     * @param l 左区间(下标0开始)
     * @param r 右区间(下标0开始)
     * @return
     */
    public int query(int l, int r) {
        int ans = 0;
        for (l += t - 1, r += t + 1; (l ^ r ^ 1) != 0; l >>= 1, r >>= 1) {
            if ((~l & 1) != 0) {
                ans += nodes[l ^ 1];
            }
            if ((r & 1) != 0) {
                ans += nodes[r ^ 1];
            }
        }
        return ans;
    }
}
