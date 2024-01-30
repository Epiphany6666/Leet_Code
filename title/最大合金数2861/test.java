package title.最大合金数2861;

import java.util.Collections;
import java.util.List;

// 全部转成 int[] 数组，效率比 List<Integer> 更高
//class Solution {
//    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> Stock, List<Integer> Cost) {
//        int ans = 0, mx = Collections.min(Stock) + budget;
//        int[] stock = Stock.stream().mapToInt(i -> i).toArray();
//        int[] cost = Cost.stream().mapToInt(i -> i).toArray();
//        for (List<Integer> Comp : composition) {
//            int[] comp = Comp.stream().mapToInt(i -> i).toArray();
//            int left = ans, right = mx;
//            while (left <= right) {
//                int mid = left + ((right - left + 1) >> 1);
//                long money = 0;
//                boolean ok = true;
//                for (int i = 0; i < n; i++) {
//                    if ((long) mid * comp[i] > stock[i]) {
//                        money += ((long) mid * comp[i] - stock[i]) * cost[i];
//                        if (money > budget) {
//                            ok = false;
//                            break;
//                        }
//                    }
//                }
//                if (ok) {
//                    left = mid;
//                } else {
//                    right = mid - 1;
//                }
//            }
//            ans = left;
//        }
//        return ans;
//    }

/**
 * 每次都是二分写错。。。
 */
class Solution {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> Stock, List<Integer> Cost) {
        int ans = 0, mx = Collections.min(Stock) + budget;
        int[] stock = Stock.stream().mapToInt(i -> i).toArray();
        int[] cost = Cost.stream().mapToInt(i -> i).toArray();
        for (List<Integer> Comp : composition) {
            int[] comp = Comp.stream().mapToInt(i -> i).toArray();
            int left = ans, right = mx + 1;
            while (left + 1 < right) {
                int mid = left + ((right - left) >> 1);
                long money = 0;
                boolean ok = true;
                for (int i = 0; i < n; i++) {
                    if ((long) mid * comp[i] > stock[i]) {
                        money += ((long) mid * comp[i] - stock[i]) * cost[i];
                        if (money > budget) {
                            ok = false;
                            break;
                        }
                    }
                }
                if (ok) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            ans = left;
        }
        return ans;
    }
}
