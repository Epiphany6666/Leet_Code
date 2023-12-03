package title.移动零283;

public class test {
}

/*
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = 0;
//        for (int i = 0; i < n; i++) {
        for (int i = 0; i < n && j < n; i++) {
            if (nums[i] == 0) continue;
            //让j停留在最左边为0的位置
            //note 此时就需要考虑j的越界问题！
//            while (nums[j] != 0) j++;
            while (j < n && nums[j] != 0) j++;
//            swap(nums, i, j);
            //note j < i才需要交换
            if (j < i && j < n) swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}*/

/*
//method 1：一次遍历
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}*/

//method 2：把不等于0的交换到左边
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null) return;
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j++] = t;
            }
        }
    }
}