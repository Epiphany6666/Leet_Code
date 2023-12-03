package title.轮转数组189;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        new Solution().rotate(new int[] {1,2,3,4,5,6,7}, 3);
    }
}

/*
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        //拷贝前半段数组
        int[] temp = Arrays.copyOfRange(nums, 0, len - k);
        //note 这句话会直接将nums的长度改掉！
//        nums = Arrays.copyOfRange(nums, len - k, len);

        //将后半段数组往前移
        for (int i = len - k; i < len; i++) {
            nums[i - len + k] = nums[i];
        }

        //再将前半段数组拷贝到后半段去
        for (int i = 0; i < temp.length; i++) {
            nums[k + i] = temp[i];
        }
    }
}*/

//method 2：看题解，太6了，翻转三次即可
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        //note 忘记取模了。。
        k %= len;

        reverse(nums, 0, len - 1);
        /*reverse(nums, 0, len - k - 1);
        reverse(nums, len - k, len - 1);*/
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
        }
    }
}