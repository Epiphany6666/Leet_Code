package title.只出现一次的数字136.overWrite01;

public class test {
}

class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }
}