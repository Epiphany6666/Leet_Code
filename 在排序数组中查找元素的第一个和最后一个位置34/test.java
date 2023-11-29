package title.在排序数组中查找元素的第一个和最后一个位置34;

public class test {
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[1] = binarySearchOne(nums, target);
        ans[2] = binarySearchTwo(nums, target);
        return ans;
    }

    private int binarySearchTwo(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] <= target) {
                l = mid  + 1;
            }  else {
                r = mid - 1;
            }
        }
        return nums[r] == target ? r : -1;
    }

    private int binarySearchOne(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return nums[l] == target ? l : -1;
    }
}