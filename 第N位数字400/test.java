package title.第N位数字400;

public class test {
}

/*
class Solution {
    public int findNthDigit(int n) {
        int ans = 0, cnt = 0;
        out:for (int i = 1; ; i++) {
            int x = i;
            while (x != 0) {
                cnt++;
                if (cnt == n) {
                    ans = x % 10;
                    break out;
                }
                x /= 10;
            }
        }
        return ans;
    }
}*/

class Solution {
    public int findNthDigit(int k) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (k > count) {
            k -= count;
            start *= 10;
            digit += 1;
            count = digit * start * 9;
        }
        long num = start + (k - 1) / digit;
        return Long.toString(num).charAt((k - 1) % digit) - '0';
    }
}