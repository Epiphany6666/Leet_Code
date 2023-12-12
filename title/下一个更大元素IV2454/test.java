package title.下一个更大元素IV2454;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
}

class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        List<Integer> s = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            while (!t.isEmpty() && nums[t.get(t.size() - 1)] < x) {
                ans[t.get(t.size() - 1)] = x;
                t.remove(t.size() - 1);
            }
            int j = s.size();
            while (j > 0 && nums[s.get(j - 1)] < x) {
                j--;
            }
            List<Integer> popped = s.subList(j, s.size());
            t.addAll(popped);
            popped.clear();
            s.add(i);
        }
        return ans;
    }
}