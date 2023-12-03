package 周赛.第369场.找出数组中的Kor值2917;

public class test {
}

/*
class Solution {
    public int findKOr(int[] nums, int k) {
        int[] cnt = new int[31];
        for (int num : nums) {
            for (int i = 0; i < 31; i++) {
                cnt[i] += (num & 1) == 0 ? 0 : 1;
                num >>= 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            if (cnt[i] >= k) {
//                ans = (ans << i) | cnt[i];
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
*/

/*class Solution {
    public int findKOr(int[] nums, int k) {
//        int[] cnt = new int[31];
        int ans = 0;
        for (int num : nums) {
            //note 不用使用数组
            int cnt = 0;
            for (int i = 0; i < 31; i++) {
                //note
//                cnt[i] += (num & 1) == 0 ? 0 : 1;
//                num >>= 1;
                cnt += (num >> i) & 1;
                if (cnt >= k) {
                    ans |= (1 << i);
                }
            }
        }
        return ans;
    }
}*/

//note 可以不使用数组
class Solution {
    public int findKOr(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            int cnt = 0;
            for (int num : nums) {
                cnt += (num << i) & 1;
            }
            if (cnt >= k) ans |= (1 << i);
        }
        return ans;
    }
}

/*
class Solution {
    public int findKOr(int[] nums, int k) {
        int cnt = 0;
        for (int num : nums) {
            while (num )
        }
    }
}*/
