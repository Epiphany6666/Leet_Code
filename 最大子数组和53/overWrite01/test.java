package title.最大子数组和53.overWrite01;

/**
 * 两个月后再来做这道题，依旧不知道是动态规划哈哈哈哈。，，，，
 */
public class test {
}

/*
class Solution {
    public int maxSubArray(int[] nums) {
        int[] prefixSum = new int[nums.length + 1];
        int max = 0;
        int min = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
            max = Math.max(max, prefixSum[i + 1]);
            min = Math.min(min, prefixSum[i + 1]);
        }
        return max - min;
    }
}*/

/*
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}*/

/*
//状态压缩
class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i - 1] + nums[i]);
            ans = Math.max(ans, nums[i]);
        }
        return ans;
    }
}*/

//method 3：分治
class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubArrayNums(nums, 0, nums.length - 1);
    }

    private int maxSubArrayNums(int[] nums, int l, int r) {
        //mind !居然不写返回条件？而且还写错地方，，
        if (l == r) {
            return nums[l];
        }
        int mid = l + ((r - l) >> 1);
        return Math.max(Math.max(maxSubArrayNums(nums, l, mid), maxSubArrayNums(nums, mid + 1, r)),
                maxCrossingSum(nums, l, mid, r));
    }

    private int maxCrossingSum(int[] nums, int l, int mid, int r) {
        /*//mind !居然不写返回条件？
        if (l == r) {
            return nums[l];
        }*/
        int leftSum = nums[l], rightSum = nums[r];
        /*int sum = nums[l];
        for (int i = l; i <= mid; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            if (sum > leftSum) leftSum = sum;
        }

        for (int i = mid + 1; i <= r; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            if (sum > rightSum) rightSum = sum;
        }*/
        //note 这里判断的不是左右两边最大子数组分别是多少，而是判断从mid往两边分别可以到达什么地方！
        int sum = 0;
//        for (int i = mid; i > l; i--) {
        for (int i = mid; i >= l; i--) {
            sum += nums[i];
            if (sum > leftSum) leftSum = sum;
        }
        sum = 0;
        for (int i = mid + 1; i <= r; i++) {
            sum += nums[i];
            if (sum > rightSum) rightSum = sum;
        }
        return leftSum + rightSum;
    }
}