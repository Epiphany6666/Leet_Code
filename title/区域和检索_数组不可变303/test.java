package title.区域和检索_数组不可变303;

public class test {
}

class NumArray {
    int[] prefix;
    public NumArray(int[] _nums) {
        int n = _nums.length;
        prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + _nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
//        return prefix[right] - prefix[left - 1];
        return prefix[right + 1] - prefix[left];
    }
}