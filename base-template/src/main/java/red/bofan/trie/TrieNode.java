package red.bofan.trie;

/**
 * @author by hongbf on 2018/9/12.
 */
public class TrieNode {
    private int count;
    private boolean isRed;
    private TrieNode[] kids = new TrieNode[26];

    public TrieNode() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean red) {
        isRed = red;
    }

    public TrieNode[] getKids() {
        return kids;
    }

    public void setKids(TrieNode[] kids) {
        this.kids = kids;
    }
}
