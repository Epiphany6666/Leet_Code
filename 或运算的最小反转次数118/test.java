package title.或运算的最小反转次数118;

public class test {
}

class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int bit_a = (a >> i) & 1;
            int bit_b = (b >> i) & 1;
            int bit_c = (c >> i) & 1;
            if (bit_c == 0) ans += (bit_a + bit_b);
            else ans += (bit_a + bit_b == 0) ? 1 : 0;
        }
        return ans;
    }
}