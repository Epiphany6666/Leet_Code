package title.从两个数字数组里生成最小数字2605;

/**
 * 总结
 * Integer.numberOfTrailingZero(x)用于计算x从左右边开始非零的第位数
 */

public class test {
}

/*
class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        int min1 = 0x3f3f3f3f, min2 = 0x3f3f3f3f;
        for (int num : nums1) {
            if (num < min1) min1 = num;
            set.add(num);
        }

        for (int num : nums2) {
            if (num < min2) min2 = num;
            if (set.contains(num)) return num;
        }
        return Math.min(10 * min1 + min2, 10 * min2 + min1);
    }
}*/

//这位运算牛啊
class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int mask1 = 0, mask2 = 0;
        for (int num : nums1) {
            mask1 |= 1 << num;
        }
        for (int num : nums2) {
            mask2 |= 1 << num;
        }
        int m = mask1 & mask2;
        if (m > 0) return Integer.numberOfTrailingZeros(m);
        int x = Integer.numberOfTrailingZeros(mask1);
        int y = Integer.numberOfTrailingZeros(mask2);
        return Math.min(10 * x + y, 10 * y + x);
    }
}