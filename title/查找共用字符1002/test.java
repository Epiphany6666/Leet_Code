package title.查找共用字符1002;

import java.util.*;

public class test {
    public static void main(String[] args) {
        String[] ss = new String[26];
        for (int i = 0; i < 26; i++) {
            ss[i] = (char) (i + 'a') + "";
            System.out.println(ss[i]);
        }
    }
}

// method：自写 写错了。。。
//class Solution {
//    public List<String> commonChars(String[] words) {
//        int[] cnt = new int[26];
//        String[] ss = new String[26];
//        for (int i = 0; i < 26; i++) {
//            ss[i] = (char) (i + 'a') + "";
//        }
//
//        Set<Character> set = new HashSet<>();
//        int n = words.length;
//        for (String word : words) {
//            set.clear();
//            for (char c : word.toCharArray()) {
//                set.add(c);
//            }
//            for (Character c : set) {
//                cnt[c - 'a']++;
//            }
//        }
//        List<String> ans = new ArrayList<>();
//        for (int i = 0; i < 26; i++) {
//            if (cnt[i] == n) {
//                ans.add(ss[i]);
//            }
//        }
//        return ans;
//    }
//}

/**
 * 参考题解：力扣官方题解
 */
// note 可以使用 minfreq[c] 存储字符  c 在所有字符串中出现次数的最小值。
class Solution {
    public List<String> commonChars(String[] words) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);
        for (String word : words) {
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (minFreq[i]-- > 0) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }
}