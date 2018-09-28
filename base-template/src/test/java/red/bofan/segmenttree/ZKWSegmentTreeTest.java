package red.bofan.segmenttree;

import java.util.Arrays;

/**
 * @author by hongbf on 2018/9/26.
 */
public class ZKWSegmentTreeTest {
    public static void main(String[] args) {
        ZKWSegmentTreeResolver.build(Arrays.asList(1,2,3,4));
        ZKWSegmentTreeResolver.change(4,5);
        System.out.println(ZKWSegmentTreeResolver.query(3,3));
        System.out.println(3 ^ 5);
    }
}
