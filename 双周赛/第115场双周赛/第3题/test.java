package 双周赛.第115场双周赛.第3题;

public class test {
}

class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int p1 = 0, p2 = 0;
        StringBuilder ans = new StringBuilder();
        while (p1 < len1 && p2 < len2) {
            ans.append(word1.charAt(p1++));
            ans.append(word2.charAt(p2++));
        }
        int p = p1 == len1 ? p2 : p1;
        int len = p1 == len1 ? len2 : len1;
        String b = p1 == len1 ? word1 : word2;
        while (p < len) ans.append(b.charAt(p));
        return ans.toString();
    }
}