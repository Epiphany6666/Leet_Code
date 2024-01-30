package title.质数减法运算2601;

public class test {
    public static void main(String[] args) {
        new Solution();
    }
}

class Solution {
    private final static int MX = 1000;
    private final static int[] primes = new int[169];
    static {
        boolean[] nums = new boolean[MX + 1];
        int pi = 1;
        for (int i = 2; i <= 1000; i++) {
            if (!nums[i]) {
                primes[pi++] = i;
                for (int j = i * i; j <= MX / i; j++) {
                    nums[i * j] = true;
                }
            }
        }
//        System.out.println(pi);
    }
    public boolean primeSubOperation(int[] nums) {
        int pre = 0;
        for (int num : nums) {
            if (num <= pre) return false;
            int j = lowerBound(primes, num - pre);
            pre = num - primes[j - 1];
        }
        return true;
    }

    private int lowerBound(int[] primes, int target) {
//        int l = 0, r = primes.length - 1;
//        while (l < r) {
//            int mid = l + ((r - l) >> 1);
//            if (primes[mid] > target) {
//                r = mid - 1;
//            } else {
//                l = mid;
//            }
//        }
//        return l;

        int l = -1, r = primes.length;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (primes[mid] < target)
                l = mid;
            else r = mid;
        }
        return r;
    }
}