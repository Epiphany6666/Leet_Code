package title.丑数Ⅱ264.overWrite01;

public class test {
}

class Solution {
    public int nthUglyNumber(int n) {
        //1也是丑数
//        int[] ans = new int[n + 1];
        int[] ans = new int[n];
        ans[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int n2 = ans[p2] * 2, n3 = ans[p3] * 3, n5 = ans[p5] * 5;
            ans[i] = Math.min(n2, Math.min(n3, n5));
            if (ans[i] == n2) p2++;
            if (ans[i] == n3) p3++;
            if (ans[i] == n5) p5++;
        }
        return ans[n - 1];
    }
}