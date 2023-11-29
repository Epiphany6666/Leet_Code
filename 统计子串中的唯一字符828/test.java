package title.统计子串中的唯一字符828;

import java.util.Arrays;

public class test {
}

//method 1：模拟 + 乘法原理
class Solution {
    public int uniqueLetterString(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int[] left = new int[len];
        int[] right = new int[len];
        int[] idx = new int[26];
        Arrays.fill(idx, -1);
        for (int i = 0; i < len; i++) {
            int u = chars[i] - 'A';
            left[i] = idx[u];
            idx[u] = i;
        }

        Arrays.fill(idx, len);
        for (int i = len - 1; i >= 0; i--) {
            int u = chars[i] - 'A';
            right[i] = idx[u];
            idx[u] = i;
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += (i - left[i]) * (right[i] - i);
        }
        return ans;
    }
}

//method 2：线性DP
class Solution2 {
    public int uniqueLetterString(String s) {
        int len = s.length();
        int[] a = new int[26], b = new int[26];
        Arrays.fill(a, -1);
//        Arrays.fill(b, len);
        Arrays.fill(b, -1);
        int ans = 0, cur = 0;
        for (int i = 0; i < len; i++) {
            int u = s.charAt(i) - 'A';
            cur += (i - b[u]) - (b[u] - a[u]);
            ans += cur;
//            a[u] = i;
            a[u] = b[u];
            b[u] = i;
        }
        return ans;
    }
}