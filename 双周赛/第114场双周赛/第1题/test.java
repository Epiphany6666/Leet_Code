package 双周赛.第114场双周赛.第1题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class test {
}

/*
class Solution {
    public int minOperations(List<Integer> nums, int k) {
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == k) return i + 1;
        }
        return -1;
    }
}*/

/*
//总是误解错题目意思。。。
class Solution {
    public int minOperations(List<Integer> nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = nums.size() - 1; i >= 0; i--) {
            int num = nums.get(i);
            if (num <= k) set.add(num);
            if (set.size() == k) return nums.size() - i;
        }
        return -1;
    }
}*/

/*
class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int cnt = 1;
            while (nums[i] == nums[i + 1]) {
                cnt++;
                i++;
            }
            if (cnt == 1) return -1;
            if (cnt == 2) ans += 1;
            else if (cnt == 3) ans += 1;
            else if (cnt % 3 == 4) ans += (cnt / 3 + 2);
            else ans += (cnt / 3 + 1);
        }
        return ans;
    }
}*/

class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 1;
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                cnt++;
                i++;
            }
            if (cnt == 1) return -1;
            if (cnt == 2) ans += 1;
            else if (cnt == 3) ans += 1;
            else if ((cnt - 2) % 3 == 0) ans += ((cnt - 2) / 3 + 1);
            else if ((cnt - 4) % 3 == 0) ans += ((cnt - 4) / 3 + 2);
            else ans += cnt / 3;
        }
        return ans;
    }
}