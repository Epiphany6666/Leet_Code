package title.有相同颜色的相邻元素数目2672;

import java.util.PriorityQueue;

public class test {
}

/**
 * 参考题解：灵茶山艾府
 */
class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int q = queries.length, cnt = 0;
        int[] ans = new int[q], a = new int[n + 2];
        for (int i = 0; i < q; i++) {
            int idx = queries[i][0] + 1, c = queries[i][1];
            if (a[idx] != 0) {
                // note 三目运算符是有优先级的。。。
//                cnt -= (a[idx - 1] == a[idx] ? 1 : 0 + a[idx] == a[idx + 1] ? 1 : 0);
                cnt -= (a[idx - 1] == a[idx] ? 1 : 0) + (a[idx] == a[idx + 1] ? 1 : 0);
            }
            a[idx] = c;
//            cnt += (a[idx - 1] == a[idx] ? 1 : 0 + a[idx] == a[idx + 1] ? 1 : 0);
            cnt += (a[idx - 1] == a[idx] ? 1 : 0) + (a[idx] == a[idx + 1] ? 1 : 0);
            ans[i] = cnt;
        }
        return ans;
    }
}
