package red.bofan.acautomaton;

/**
 * @author by hongbf on 2018/9/13.
 */
public class ACAutomatonTest {
    public static void main(String[] args) {
        ACAutomatonResolver.add("she");
        ACAutomatonResolver.add("shr");
        ACAutomatonResolver.add("say");
        ACAutomatonResolver.add("her");
        ACAutomatonResolver.build();
        ACAutomatonResolver.containsList("yasherhs").stream().forEach(System.out::println);
    }
}
