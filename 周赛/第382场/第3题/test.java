package 周赛.第382场.第3题;

import java.util.ArrayList;
import java.util.List;

public class test {
}

class Solution {
    public long flowerGame(int n, int m) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            l1.add(i);
        }
        for (int i = 1; i <= m; i++) {
            l2.add(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (l1.get(i) % 2 == 0 && l2.get(i) % 2 == 1) ans++;
                if (l1.get(i) % 2 == 1 && l2.get(i) % 2 == 0) ans++;
            }
        }
        return ans;
    }
}