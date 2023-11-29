package title.统计能整除数字的位数2520;

public class test {
}

class Solution {
    public int countDigits(int num) {
        int ans = 0;
        int x = num;
        while (x != 0) {
            if (num % (x % 10) == 0) ans++;
            x /= 10;
        }
        return ans;
    }
}