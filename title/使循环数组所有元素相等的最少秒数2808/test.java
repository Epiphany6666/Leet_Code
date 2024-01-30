package title.使循环数组所有元素相等的最少秒数2808;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
}

class Solution1 {
    public int minimumSeconds(List<Integer> nums) {
        int n = nums.size();
        HashMap<Integer, List<Integer>> numIdxs = new HashMap<>();
        for (int i = 0; i < n; i++) {
            numIdxs.computeIfAbsent(nums.get(i), k -> new ArrayList<>()).add(i);
        }
        int res = n;
        for (List<Integer> indices : numIdxs.values()) {
            indices.add(indices.get(0) + n);
            int needSecond = 0;
            for (int i = 1; i < indices.size(); i++) {
                needSecond = Math.max(needSecond, (indices.get(i) - indices. get(i - 1)) / 2);
            }
            res = Math.min(res, needSecond);
        }
        return res;
    }
}

//method 灵神
class Solution {
    public int minimumSeconds(List<Integer> nums) {
        int n = nums.size();
        Map<Integer, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.computeIfAbsent(nums.get(i), k -> new ArrayList<>()).add(i);
        }
        int ans = n;
        for (List<Integer> p : pos.values()) {
//            int mx = n - (p.get(0) - p.get(p.size() - 1));
            int mx = n - (p.get(p.size() - 1) - p.get(0));
            for (int i = 1; i < p.size(); i++) {
//                mx = Math.max(mx, (p.get(i) - p.get(i - 1)) / 2);
                mx = Math.max(mx, (p.get(i) - p.get(i - 1)));
            }
//            ans = Math.min(ans, mx);
            ans = Math.min(ans, mx / 2);
        }
        return ans;
    }
}