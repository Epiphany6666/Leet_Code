package 周赛.第369场.找出数组中的Kor值2917.overWrite01;

public class test {
}

class Solution {
    public int findKOr(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            int cnt = 0;
            for (int num : nums) {
                // note 应该往右移
//                cnt += ((num << i) & 1);
                cnt += ((num >> i) & 1);
                if (cnt >= k) {
                    ans |= (1 << i);
                    continue;
                }
            }
        }
        return ans;
    }
}