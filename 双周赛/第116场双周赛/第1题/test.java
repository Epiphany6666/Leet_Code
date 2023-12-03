package 双周赛.第116场双周赛.第1题;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class test {
}
/*

class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        int size = nums.size();
        for (int i = 1; i <= size; i++) {
            ans = (ans + (int)Math.pow(sq(nums, i), 2)) % ((int)1e9 + 7);
        }
    }

    private int sq(List<Integer> nums, int i) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int j = 0; j < i; j++) {
            if (set.add(nums.get(i))) count++;
        }
    }
}*/

//class Solution {
//    public int sumCounts(List<Integer> nums) {
//        int mod = (int) (1e9 + 7);
//        int n = nums.size();
//        HashMap<Integer, Integer> count = new HashMap<>();
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            count.put(nums.get(i), count.getOrDefault(nums.get(i), 0) + 1);
//            int distinctCount = count.size();
//            sum = (sum + distinctCount * distinctCount) % mod;
//        }
//        return sum;
//    }
//}

/*
class Solution {
    public int sumCounts(List<Integer> nums) {
        int mod = (int) (1e9 + 7);
        int n = nums.size();
        HashMap<Integer, Integer> count = new HashMap<>();
        int sum = 0;
        int distinctCount = 0;

        for (int i = 0, j = 0; i < n; i++) {
            count.put(nums.get(i), count.getOrDefault(nums.get(i), 0) + 1);
            while (count.get(nums.get(j)) > 1) {
                count.put(nums.get(j), count.get(nums.get(j)) - 1);
                j++;
            }
            distinctCount = i - j + 1;
            sum = (sum + distinctCount * distinctCount) % mod;
        }

        return sum;
    }
}*/

class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0, size = nums.size();
        for (int i = 0; i < size; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < size; j++) {
                set.add(nums.get(j));
                ans = (ans + set.size() * set.size()) % ((int)1e9 + 7);
            }
        }
        return ans;
    }
}