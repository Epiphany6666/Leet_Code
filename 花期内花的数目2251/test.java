package title.花期内花的数目2251;

import java.util.Arrays;

public class test {
}

//method 第一个测试用例就直接超时。。。
/*
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] cnt = new int[(int)1e9];
        for (int[] flower : flowers) {
            for (int i = flower[0]; i <= flower[1]; i++) {
                cnt[i]++;
            }
        }

        int[] ans = new int[people.length];
        int idx = 0;
        for (int person : people) {
            ans[idx++] = cnt[person];
        }
        return ans;
    }
}*/

//method 1：转换+二分
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = flowers[i][0];
            ends[i] = flowers[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

//        int[] ans = new int[people.length];
        for (int i = 0; i < people.length; i++) {
//            ans[i] = lowerBound()
//            people[i] = lowerBound(starts, people[i]) - lowerBound(ends, people[i]);
            people[i] = lowerBound(starts, people[i] + 1) - lowerBound(ends, people[i] - 1);
        }
        return people;
    }

    private int lowerBound(int[] nums, int x) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}