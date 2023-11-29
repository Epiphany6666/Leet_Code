package title.连续数组525;

import java.util.HashMap;

public class test {
}

class Solution {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int[] prefix = new int[len + 1];
        for (int i = 0; i < len; i++) {
//            prefix[i + 1] = prefix[i] + nums[i];
            prefix[i + 1] = prefix[i] + nums[i] == 0 ? -1 : 1;
        }

        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 1; i <= len; i++) {
            int t = prefix[i];
            if (map.containsKey(t)) ans = Math.max(ans, i - map.get(t));
//            map.put(t, i - 1);
            if (!map.containsKey(t)) map.put(t, i - 1);
        }
        return ans;
    }
}