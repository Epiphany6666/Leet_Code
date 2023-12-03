package title.LCR_170_交易逆序对的总数;

import java.util.Arrays;

public class test {
}

/*
//method 暴力肯定超时，，，
class Solution {
    public int reversePairs(int[] record) {
        int ans = 0;
        for (int i = 0; i < record.length; i++) {
            for (int j = i + 1; j < record.length; j++) {
                if (record[j] < record[i]) ans++;
            }
        }
        return ans;
    }
}*/

//method 归并排序
class Solution {
    public int reversePairs(int[] record) {
        int len = record.length;
        int[] nums = Arrays.copyOfRange(record, 0,  len);
        int[] temp = new int[len];
        return mergeSort(nums, 0, len - 1, temp);
    }

    private int mergeSort(int[] nums, int l, int r, int[] temp) {
        if (l >= r) return 0;
        int mid = l + ((r - l) >> 1);
        int leftPair = mergeSort(nums, l, mid, temp);
        int rightPair = mergeSort(nums, mid + 1, r, temp);
        if (nums[mid] <= nums[mid + 1]) return leftPair + rightPair;

        int ans = leftPair + rightPair;
        //合并
        for (int i = l; i <= r; i++) {
            temp[i] = nums[i];
        }
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i >= mid + 1) {
                //无语了
//                nums[k] = nums[j++];
                nums[k] = temp[j++];
            } else if (j >= r + 1) {
                nums[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {//等于必须放在右边
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
                ans += (mid - i + 1);
            }
        }
        return ans;
    }
}