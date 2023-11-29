package 定长子串中元音的最大数目1456;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 用hash：22ms
 * 不用hash：11ms
 * 。。。。
 */

public class test {
}
/*class Solution {
    public int maxVowels(String s, int k) {
        int l = 0, n = s.length(), count = 0, ans = 0;
        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for (int i = 0; i < k && i < n; i++) {
            if (set.contains(s.charAt(i))) count++;
        }
        if (n < k) return count;
        ans = count;
        for (int r = k; r < n; r++, l++) {
            count -= set.contains(s.charAt(l)) ? 1 :0;
            count += set.contains(s.charAt(r)) ? 1 : 0;
            ans = Math.max(ans, count);
        }
        return ans;
    }
}*/

//官解做法
class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < k; i++) {
            count += isVowel(s.charAt(i));
        }

        int ans = count;
        for (int i = k; i < n; i++) {
            count += (isVowel(s.charAt(i)) - isVowel(s.charAt(i - k)));
            ans = Math.max(ans, count);
        }
        return ans;
    }

    private int isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ? 1 : 0;
    }
}