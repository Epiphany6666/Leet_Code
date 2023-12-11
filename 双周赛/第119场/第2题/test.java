package 双周赛.第119场.第2题;

public class test {
}

class Solution2 {
    public int removeAlmostEqualCharacters(String word) {
        int n = word.length();
        int ans = 0;
        for (int i = 1; i < n; i++) {
            int a = word.charAt(i - 1), b = word.charAt(i);
            if (Math.abs(a - b) <= 1) ans++;
        }
        return ans;
    }
}