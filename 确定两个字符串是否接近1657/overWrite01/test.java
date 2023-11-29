package 确定两个字符串是否接近1657;

import java.util.Arrays;

public class test {
}

/*
class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            cnt1[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            cnt2[word2.charAt(i) - 'a']++;
        }
        Arrays.sort(cnt1);
        Arrays.sort(cnt2);
    }
}*/

/**
 * 时隔一个多月再来做这道题，还是不会做。。。
 */
class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] c1 = new int[26], c2 = new int[26];
        for (char c : word1.toCharArray()) c1[c - 'a']++;
        for (char c : word2.toCharArray()) c2[c - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (c1[i] + c2[i] == 0) continue;
            if (c1[i] == 0 || c2[i] == 0) return false;
        }
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) return false;
        }
        return true;
    }
}