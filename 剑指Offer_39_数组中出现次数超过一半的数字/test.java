package title.剑指Offer_39_数组中出现次数超过一半的数字;

public class test {
}

/*
class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int ans = len / 2;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > ans) return num;
        }
        return -1;
    }
}*/

/*
//TODO 法2：排序
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}*/

/*
//TODO 法3：分治
class Solution {
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private int majorityElementRec(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }

        int mid = l + (r - l) >> 2;
        int left = majorityElementRec(nums, l, mid);
        int right = majorityElementRec(nums, mid + 1, r);

        if (left == right) {
            return left;
        }

        int leftCount = countInRange(nums, left, l, r);
        int rightCount = countInRange(nums, right, l, r);

//        return leftCount > rightCount ? leftCount : rightCount;
        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] nums, int num, int l, int r) {
        int count = 0;
        for (int i = l; i <= r; i++) {
            if (nums[i] == num) count++;
        }
        return count;
    }
}*/


//TODO  法4：Boyer-Moore投票算法
/*
class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int candidate = 0;
        for (int num : nums) {
            if (cnt == 0) candidate = num;
            if (num == candidate) cnt++;
            else cnt--;
        }
        return candidate;
    }
}*/

//简写
class Solution {
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }

        //判断是否有众数
        int count = 0;
        for (int num : nums) {
            count += num == x ? 1 : 0;
        }
        return count > nums.length / 2 ? x : 0;//无众数时返回0
    }
}