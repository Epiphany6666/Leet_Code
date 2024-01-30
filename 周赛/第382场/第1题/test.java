package 周赛.第382场.第1题;

public class test {
}

class Solution {
    public int countKeyChanges(String s) {
        s = s.toUpperCase();
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) ans++;
        }
        return ans;
    }
}