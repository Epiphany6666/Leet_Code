package title.只出现一次的数字Ⅱ137;

public class test {
}

//method 1：有限状态自动机
/*
class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}*/

//method 2：遍历统计
class Solution {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                counts[i] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for (int i = 0; i < 32; i++) {
//            res <<= i;
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
}