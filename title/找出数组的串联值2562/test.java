package title.找出数组的串联值2562;

public class test {
}

/*
class Solution {
    public long findTheArrayConcVal(int[] nums) {
        //note 这个返回值是long为什么总是忘记
//        int ans = 0;
        long ans = 0;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            if (l == r) {
                ans += nums[l];
                break;
            }
//            ans += (nums[l] * 10 * cnt(nums[r]) + nums[r]);
            ans += (nums[l] * Math.pow(10, cnt(nums[r])) + nums[r]);
            //note 为什么l，r不移动？
            l++;
            r--;
        }
        return ans;
    }

    private int cnt(int num) {
        int cnt = 0;
        while (num != 0) {
            cnt++;
            num /= 10;
        }
        return cnt;
    }
}*/

//method 灵神！
class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        int l = 0, r = nums.length;
        while (l < r) {
            int x= nums[l];
            int y = nums[r];
            while (y != 0) {
                x *= 10;
                y /= 10;
            }
            ans += (x + nums[r]);
            l++;
            r--;
        }
        if (l == r) {
            ans += nums[l];
        }
        return ans;
    }
}