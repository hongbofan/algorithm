package red.bofan.trie;

import java.time.Instant;

/**
 * @author by hongbf on 2018/9/12.
 */
public class TrieTest {

    public static void main(String[] args) {
        TrieResolver.add("word");
        TrieResolver.add("worb");
        TrieResolver.add("worbwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordword");
        System.out.println(TrieResolver.contains("word"));
        System.out.println(TrieResolver.contains("wora"));

        Long start = Instant.now().toEpochMilli();
        for (int i = 0;i < 100000000;i++) {
            TrieResolver.contains("worbwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordwordword");
        }
        Long end = Instant.now().toEpochMilli();
        System.out.println(end - start);
    }
}
