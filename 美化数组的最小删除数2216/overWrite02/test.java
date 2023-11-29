package title.美化数组的最小删除数2216.overWrite02;

public class test {
}

class Solution {
    public int minDeletion(int[] nums) {
        int len = nums.length, cnt = 0;
        for (int i = 0; i < len; i++) {
            if ((i - cnt) % 2 == 0 && i + 1 < len && nums[i] == nums[i + 1]) cnt++;
        }
        return (len - cnt) % 2 == 0 ? cnt : cnt + 1;
    }
}