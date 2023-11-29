package title.确定两个字符串是否接近1657;

import java.util.Arrays;

public class test {
}

/*
class Solution {
    public boolean closeStrings(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m != n) return false;
        boolean[] w2 = new boolean[26];
        for (char c : word2.toCharArray()) {
            w2[c - 'a'] = true;
        }
        for (char c : word1.toCharArray()) {
            if (!w2[c - 'a']) return false;
        }
        return true;
    }
}*/

class Solution {
    public boolean closeStrings(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m != n) return false;
        int[] w2 = new int[26];
        int[] w1 = new int[26];
        for (int i = 0; i < m; i++) {
            w1[word1.charAt(i) - 'a']++;
            w2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (w1[i] != 0 && w2[i] == 0) return false;
            if (w2[i] != 0 && w1[i] == 0) return false;
        }
        //mind 感觉自己真的好蠢。。。
        Arrays.sort(w1);
        Arrays.sort(w2);
        for (int i = 0; i < n; i++) {
            if (w1[i] != w2[i]) return false;
        }
        return true;
    }
}