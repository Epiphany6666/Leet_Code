package title.构造有效字符串的最少插入数2645;

public class test {
}

//method 1：考虑abc的个数
class Solution1 {
    public int addMinimum(String word) {
        int t = 1;
        int n = word.length();
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) <= word.charAt(i - 1)) t++;
        }
        return 3 * t - n;
    }
}

class Solution2 {
    public int addMinimum(String word) {
        char[] s = word.toCharArray();
        int t = 1;
        for (int i = 1; i < s.length; i++) {
            if (s[i] <= s[i - 1]) t++;
        }
        return t * 3 - s.length;
    }
}

//method 2：考虑相邻字母
class Solution {
    public int addMinimum(String word) {
        int n = word.length();
        int ans = word.charAt(0) - word.charAt(n - 1) + 2;
        for (int i = 1; i < n - 1; i++) {
            ans += (word.charAt(i) - word.charAt(i - 1) + 2) % 3;
        }
        return ans;
    }
}