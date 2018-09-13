package red.bofan.acautomaton;

/**
 * @author by hongbf on 2018/9/13.
 */
public class ACNode {
    private boolean isRed;
    private ACNode[] kids = new ACNode[26];
    private ACNode fail;

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean red) {
        isRed = red;
    }

    public ACNode[] getKids() {
        return kids;
    }

    public void setKids(ACNode[] kids) {
        this.kids = kids;
    }

    public ACNode getFail() {
        return fail;
    }

    public void setFail(ACNode fail) {
        this.fail = fail;
    }
}
