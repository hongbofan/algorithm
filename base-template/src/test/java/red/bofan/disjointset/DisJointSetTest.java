package red.bofan.disjointset;

/**
 * @author by hongbf on 2018/10/9.
 */
public class DisJointSetTest {
    public static void main(String[] args) {
        DisJointResolver.build(3);
        System.out.println(DisJointResolver.find(1));
        DisJointResolver.union(1,2);
        System.out.println(DisJointResolver.find(1));
        DisJointResolver.union(0,2);
        System.out.println(DisJointResolver.find(0));
        System.out.println(DisJointResolver.isConnected(0,1));
    }
}
