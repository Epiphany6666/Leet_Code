package title.丢失的数字268;

import java.util.Arrays;

public class test {
}

/**
 * 位运算总结：
 * x & (-x)：获得x的二进制位中最低位的1的位置
 * x & (x - 1)：将x的二进制表示中的最低位的1置为0
 *
 * 异或：相同为0，相异为1
 * 英文为exclusive OR，缩写成xor异或（xor）
 * x ^ x = 0
 * x ^ 0 = x
 */

/*
//method 自写
class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;

        boolean[] arr = new boolean[len + 1];
        for (int num : nums) {
            arr[num] = true;
        }
        for (int i = 0; i < len + 1; i++) {
            if (!arr[i]) return i;
        }
        return -1;
    }
}*/

//method 2：排序
/*
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != i) return i;
        }
//        return -1;
        return len;
    }
}*/

//method 3：位运算，这个方法6666啊
/*
class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        int len = nums.length;
        for (int num : nums) {
            xor ^= num;
        }

        for (int i = 0; i <= len; i++) {
            xor ^= i;
        }
        return xor;
    }
}*/

//method 4：数学
class Solution {
    public int missingNumber(int[] nums) {
        int sum1 = 0, sum2 = 0;
        for (int num : nums) {
            sum1 += num;
        }

//        for (int i = 0; i <= nums.length; i++) {
//            sum2 += i;
//        }
        //note 简写：高斯公式
        sum2 = nums.length * (nums.length + 1) / 2;
        return sum2 - sum1;
    }
}