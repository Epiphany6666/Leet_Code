package title.只出现一次的数字136;

public class test {
}
//mind 今天刚学的知识就派上用场了！
class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }
}