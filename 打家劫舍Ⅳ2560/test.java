package title.打家劫舍Ⅳ2560;

import java.util.Arrays;

/**
 * mind 好好好，这道题写了一个半小时
 */
public class test {
    public static void main(String[] args) {
        new Solution().minCapability(new int[] {2,3,5,9}, 2);
    }
}

/*
class Solution {
    int ans = 0x3f3f3f3f;
    public int minCapability(int[] nums, int k) {
        dfs(nums, k, 0, 0, 0, 0);
        return ans;
    }

    private void dfs(int[] nums, int k, int cnt, int sum, int status, int depth) {
//        if (depth == nums.length - 1) {
        if (depth > nums.length - 1) {
            return;
        }
        if (cnt >= k) {
//            ans = Math.min(ans, sum);
            return;
        }
        dfs(nums, k, cnt, sum, 0, depth + 1);
        if (status == 0) {
            ans = Math.min(ans, nums[depth]);
            dfs(nums, k, cnt + 1, sum + nums[depth],  1, depth + 1);
        }
    }
}*/

//mind 也不是直接求最小值啊
/*
class Solution {
    public int minCapability(int[] nums, int k) {
        return Arrays.stream(nums).min().getAsInt();
    }
}*/

/*
class Solution {
    List<Integer> ans = new ArrayList<>();
    public int minCapability(int[] nums, int k) {
        dfs(nums, k, new ArrayList<Integer>(), 0, 0, 0);
        Collections.sort(ans);
        return ans.get(0);
    }

    private void dfs(int[] nums, int k, List<Integer> list, int sum, int status, int depth) {
        if (depth > nums.length - 1) {
            return;
        }
        if (list.size() >= k) {
            Collections.sort(list);
            ans.add(list.get(list.size() - 1));
            return;
        }
        dfs(nums, k, list, sum, 0, depth + 1);
        if (status == 0) {
            list.add(nums[depth]);
            dfs(nums, k, list, sum + nums[depth],  1, depth + 1);
        }
    }
}*/


//mind 为什么要用二分啊，我真的想不到。。还是要多刷题
class Solution {
    public int minCapability(int[] nums, int k) {
        int left = Arrays.stream(nums).min().getAsInt();
        int right = Arrays.stream(nums).max().getAsInt();

//        while (left <= right) {
        while (left < right) {
//            int mid = left + (right - left) >> 1;
            //note 为什么你又不打括号！！！！！
            int mid = left + ((right - left) >> 1);
            if (check(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    /*private boolean check(int[] nums, int k, int mx) {
        int f0 = 0, f1 = 0;
        for (int num : nums) {
            int temp = f1;
            f1 = Math.max(f1, f0 + 1);
            f0 = f1;
        }
        return f1 >= k;
    }*/

    private boolean check(int[] nums, int k, int mx) {
        int f0 = 0, f1 = 0;
        for (int num : nums) {
            if (num > mx) {
                f0 = f1;
            } else {
                int temp = f1;
                f1 = Math.max(f1, f0 + 1);
//                f0 = f1;
                f0 = temp;
            }
        }
        return f1 >= k;
    }
}