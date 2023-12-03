package title.全0子数组的数目2348;
/**
 * 总结：
 * 还是很多基本错误
 */

public class test {
    public static void main(String[] args) {
        new Solution().zeroFilledSubarray(new int[] {0,0,0,2,0,0});
    }
}

/*
class Solution {
    public long zeroFilledSubarray(int[] nums) {
//        int ans = 0;
        long ans = 0;
        int left = 0;
        int len = nums.length;
        for (int right = 0; right < nums.length; right++) {
//            if (right != 0) {//又又又犯这样的错
            if (nums[right] != 0 || right == len - 1) {
                if (nums[left] == 0) {
                    int a1 = 1, an = right - left;
                    if (right == len - 1 && nums[right] == 0) {//没有考虑right==len-1时，个数为right - left + 1
                        an = right - left + 1;
                    }
//                    ans += (a1 + an) * an / 2;
                    //乘积要考虑溢出问题啊！！！
                    ans += (long)(a1 + an) * an / 2;
                }
                left = right + 1;
            }
        }
        return ans;
    }
}*/

//灵神的贡献法
/*
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                ans += (right - left + 1);
            } else {
                left = right + 1;
            }
        }
        return ans;
    }
}*/

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        long c = 0;
        for (int num : nums) {
            if (num != 0) c = 0;
            else ans += ++c;
        }
        return ans;
    }
}