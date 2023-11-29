package title.递增的三元子序列334;

public class test {
}

/*
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3) return false;
        int[] min = new int[len + 1];
        Arrays.fill(min, Integer.MAX_VALUE);
        for (int i = 0; i < len; i++) {
            min[i + 1] = Math.min(min[i], nums[i]);
        }

        int max = nums[len - 1];
        //note 太粗心了
//        for (int i = len - 2; i >= 0; i++) {
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] > min[i] && nums[i] < max) return true;
            max = Math.max(max, nums[i]);
        }
        return false;
    }
}*/


//method 2：贪心
//这个贪心太牛了，。。。
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3) return false;
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            if (nums[i] > second) return true;
            //note 这里决不能写等于，想想[1,1,-2,6]测试用例
//            else if (nums[i] >= first) second = nums[i];
            else if (nums[i] > first) second = nums[i];
            else first = nums[i];
        }
        return false;
    }
}