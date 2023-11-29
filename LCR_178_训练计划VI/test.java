package title.LCR_178_训练计划VI;

public class test {
}

//method 1：有限状态自动机
/*
class Solution {
    public int trainingPlan(int[] actions) {
        int ones = 0, twos = 0;
        for (int action : actions) {
            ones = ones ^ action & ~twos;
            twos = twos ^ action & ~ones;
        }
        return ones;
    }
}*/

//method 2：遍历统计
class Solution {
    public int trainingPlan(int[] actions) {
        int[] count = new int[32];
        for (int action : actions) {
            for (int i = 0; i < 32; i++) {
                count[i] += (action & 1);
                action >>= 1;
            }
        }

        int ans = 0, m = 3;
        for (int i = 31; i >= 0; i--) {
            //note 这句话只能在前面，如果放在最后移动，它会越界！
            ans <<= 1;
            ans |= (count[i] % m);
//            ans <<= 1;
        }
        return ans;
    }
}