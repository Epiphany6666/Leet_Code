package 周赛.第367场.第1题;

public class test {
}

/*
class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

        }
    }
}*/

/*
class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (Math.abs(i - j) < indexDifference) continue;
                if (Math.abs(nums[i] - nums[j]) >= valueDifference) return new int[] {i, j};
            }
        }
        return new int[] {-1, -1};
    }
}*/

class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int maxIdx = 0, minIdx = 0;
        for (int j = indexDifference; j < nums.length; j++) {
            int i = j - indexDifference;
            if (nums[maxIdx] < nums[i]) {
                minIdx = i;
            } else if (nums[minIdx] > nums[i]){
                minIdx = i;
            }
            if (nums[maxIdx] - nums[j] >= valueDifference) return new int[] {maxIdx, j};
            if (nums[j] - nums[minIdx] >= valueDifference) return new int[] {minIdx, j};
        }
        return new int[] {-1, -1};
    }
}