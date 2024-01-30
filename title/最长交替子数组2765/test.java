package title.最长交替子数组2765;

public class test {
}

//class Solution {
//    public int alternatingSubarray(int[] nums) {
//        int m = nums.length;
//        int ans = 1, cnt = 1;
//        for (int i = 0; i < m - 1; i++) {
//            if (Math.abs(nums[i + 1] - nums[i]) == 1) {
//                cnt++;
//            } else {
//                ans = Math.max(ans, cnt);
//                cnt = 1;
//            }
//        }
//        return ans == 1 ? -1 : ans;
//    }
//}

class Solution {
    public int alternatingSubarray(int[] nums) {
        int ans = 0;
        int i = 0, n = nums.length;
        while (i < n - 1) {
            if (nums[i + 1] - nums[i] != 1) {
                i++;
                continue;
            }
            int i0 = i;
            i += 2;
            while (i < n && nums[i] == nums[i - 2]) {
                i++;
            }
            ans = Math.max(ans, i - i0);
        }
        return ans;
    }
}