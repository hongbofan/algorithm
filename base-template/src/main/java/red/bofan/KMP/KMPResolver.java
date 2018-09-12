package red.bofan.kmp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by hongbf on 2018/9/12.
 */
public class KMPResolver {


    /**
     * 若当j回溯到-1时代表p[0]与s[i]不相等则双指针向右移动
     * 否则代表让j回溯前一个匹配直到-1
     * @param s 主串
     * @param p 模式串
     * @return s中所有包含p的首字母下标集合
     */
    public static List<Integer> resolve(String s,String p) {
        int[] next = getNext(p);
        int sl = s.length();
        int pl = p.length();
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();
        if (next == null) {
            return result;
        }
        while (i < sl && j < pl) {
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
            if (j == pl) {
                result.add(i - j);
                j = 0;
            }
        }
        return result;
    }

    /**
     * 数组[0]默认-1
     * 若当前前(j)后(i)字符匹配,则i+1的失配下标为j+1
     * 若当前前(j)后(i)字符不匹配,则让j回溯前一个匹配直到-1
     * @param p 用于匹配的模式串
     * @return 失配数组,当p为null或者""返回null
     */
    public static int[] getNext(String p) {
        if (p == null || "".equals(p)) {
            return null;
        }
        int[] next = new int[p.length()];
        int i = 0;
        int j = -1;
        next[i] = j;
        while (i < p.length() - 1) {
            if (j == -1 || p.charAt(i) == p.charAt(j)) {
                next[++i] = ++j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
}
