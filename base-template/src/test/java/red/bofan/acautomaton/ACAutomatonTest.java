package red.bofan.acautomaton;

import java.util.Arrays;

/**
 * @author by hongbf on 2018/9/13.
 */
public class ACAutomatonTest {
    public static void main(String[] args) {
        ACAutomatonResolver.add(Arrays.asList("she","shr","say","her"));
        ACAutomatonResolver.build();
        ACAutomatonResolver.containsList("yasherhsshe").stream().forEach(System.out::println);
    }
}
