package red.bofan.kmp;

import java.time.Instant;

/**
 * @author by hongbf on 2018/9/12.
 */
public class KMPTest {
    public static void main(String[] args) {
        Long start = Instant.now().toEpochMilli();
        for (int i = 0;i <= 100000000;i++) {
            String s = "BBC ABCDAB ABCDABCDABDEABCDABCD";
            String p = "ABCDABCD";
            KMPResolver.resolve(s,p)
            //        .forEach(System.out::println)
            ;
        }
        Long end = Instant.now().toEpochMilli();
        System.out.println(end - start);
    }
}
