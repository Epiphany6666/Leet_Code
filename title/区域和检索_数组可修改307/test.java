package title.区域和检索_数组可修改307;

public class test {
}

/*
class NumArray {
    int[] prefix;
    int[] nums;
    int len;
    public NumArray(int[] nums) {
        this.nums = nums;
        this.len = nums.length;
        prefix = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        for (int i = index + 1; i <= len; i++) {
            prefix[i] += diff;
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }
}
*/

//method 2：树状数组
class NumArray {
    int[] tree;
    int[] nums;
    int len;
    public int lowbit(int x) {
        return x & (-x);
    }

    public void add(int index, int val) {
        for (int i = index; i <= len; i += lowbit(i)) {
            tree[i] += val;
        }
    }

    public int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            ans += tree[i];
        }
        return ans;
    }

    public NumArray(int[] nums) {
        len = nums.length;
        this.nums = nums;
        tree = new int[len + 1];
        for (int i = 0; i < len; i++) {
            add(i + 1, nums[i]);
        }
    }

    public void update(int index, int val) {
        add(index + 1, val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }
}