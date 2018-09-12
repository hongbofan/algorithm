package red.bofan.trie;

/**
 * @author by hongbf on 2018/9/12.
 */
public class TrieResolver {
    private static TrieTree trieTree = new TrieTree();

    public static void add(String word) {
        trieTree.add(word);
    }

    public static boolean contains(String target) {
        return trieTree.contains(target);
    }
}
