package title.剑指Offer03数组中重复的数字;

import java.util.HashSet;
import java.util.Set;

/**
 * 总结：
 * 其实仔细看题，可以不借助哈希
 */
public class test {
}

/*//法1：
class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) return i;
            else set.add(i);
        }
        return -1;
    }
}*/

/**
 * 1.没有考虑到如果x就是在nums[x]的位置上呢
 * 2.交换完原位置需要再判断一次，而不是直接略过！！！所以应该使用while
 */
/*
//法2：
class Solution {
    public int findRepeatNumber(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int x = nums[i];
            //没有考虑到如果x就是在nums[x]的位置上呢
            if (x == i) continue;
            else if (nums[x] == nums[i]) return x;
//            if (x == nums[x] && x != i) return x;
            else Swap(nums, i, x);
        }
        return -1;
    }
    public void Swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}*/

//看答案重写
class Solution {
    public int findRepeatNumber(int[] nums) {
        int len = nums.length;
        int i = 0;
        while (i < len) {
            int x = nums[i];
            if (x == i) {
                i++;
                continue;
            }
            if (x == nums[x]) return x;
            int temp = nums[x];
            nums[x] = x;
            nums[i] = temp;
        }
        return -1;
    }
}