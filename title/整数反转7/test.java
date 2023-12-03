package title.整数反转7;

public class test {
}

class Solution {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int tmp = x % 10;
            if (ans > 214748364 || (ans == 214748364 && tmp > 7)) return 0;
            if (ans < 214748364 || (ans == 214748364 && tmp < -8)) return 0;
            ans = ans * 10 + tmp;
            x /= 10;
        }
        return ans;
    }
}