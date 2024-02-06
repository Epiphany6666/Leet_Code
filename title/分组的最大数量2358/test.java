package title.分组的最大数量2358;

public class test {
}

class Solution1 {
    public int maximumGroups(int[] grades) {
        int n = grades.length;
        for (int i = n; i >= 0; i--) {
            if (i * (i + 1) <= 2 * n) return i;
        }
        return -1;
    }
}

// note 这题直接不需要排序
class Solution {
    public int maximumGroups(int[] grades) {
        int n = grades.length;
        int ans = 0, p = 0;
        for (int i = 1; i <= n; i++) {
            p += i;
            if (p > n) break;
            ans++;
        }
        return ans;
    }
}