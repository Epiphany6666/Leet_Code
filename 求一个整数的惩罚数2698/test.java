package title.求一个整数的惩罚数2698;

public class test {
}

class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            String s = Integer.toString(i * i);
            if (dfs(0, 0, s, i)) ans++;
        }
        return ans;
    }

    private boolean dfs(int start, int total, String s, int target) {
        if (start == s.length()) return total == target;
        int sum = 0;
        for (int i = start; i < s.length(); i++) {
            sum = sum * 10 + s.charAt(i) - '0';
            if (sum + total > target) return false;
            if (dfs(i + 1, total + sum, s, target)) return true;
        }
        return false;
    }
}