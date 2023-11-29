package title.最大连续1的个数III;

public class test {
}

/*
class Solution {
    public int longestOnes(int[] nums, int k) {
        int p0 = 0, p1 = 0, t = k;
        for (int num : nums) {
            if ()
        }
    }
}*/

/*
class Solution {
    public int longestOnes(int[] nums, int k) {
        int zero = 0, len = nums.length, l = 0, r = 0, ans = 0;
        while (r < len) {
            if (nums[r] == 0) zero++;
            while (zero > k) {
                if (nums[l] == 0) zero--;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}*/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int[] pre = new int[len + 1];
        for (int i = 0; i < len; i++) {
            pre[i + 1] = pre[i] + (1 - nums[i]);
        }

        int ans = 0;
        for (int r = 0; r < len; r++) {
//            int l = binary_search(pre, pre[r] - k);
            int l = binary_search(pre, pre[r + 1] - k);
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    private int binary_search(int[] pre, int n) {
        int l = 0, r = pre.length;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (pre[mid] < n) l = mid + 1;
            else r = mid;
        }
        return r;
    }
}