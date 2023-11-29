package title.LCR_127_跳跃训练;

public class test {
}

class Solution {
    public int trainWays(int num) {
        if (num == 0) return 0;
        int a = 0, b = 0, c = 1;
        int Mod = (int)1e9 + 7;
        for (int i = 1; i <= num; i++) {
            a = b;
            b = c;
            c = (a + b) % Mod;
        }
        return c;
    }
}