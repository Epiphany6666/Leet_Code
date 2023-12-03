package title.LCR_172_统计目标成绩的出现次数;

public class test {
    public static void main(String[] args) {
        new Solution().countTarget(new int[] {2,2,3,4,4,4,5,6,6,8}, 4);
    }
}

class Solution {
    public int countTarget(int[] scores, int target) {
        int l = 0, r = scores.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (scores[mid] < target) l = mid + 1;
            else r = mid;
        }
        int left = l;
        l = 0; r = scores.length - 1;
        while (l < r) {
            int mid = l + ((r - l + 1) >> 1);
            if (scores[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return l - left + 1;
    }
}