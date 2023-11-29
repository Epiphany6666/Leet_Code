package title.无重复字符的最长子串3;

import java.util.HashMap;

public class test {
}

/*
//method 为什么我的滑动窗口做不出
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = Integer.MIN_VALUE;
        int len = s.length();
        int l = 0, r = 1;
        char[] chars = s.toCharArray();
        int cnt = 1;

        while (r < len) {
            while (chars[r] != chars[l]) {
                cnt++;
                r++;
            }
            ans = Math.max(ans, r - l);
            l = r - 1;
        }
        return ans;
    }
}*/

//method
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, ans = 0;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}