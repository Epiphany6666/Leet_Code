package title.统计范围内的元音字符串数2586;

import java.util.Arrays;
import java.util.HashSet;

public class test {
}

/*
class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int ans = 0;
        for (int i = left; i <= right; i++) {
            if (set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(words[i].length() - 1))) ans++;
        }
        return ans;
    }
}*/

//method 2：使用字符串来存储元音
class Solution {
    private static final String VOWEL = "aeiou";

    public int vowelStrings(String[] words, int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            if (VOWEL.indexOf(words[i].charAt(0)) != -1 &&
                VOWEL.indexOf(words[i].charAt(words[i].length() - 1)) != -1)
                ans++;
        }
        return ans;
    }
}