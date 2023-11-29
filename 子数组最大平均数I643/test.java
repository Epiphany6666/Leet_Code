package title.子数组最大平均数I643;

public class test {
}

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[k];
        }
        int max = sum;
        for (int i = k; i < nums.length; i++) {
            sum += (nums[i] - nums[i - k]);
            max = Math.max(max, sum);
        }
        return 1.0d * max / k;
    }
}