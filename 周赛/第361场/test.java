package 周赛.第361场;

/**
 * 呵呵哒，一题也没做出来
 */
public class test {
    public static void main(String[] args) {
//        new Solution().countSymmetricIntegers(1203, 1212);
    }
}
/**
 * 没过原来是因为没有考虑到i可能是奇数
 */
/*class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int i = low; i <= high; i++) {
            if (bit(i) % 2 == 0 && isc(i)) ans++;
        }
        return ans;
    }

    public boolean isc(int x) {
        int c = x;
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt = bit(x);

        while (cnt-- > 0) {
            cnt1 += c % 10;
            c /= 10;
        }

        while (c > 0) {
            cnt2 += c % 10;
            c /= 10;
        }
        if (cnt1 == cnt2) return true;
        return false;
    }

    public int bit(int x) {
        int cnt = 0;
        while (x > 0) {
            cnt++;
            x /= 10;
        }
        return cnt / 2;
    }
}*/

/*
class Solution {
    public int minimumOperations(String num) {
        for (int i = 0; i < num.length(); i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < num.length(); j++) {
                if (j != i) {

                }
            }
        }
    }
}*/
