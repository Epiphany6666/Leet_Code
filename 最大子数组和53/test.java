package title.最大子数组和53;

/**
 * 总结：
 * 1.对递归和两层for循环直接搞混，明明可以用两层for循环就解决的事，偏偏要用递归
 */

public class test {
    public static void main(String[] args) {
        int[] nums = {-1};
        new Solution().maxSubArray(nums);
    }
}

/*
class Solution {
    private int ans;
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        dfs(nums, len, 0, 0);
        return ans;
    }

    private void dfs(int[] nums, int len, int depth, int sum) {
        for (int j = depth; j < len; j++) {
            sum += nums[j];
            ans = Math.max(ans, sum);
            if (depth == len - 1) {
                return;
            }
            dfs(nums, len,  depth + 1, sum);
            if (depth != 0)
            break;
            else sum = 0;
        }
    }
}*/

/*//法1：暴力
class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}*/


/*
//法2：分治
class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        return pivot(nums, left, right);
    }

    private int pivot(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int mid = left + (right - left) / 2;
        int leftSum = pivot(nums, left, mid);
        int rightSum = pivot(nums, mid + 1, right);
        int pivotSum = getCross(nums, left, right);
        return Math.max(Math.max(leftSum, rightSum), pivotSum);
    }

    private int getCross(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        int leftSum = nums[mid];
        int leftMax = leftSum;
        for (int i = mid - 1; i >= left; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }
        int rightSum = nums[mid + 1];
        int rightMax = rightSum;
        for (int i = mid + 2; i <= right; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightSum, rightMax);
        }
        return leftMax + rightMax;
    }
}*/

//法3：动态规划
class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}