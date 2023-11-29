package title.同积元组1762;

import java.util.HashMap;

public class test {
}

/*
class Solution {
    public int tupleSameProduct(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    for (int l = 0; l < len; l++) {
//                        if (i *j == k * l && i != j && j != k && k != l) {
                        if (nums[i] * nums[j] == nums[k] * nums[l] && i != j && j != k && k != l) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}*/

class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int key = nums[i] * nums[j];
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        for (Integer value : map.values()) {
            ans += (value * (value - 1) * 4);
        }
        return ans;
    }
}