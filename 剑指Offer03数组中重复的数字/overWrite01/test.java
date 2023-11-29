package title.剑指Offer03数组中重复的数字.overWrite01;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        new Solution().findDuplicates(new int[] {3,11,8,16,4,15,4,17,14,14,6,6,2,8,3,12,15,20,20,5});
    }
}

/*
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ) {
            if (nums[nums[i]] == nums[i]) {
                if (set.contains(nums[i]))
                    set.add(nums[i]);
                i++;
            }
            else {
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        for (Integer i : set) {
            list.add(i);
        }
        return list;
    }
}*/

//ming不知道为什么错了，心好浮躁啊
/*
//mind 注意是对应[1,n]
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums.length; ) {
            if (nums[nums[i] - 1] == nums[i]) {
                if (set.contains(nums[i]))
                    set1.add(nums[i]);
                set.add(nums[i]);
                i++;
            }
            else {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (Integer i : set1) {
            list.add(i);
        }
        return list;
    }
}*/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] > 0) nums[num - 1] *= 1;
            else ans.add(num);
        }
        return ans;
    }
}