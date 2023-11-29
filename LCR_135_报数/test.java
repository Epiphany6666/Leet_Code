package title.LCR_135_报数;

public class test {
}

class Solution {
    public int[] countNumbers(int cnt) {
        int n = 0;
        while (cnt != 0) {
            n++;
            cnt >>= 1;
        }
        int[] ans = new int[(int)Math.pow(10, n)];
        for (int i = 1; i <= (int)Math.pow(10, n); i++) {
            ans[i - 1] = i;
        }
        return ans;
    }
}