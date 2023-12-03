package title.数组中重复的数据442;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        new Solution().findDuplicates(nums);
    }
}

class Solution {
    static Map<Integer, Integer> hashTable = new HashMap<Integer, Integer>();
        static {
            for (int i = 1; i <= 10000; i++) {
                hashTable.put(i, 0);
            }
        }
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i : nums) {
            hashTable.put(i, hashTable.get(i) + 1);
        }
        for (int i : nums) {
            if (hashTable.get(i) >= 2 && !ans.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}

/*
class Solution{
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i : nums) {
            int num = Math.abs(i);
            if (nums[num - 1] > 0) {
                nums[num - 1] *= -1;
            } else {
                ans.add(num);
            }
        }
        return ans;
    }
}*/

/*
//原地哈希
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            if (t < 0 || t - 1 == i) {
                continue;
            }
            if (nums[t - 1] == t) {
                ans.add(t);
                nums[i] *= -1;
            } else {
                int c = nums[t - 1];
                nums[t - 1] = t;
                nums[i--] = c;
            }
        }
        return ans;
    }
}*/

/*
//负号标记
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] > 0) {
                nums[num - 1] *= -1;
            } else {
                ans.add(num);
            }
        }
        return ans;
    }
}*/
