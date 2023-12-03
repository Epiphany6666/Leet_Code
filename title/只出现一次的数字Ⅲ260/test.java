package title.只出现一次的数字Ⅲ260;

public class test {
}

class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

//        int diff = xor & (-xor);
        int diff = (xor == Integer.MIN_VALUE ? xor : xor & (-xor));
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & diff) != 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        return new int[] {num1, num2};
    }
}