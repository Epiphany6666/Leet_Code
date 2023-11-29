package title.最长递增子序列300;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        new Solution().lengthOfLIS(new int[] {10,9,2,5,3,7,101,18});
    }
}

//method 1：Dynamic programming.
//mind 动态规划怎么做还是要自己悟。。。
/*class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}*/

//method 2：dynamic programming + Dichotomy
//二分真的看了好久，但是看见评论区一个人的例子就一下就明白了：
//直接看文字确实不太好懂，加个例子就比较容易明白，比如序列是78912345，
// 前三个遍历完以后tail是789，这时候遍历到1，就得把1放到合适的位置，
// 于是在tail二分查找1的位置，变成了189（如果序列在此时结束，因为res不变，所以依旧输出3），
// 再遍历到2成为129，然后是123直到12345
// 这题难理解的核心不在于算法难，而在于在于官方给的例子太拉了，遇不到这个算法真正要解决的问题，即没有我例子中1要代替7的过程，官例中每次替代都是替代tail的最后一个数
/*
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tail = new int[n];
        int ans = 0;
        for (int num : nums) {
            int i = 0, j = ans;
//            while (i <= j) {
//                int mid = j + ((i - j) >> 1);
//                if (tail[mid] <= num) i = mid + 1;
//                else j = mid - 1;
//            }
            while (i <= j) {
                int mid = j + ((j - i) >> 1);
                if (tail[mid] <= num) i = mid + 1;
                else j = mid - 1;
            }
            tail[j] = num;
            if (j == ans) ans++;
        }
        return ans;
    }
}*/

//mind 好烦，已经不想想了。。
/*class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int ans = 0;
        for (int num : nums) {
            int i = 0, j = ans;
            while (i < j) {
//                int m = j + ((j - i) >> 1);
                int m = i + ((j - i) >> 1);
                if (nums[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if (ans == j) ans++;
        }
        return ans;
    }
}*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tail = new int[n];
        int ans = 0;
        for (int num : nums) {
            int i = 0, j = ans;
            while (i <= j) {
                int mid = i + ((j - i) >> 1);
                if (tail[mid] <= num) i = mid + 1;
                else j = mid - 1;
            }
            if (i < ans) tail[i] = num;
            else ans++;
        }
        return ans;
    }
}