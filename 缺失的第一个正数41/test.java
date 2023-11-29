package title.缺失的第一个正数41;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test {
}

/*class Solution {
    public int firstMissingPositive(int[] nums) {
    //  question 这里hash表只能使用for一个一个的添加元素，为什么使用Set<Integer> set = new HashSet<>(Arrays.asList(nums));会报错呢。。。什么情况下才能使用Arrays.asList(nums)，将数组中的所有元素添加到集合中呢
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

//        for (int i = 1; ; i++) {
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) return i;
        }
    }
}*/

//method 2：排序，不使用二分
/*
class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);

        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] == pre) continue;
            else if (nums[i] > pre + 1) break;
            pre++;
        }
        return pre + 1;
    }
}*/

/*class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);

        //note pre还是令前一个数比较好，因为如果令pre等于当前数，就需要额外判断相等的情况
        int pre = 1;
        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] <= 0) continue;
            if (nums[i] <= 0 || (i > 0 && nums[i] == nums[i - 1])) continue;
            else if (nums[i] > pre) break;
            pre++;
        }
        return pre;
    }
}*/

//method 2：排序 + 二分
/*
class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;

        for (int i = 1; i <= len; i++) {
            int ret = binarySerch(nums, i);
            if (ret == -1) {
                return i;
            }
        }
        return len + 1;
    }

    private int binarySerch(int[] nums, int i) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < i) {
                l = mid + 1;
            } else if (nums[mid] > i) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}*/

//method 3：原地hash
/*
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] >= 1 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}*/

//method 4：原地哈希+标记，这个方法倒是让我想了有一会
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        //先将所有的负数变为正数
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) nums[i] = len + 1;
        }

        for (int i = 0; i < len; i++) {
            int num = Math.abs(nums[i]);
            if (num <= len) nums[num - 1] = -Math.abs(nums[num - 1]);
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] >= 0) return i + 1;
        }
        return len + 1;
    }
}