package title.最小化数组中的最大值2439;

public class test {
}

class Solution {
    public int minimizeArrayValue(int[] nums) {
        int l = 0, r = (int)10e9;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (check(nums, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int[] nums, int mid) {
        int have = 0;
        for (int num : nums) {
            if (num <= mid) {
                have += mid - num;
            } else {
                /*if (have < mid - num) return false;
                else have -= (mid - num);*/
                if (have < num - mid) return false;
                else have -= (num - mid);
            }
        }
        return true;
    }
}