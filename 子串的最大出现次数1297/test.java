package title.子串的最大出现次数1297;
/**
 * 总结：
 * 1.字母还是使用数组存比较好
 * 2.这题能使用滑动窗口的原因：如果一个子串在字符串中出现了k次，那么这个子串的子串至少也出现了k次，即：只需要关注minSize即可，此时子串的长度就固定了
 *
 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        new Solution().maxFreq("aaaa", 1, 3, 1);
    }
}

class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int l = 0;
        StringBuilder sb = new StringBuilder();
        int[] letter = new int[26];
        Map<String, Integer> map = new HashMap<>();
        int cnt = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (letter[ch - 'a'] == 0) {
                cnt++;
            }
            letter[ch - 'a']++;
//            while (cnt > maxLetters) {
            while (cnt > maxLetters || right - left + 1 > minSize) {//情况没分析到位
                char ch2 = s.charAt(left);
                letter[ch2 - 'a']--;
                left++;
                if (letter[ch2 - 'a'] == 0) cnt--;
            }

//            if (cnt == minSize) {
            if (right - left + 1 == minSize) {
                String str = s.substring(left, right + 1);
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
        int ans = 0;
        Collection<Integer> values = map.values();
        for (Integer value : values) {
            ans = Math.max(ans, value);
        }
        return ans;
    }
}