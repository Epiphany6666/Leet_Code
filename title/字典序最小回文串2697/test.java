package title.字典序最小回文串2697;

public class test {
}

class Solution1 {
    public String makeSmallestPalindrome(String s) {
        int n = s.length();
        char[] charArray = s.toCharArray();
        int l = 0, r = n - 1;
        while (l < r) {
            if (charArray[l] != charArray[r]) {
                if (charArray[l] > charArray[r]) {
                    charArray[l] = charArray[r];
                } else {
                    charArray[r] = charArray[l];
                }
            }
            l++;
            r--;
        }
        return new String(charArray);
    }
}

// method 简写双指针
class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0, j = cs.length - 1; i < j; i++, j--) {
            cs[i] = cs[j] = (char) Math.min(cs[i], cs[j]);
        }
        return new String(cs);
    }
}