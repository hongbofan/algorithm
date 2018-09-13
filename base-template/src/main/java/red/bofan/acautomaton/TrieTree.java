package red.bofan.acautomaton;

import red.bofan.trie.TrieNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author by hongbf on 2018/9/13.
 */
public class TrieTree {
    private ACNode root;

    public TrieTree() {
        this.root = new ACNode();
    }

    public void add(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        ACNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            ACNode child = node.getKids()[idx];
            if (child == null) {
                child = new ACNode();
                node.getKids()[idx] = child;
            }
            node = child;
        }
        node.setRed(true);
    }

    public void buildFail() {
        Queue<ACNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ACNode father = queue.poll();
            ACNode[] kids = father.getKids();
            for (int i = 0;i < kids.length;i++) {
                ACNode kid = kids[i];
                if (kid != null) {
                    queue.add(kid);
                    ACNode fail = father.getFail();
                    while (fail != null) {
                        if (fail.getKids()[i] != null) {
                            kid.setFail(fail.getKids()[i]);
                            break;
                        }
                        fail = fail.getFail();
                    }
                    if (fail == null) {
                        kid.setFail(root);
                    }
                }
            }
        }
        System.out.println(root);
    }

    public List<String> containsList(String target) {
        ACNode father = root;
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        for (int i = 0;i < target.length();i++) {
            int idx = target.charAt(i) - 'a';
            ACNode kid = father.getKids()[idx];
            while (kid == null && father != root) {
                father = father.getFail();
                kid = father.getKids()[idx];
            }
            if (kid != null) {
                sb.append(target.charAt(i));
                if (kid.isRed()) {
                    result.add(sb.toString());
                    sb.delete(0,sb.length() - 1);
                }
                father = kid;
            }
        }
        return result;
    }
}
