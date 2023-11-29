package title.逐步求和得到正数的最小值1413;

import java.util.Arrays;

public class test {
}

/*
class Solution {
    public int minStartValue(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum >= 1) return 1;
        else return 1 - sum;
    }
}*/

//贪心明显不行，它要的是按顺序相加
/*
class Solution {
    public int minStartValue(int[] nums) {
        int ans = 1;
        int cur = ans;
        for (int num : nums) {
            //这里不应该使用ans去减，而是应该使用上一次的作差去减
//            ans += (num + ans < 1 ? 1 - num - ans : 0);

            cur += num;
            */
/*if (cur < 0) {
                cur += 1 - num - ans;
                ans += 1 - num - ans;
            }*//*

            if (cur < 1) {
                ans += 1 - cur;//加上的应该使它们的差值
                cur += 1 - cur;
            }
        }
        return ans;
    }
}*/


//好吧，贪心可以，是我太贪心了。。。。[哭]
/*class Solution {
    public int minStartValue(int[] nums) {
        int accSum = 0, accSumMin = 0;
        for (int num : nums) {
            accSum += num;
            accSumMin = Math.min(accSumMin, accSum);
        }
        return -accSumMin + 1;
    }
}*/

//法2：二分查找
class Solution {
    public int minStartValue(int[] nums) {
        //得到一个数组的最小值
        int m = Arrays.stream(nums).min().getAsInt();
        if (m > 0) return 1;
        int n = nums.length;

        int left = 1;
        int right = -m * n + 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (valid(mid, nums)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean valid(int mid, int[] nums) {
        for (int num : nums) {
            mid += num;
            if (mid < 1) return false;
        }
        return true;
    }
}