package title.和为K的子数组560;

import java.util.HashMap;
import java.util.HashSet;

public class test {
}

/*
class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int l = 0, r = 0;
        int sum = 0;
        while (r < len) {

        }
    }
}*/

//method 1：暴力枚举
/*
class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        if (nums == null || nums.length == 0) return ans;
        int len = nums.length;
        for (int end = 0; end < len; end++) {
            int sum = 0;
//            for (int i = 0; i <= end; i++) {
//                sum += nums[i];
//            }
//            if  (sum == k) ans++;
            //note 应该从后往前，并且每形成一次子数组都需要判断一次！
            for (int start = end; start >= 0; start--) {
                sum += nums[start];
                if (sum == k) ans++;
            }
        }
        return ans;
    }
}*/

//method 2：前缀和
/*
class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        if (nums == null || nums.length == 0) return ans;
        int len = nums.length;
        int[] prefix = new int[len + 1];
        for (int i = 0; i < len; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        HashSet<Integer> set = new HashSet<>();
//        for (int i = 0; i <= len; i++) {
//            for (int j = 0; j <= i; j++) {
        //note 注意[1]，0这个数据
        //note !j不能等于i，因为子数组无法为空
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                int sum = prefix[i] - prefix[j];
                if (sum == k) ans++;
            }
        }
        return ans;
    }
}*/

//method 2：前缀和+hash表优化 - 1
//note j必须在i之前，否则会统计重复
/*
class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        if (nums == null || nums.length == 0) return ans;
        int len = nums.length;
        int[] prefix = new int[len + 1];
        for (int i = 0; i < len; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        //note 这里不能定义hash表为set，因为我们需要统计前缀和为 pre[i] - k的个数
//        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= len; i++) {
            ans += map.getOrDefault(prefix[i] - k, 0);
            map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);
        }
        return ans;
    }
}*/

//method 2：前缀和+hash表优化 - 2
class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        if (nums == null || nums.length == 0) return ans;
        int pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        //note 千万不要忘记这个！！！
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) ans += map.get(pre - k);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }
}