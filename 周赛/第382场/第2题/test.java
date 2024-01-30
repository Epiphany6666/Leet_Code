package 周赛.第382场.第2题;

import java.util.*;

public class test {
    public static void main(String[] args) {
        new Solution().maximumLength(new int[] {1,1,1,1,1,1,1,1,1,1,2,4,8,16,32,64,128,256,512,1024});
    }
}

class Solution {
    public int maximumLength(int[] nums) {
        int ans = 1;
        int n = nums.length;
        Map<Long, Integer> map = new HashMap();
        for (int num : nums) {
            map.put((long) num, map.getOrDefault((long)num, 0) + 1);
        }
        int max = Arrays.stream(nums).max().getAsInt();
        for (int num : nums) {
            if (num == 1) continue;
            int cnt = 0;
            long x = num;
            int p = 1;
            while (map.containsKey(x)) {
                if (map.get(x) >= 2) cnt += 2;
                else if (cnt > 1) cnt++;
                x = ((long) Math.pow(num, p *= 2));
            }
            if (cnt > 1 && map.get(((long) Math.pow(num, p / 2))) >= 2) cnt--;
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}