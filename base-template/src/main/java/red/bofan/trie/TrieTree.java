package red.bofan.trie;

/**
 * @author by hongbf on 2018/9/12.
 */
public class TrieTree {
    private TrieNode root;

    public TrieTree() {
        this.root = new TrieNode();
    }

    public void add(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode father = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            TrieNode child = father.getKids()[idx];
            if (child == null) {
                child = new TrieNode();
                father.getKids()[idx] = child;
            }
            father = child;
            father.setCount(father.getCount() + 1);
        }
        father.setRed(true);
    }

    public boolean contains(String target) {
        if (target == null || target.length() == 0) {
            return false;
        }
        TrieNode father = root;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            int idx = c - 'a';
            if (father.getKids()[idx] == null) {
                return false;
            }
            father = father.getKids()[idx];
        }
        return true;
    }
}
