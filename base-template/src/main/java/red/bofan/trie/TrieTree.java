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
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            TrieNode child = node.getNodes()[idx];
            if (child == null) {
                child = new TrieNode();
                node.getNodes()[idx] = child;
            }
            node = child;
            node.setCount(node.getCount() + 1);
        }
        node.setRed(true);
    }

    public boolean contains(String target) {
        if (target == null || target.length() == 0) {
            return false;
        }
        TrieNode node = root;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            int idx = c - 'a';
            if (node.getNodes()[idx] == null) {
                return false;
            }
            node = node.getNodes()[idx];
        }
        return true;
    }
}
