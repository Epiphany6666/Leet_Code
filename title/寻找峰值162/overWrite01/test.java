package title.寻找峰值162.overWrite01;

public class test {
}

class Solution1 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (i == 0 && nums[0] > nums[1]) return nums[0];
            else if (i == n - 1 && nums[n - 1] > nums[n - 2]) return nums[n - 1];
            else if (i - 1 >= 0 && i + 1 < n && nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) return nums[i];
        }
        return -1;
    }
}

//method 1：模拟
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            boolean ok = true;
            if (i - 1 >= 0) {
                if (nums[i] <= nums[i - 1]) ok = false;
            }
            if (i + 1 < n) {
                if (nums[i] <= nums[i + 1]) ok = false;
            }
            if (ok) return i;
        }
        return -1;
    }
}