package title.寻找重复数287;

import java.util.HashSet;
import java.util.Set;

public class test {
}

/*
class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) return num;
        }
        return -1;
    }
}*/

//method 1：二分法
/*
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] < mid) cnt++;
            }
            if (cnt <= mid) l = mid + 1;
            else {
                r = mid - 1;
                ans = mid;
            }
        }
        //return l也是正确的！
//        return l;
        return ans;
    }
}*/

//method 2：快慢指针
/*
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            //note 有可能slow和fast此时指向同一个数
//            if (slow == fast) return nums[slow];
            //这个也是不对的。。
            if (nums[slow] == nums[fast] && slow != fast) return nums[slow];
        }
    }
}*/

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        /*slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }*/

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}