package 双周赛.第116场双周赛.第2题;

public class test {
}

class Solution {
    public int minChanges(String s) {
        int len = s.length(), i = 1, count = 1, ans = 0;
        while (i < len) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                count++;
                i++;
                continue;
            } else {
                if ((count & 1) == 1) {
                    i++;
                    ans++;
                }
                count = 1;
            }
            i++;
        }
        return ans;
    }
}