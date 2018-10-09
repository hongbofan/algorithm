package red.bofan.disjointset;

/**
 * @author by hongbf on 2018/10/9.
 */
public class DisJointResolver {
    private static DisJointSet disJointSet;
    public static void build(int n ) {
        disJointSet = new DisJointSet(n);
    }
    public static boolean union(int x,int y) {
        return disJointSet.union(x,y);
    }
    public static int find(int index) {
        return disJointSet.find(index);
    }
    public static boolean isConnected(int x,int y) {
        return disJointSet.isConnected(x,y);
    }
}
