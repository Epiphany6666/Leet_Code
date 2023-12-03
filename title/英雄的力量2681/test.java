package title.英雄的力量2681;

import java.util.Arrays;

public class test {
}

/**
 * 总结：
 * 1.遇到取模问题，尽量乘一个就进行一次取模。
 * 2.乘积尽量使用long，最后再转为int
 * 3.1e9代表10的九次方，计算结果为double
 *   科学计数法形式：如：5.12e2{5.12*10^2};//e和E一样
 */
class Solution {
    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
//        double Mod = 1e9 + 7;//直接将其转为long即可
        long Mod = (long)1e9 + 7;
        long ans = 0, s = 0;
//        for (int x : nums) {//这里也要改为long
        for (long x : nums) {
            ans += x * x % Mod * (x + s) % Mod;
            s = (2 * s + x) % Mod;
        }
        return (int)ans;//最后再强制类型转化为int
    }
}
