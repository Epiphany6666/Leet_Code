package title.反转字符串中的元音字母345;

import java.util.Arrays;
import java.util.HashSet;

public class test {
}

class Solution {
    public String reverseVowels(String s) {
        // note 无语了，忘记考虑大写字母了，wa了一次，，
//        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        HashSet<Character> set = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
        int n = s.length();
        int l = 0, r = n - 1;
        char[] charArray = s.toCharArray();
        while (l < r) {
            while (l < r && !set.contains(charArray[l])) l++;
            while (l < r && !set.contains(charArray[r])) r--;
            char t = charArray[l];
            charArray[l] = charArray[r];
            charArray[r] = t;
            r--;
            l++;
        }
        return new String(charArray);
    }
}