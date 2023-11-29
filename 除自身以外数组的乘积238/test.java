package title.除自身以外数组的乘积238;

public class test {
}

/*
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        //前缀和乘积
        int[] preMul = new int[len + 1];
        preMul[0] = 1;
        //后缀和乘积
        int[] sufMul = new int[len + 1];
        sufMul[len - 1] = 1;

        for (int i = 0; i < len; i++) {
            preMul[i + 1] = preMul[i] * nums[i];
        }

        for (int i = len - 1; i >= 1; i--) {
            sufMul[i - 1] = sufMul[i] * nums[i];
        }

        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = preMul[i] * sufMul[i];
        }
        return ans;
    }
}*/

//method 只需要两个for循环即可
/*
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = 1;
        int tmp = 1;
        for (int i = 0; i < len; i++) {
            ans[i + 1] = ans[i] * nums[i];
        }

        for (int i = len - 1; i > 0; i--) {
            tmp *= nums[i];
            //note 这里不能在使用ans[i]了，以外ans[i]代表的是前缀和，所以这里需要个额外的变量重新计算后缀和
//            ans[i - 1] = ans[i] * nums[i];
//            ans[i - 1] = tmp * nums[i];
            ans[i - 1] *= tmp;
        }
        return ans;
    }
}*/

//method 用除法的情况
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCnt = 0;
        int idx = -1;
        int ret = 1;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (num == 0) {
                zeroCnt++;
                idx = i;
                continue;
            }
            ret *= num;
        }

        int[] ans = new int[len];
        if (zeroCnt >= 2) return ans;
        if (zeroCnt == 1) {
            ans[idx] = ret;
            return ans;
        }
        for (int i = 0; i < len; i++) {
            ans[i] = ret / nums[i];
        }
        return ans;
    }
}