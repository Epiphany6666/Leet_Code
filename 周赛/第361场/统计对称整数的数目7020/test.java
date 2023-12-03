package 周赛.第361场.统计对称整数的数目7020;
/**
 * 总结：
 * 1.数字转字符串：String.valueOf(i);
 * 2.求数位的一半可以直接转成字符串，一是字符串可以直接求得长度，二是字符串可以从两头分别开始计算
 * 3.字符转数字，减去'0'就行了，怎么也忘记了。。。
 */

public class test {
}

/**
 * 没过原来是因为没有考虑到i可能是奇数
 */
/*
class Solution {
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

/**
 * 自己还一直在想怎么计算 / 了之后已经到了一半。。。
 * 灵神的做法：转为字符串
 */
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int i = low; i <= high; i++) {
            String str = String.valueOf(i);
            int len = str.length();
            if (len % 2 != 0) continue;
            int sum1 = 0, sum2 = 0;
            int left = 0, right = len - 1;
            while (left < right) {
                sum1 += str.charAt(left++) - '0';
                sum2 += str.charAt(right--) - '0';
            }
            if (sum1 == sum2) ans++;
        }
        return ans;
    }
}