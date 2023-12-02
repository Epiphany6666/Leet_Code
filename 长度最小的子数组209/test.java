package title.长度最小的子数组209;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        new Solution4().minSubArrayLen(11, new int[] {1,2,3,4,5});
    }
}

//method 1：暴力（超时）
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
//        return -1;
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

//method 2：用两个指针来模仿队列（相加）
class Solution2 {
    public int minSubArrayLen(int target, int[] nums) {
        int lo = 0, hi = 0, sum = 0, ans = Integer.MAX_VALUE;
        while (hi < nums.length) {
            sum += nums[hi++];
            while (sum >= target) {
                ans = Math.min(ans, hi - lo);
                sum -= nums[lo++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

//method 3：用两个指针来模仿队列（相减）
class Solution3 {
    public int minSubArrayLen(int target, int[] nums) {
        int lo = 0, hi = 0, ans = Integer.MAX_VALUE;
        while (hi < nums.length) {
            target -= nums[hi++];
            while (target <= 0) {
                ans = Math.min(ans, hi - lo);
                target += nums[lo++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

//method 4：前缀和 + 二分查找
/**
 * 因为这道题保证了数组中每个元素都为正，所以前缀和一定是递增的
 *
 * Arrays.binarySearch()：大于等于某个数的第一个位置
 * [3] 搜索值不是数组元素，且小于数组内元素，索引值为 – 1；
 * [4] 搜索值不是数组元素，且大于数组内元素，索引值为 – (length + 1);
 */
class Solution4 {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {
            int t = target + sum[i - 1];
            int bound = Arrays.binarySearch(sum, t);
            //note 还原
            if (bound < 0) bound = ~bound;
            if (bound <= len) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

class Solution5 {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {
            int t = target + sum[i - 1];
            int bound = binarySearch(sum, t);
//            if (bound < 0) bound = ~bound;
            if (bound <= len) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    private int binarySearch(int[] sum, int t) {
        int l = 0, r = sum.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            //note 等号还必须在下面。。
//            if (sum[mid] <= t) l = mid + 1;
            if (sum[mid] < t) l = mid + 1;
            else r = mid - 1;
        }
        return r;
    }
}