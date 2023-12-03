package 基于排列构建数组1920;

public class test {
    public static void main(String[] args) {
        int[] nums = { 5, 0, 1, 2, 3, 4};
        int[] ans = new Solution().buildArray(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print("," + ans[i]);
        }
    }
}

class Solution{
    public int[] buildArray(int[] nums) {
       /* int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;*/
        for (int i = 0; i < nums.length; i++) {
            nums[i] += 1000 * (nums[nums[i]] % 1000);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] /= 1000;
        }
        return nums;
    }
}
