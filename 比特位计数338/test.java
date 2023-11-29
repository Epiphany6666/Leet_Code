package title.比特位计数338;

public class test {
}

/*
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int x = i;
            while (x != 0) {
                ans[i] += 1;
                x &= (x - 1);
            }
        }
        return ans;
    }
}*/

//method 666
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                ans[i] += ans[i / 2];
            } else {
                ans[i] += ans[i - 1] + 1;
            }
        }
        return ans;
    }
}