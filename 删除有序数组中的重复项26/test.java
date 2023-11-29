package title.删除有序数组中的重复项26;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test {
}

//method 自写
class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            list.add(nums[i]);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            nums[i] = list.get(i);
        }
        return size;
    }
}

//method 2：双指针
/**
 * 注意数组是有序的
 */
class Solution2 {
    public int removeDuplicates(int[] nums) {
        int idx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])  continue;
            nums[idx++] = nums[i];
        }
        return idx;
    }
}