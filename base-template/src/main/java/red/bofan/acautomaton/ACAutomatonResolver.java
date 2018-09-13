package red.bofan.acautomaton;

import java.util.List;

/**
 * @author by hongbf on 2018/9/13.
 */
public class ACAutomatonResolver {
    private static TrieTree trieTree = new TrieTree();

    public static void add(String word) {
        trieTree.add(word);
    }
    public static void build() {
        trieTree.buildFail();
    }
    public static List<String> containsList(String target) {
        return trieTree.containsList(target);
    }
}
