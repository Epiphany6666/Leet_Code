package title.四数之和18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 总结：
 * 1.这道题完全就是不会学以致用
 * 2.边界地方不会进行处理
 * 3.asList不是早就接触过了吗
 */

public class test {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        new Solution().fourSum(nums, target);
    }
}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int length = nums.length;
        if (nums == null || length < 4) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if ((long)nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if ((long)nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3] < target) continue;
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if ((long)nums[j] + nums[j + 1] + nums[j + 2] + nums[i] > target) break;
                if ((long)nums[j] + nums[length - 1] + nums[length - 2] + nums[i] < target) continue;
                int left = j + 1;
                int right = length - 1;
                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[right] + nums[left];
                    if (sum == target) {
                        /*List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        ans.add(temp);*/
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        while (left < right && nums[left - 1] == nums[left]) left++;
                        right--;
                        while (left < right && nums[right + 1] == nums[right]) right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return ans;
    }
}