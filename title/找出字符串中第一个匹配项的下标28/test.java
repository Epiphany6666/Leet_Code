package Leet_Code.title.找出字符串中第一个匹配项的下标28;

public class test {
}

//method 1：三叶的做法
class Solution {
    public int strStr(String ss, String pp) {
        int m = ss.length(), n = pp.length();
        char[] s = ss.toCharArray(), p = pp.toCharArray();
        //note 这里的边界条件要好好想想，它是从当前字符开始匹配的
//        for (int i = 0; i < m; i++) {
        for (int i = 0; i < m - n + 1; i++) {
            int a = i, b = 0;
            while (b < n && s[a] == p[b]) {
                a++;
                b++;
            }
            if (b == n) return i;
        }
        return -1;
    }
}

//method 1：暴力
class Solution2 {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n && (i + j) < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
                if (j == n - 1) return i;
            }
        }
        return -1;
    }
}

//method 1：三叶的做法
class Solution3 {
    public int strStr(String ss, String pp) {
        int m = ss.length(), n = pp.length();
        char[] s = ss.toCharArray(), p = pp.toCharArray();
        //note 这里的边界条件要好好想想，它是从当前字符开始匹配的
//        for (int i = 0; i < m; i++) {
        for (int i = 0; i < m - n + 1; i++) {
            int a = i, b = 0;
            while (b < n && s[a] == p[b]) {
                a++;
                b++;
            }
            if (b == n) return i;
        }
        return -1;
    }
}

/**
 * 当且仅当 length（） 为 0 时
 */
//method 2：KMP
class Solution4 {
    public int strStr(String ss, String pp) {
        if (pp.isEmpty()) return 0;

        int n = ss.length(), m = pp.length();
        ss = " " + ss;
        pp = " " + pp;

        char[] s = ss.toCharArray(), p = pp.toCharArray();
        int[] next = new int[m + 1];

        for (int i = 2, j = 0; i <= m; i++) {
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            if (p[i] == p[j + 1]) j++;
            next[i] = j;
        }

//        for (int i = 1, j = 0; i < n; i++) {
        for (int i = 1, j = 0; i <= n; i++) {
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            if (s[i] == p[j + 1]) j++;
            if (j == m) return i - m;
        }
        return -1;
    }
}