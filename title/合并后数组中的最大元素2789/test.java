package title.合并后数组中的最大元素2789;

public class test {
}

/**
 * 参考题解：Storm
 * 一开始没有弄明白为什么必须要从后向前遍历，直到自己用了几个数看了一下才明白，比如2,3,4：
 * 如果从前往后的话，第一步就会变成5,4 然后最大的数就是5
 * 如果从后往前的话，第一步变成2,7 第二步变成9 最大的数为9
 * 贪心的来讲，后面的数越大越好，所以先加后面的所以从后往前遍历即可
 */
class Solution {
    public long maxArrayValue(int[] nums) {
//        int cur = 0, max = 0;
        long cur = 0, max = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            cur = nums[i] <= cur ? nums[i] + cur : nums[i];
            max = Math.max(max, cur);
        }
        return max;
    }
}