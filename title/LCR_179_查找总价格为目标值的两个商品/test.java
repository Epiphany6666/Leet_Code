package title.LCR_179_查找总价格为目标值的两个商品;

import java.util.HashSet;

public class test {
}

/*
class Solution {
    public int[] twoSum(int[] price, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : price) {
            if (set.contains(target - i)) return new int[] {i, target - i};
            set.add(i);
        }
        return new int[0];
    }
}
*/

class Solution {
    public int[] twoSum(int[] price, int target) {
        int l = 0, r = price.length - 1;
        while (l < r) {
            if (price[l] + price[r] < target) l++;
            else if (price[l] + price[r] > target) r--;
            else return new int[] {price[l], price[r]};
        }
        return new int[0];
    }
}