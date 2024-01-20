package title.有序数组的平方977;

import java.util.Arrays;

public class test {
}

class Solution1 {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort((nums));
        return nums;
    }
}

//method 2：双指针
//note 上述方法没有用到「数组 nums\textit{nums}nums 已经按照升序排序」这个条件
class Solution2 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int neg = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) neg = i;
            else break;
        }

        int[] ans = new int[n];
        int idx = 0, i = neg, j = neg + 1;
        while (i >= 0 || j < n) {
            if (i < 0) {
                ans[idx] = nums[j] * nums[j++];
            } else if (j == n) {
                ans[idx] = nums[i] * nums[i--];
            } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                ans[idx] = nums[i] * nums[i--];
            } else {
                ans[idx] = nums[j] * nums[j++];
            }
            idx++;
        }
        return ans;
    }
}

//method 3：双指针
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, idx = n - 1; i <= j;) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[idx] = nums[i] * nums[i++];
            } else {
                ans[idx] = nums[j] * nums[j--];
            }
            idx--;
        }
        return ans;
    }
}