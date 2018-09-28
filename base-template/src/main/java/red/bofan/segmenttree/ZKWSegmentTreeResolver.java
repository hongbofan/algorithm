package red.bofan.segmenttree;

import java.util.List;

/**
 * @author by hongbf on 2018/9/26.
 */
public class ZKWSegmentTreeResolver {
    private static ZKWSegmentTree tree = new ZKWSegmentTree();
    public static void build(List<Integer> list) {
        tree.build(list);

    }
    public static void change(int index,int value) {
        tree.change(index,value);
    }
    public static int query(int l,int r) {
        return tree.query(l,r);
    }
}
