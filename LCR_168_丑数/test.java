package title.LCR_168_丑数;

public class test {
}

/*
class Solution {
    public int nthUglyNumber(int n) {
        int[] num = new int[n];
        num[0] = 1;
        for (int i = 1; i < n; i++) {
            int a = 2, b = 3, c = 5;
            num[i] = Math.min(a, Math.min(b, c));
            if (num[i] == a) a *= 2;
            else if (num[i] == b) b *= 2;
            else c *= 2;
        }
        return num[n - 1];
    }
}*/

//mind 写了这么多次还是不会写。。。
class Solution {
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] num = new int[n];
        num[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = num[a] * 2, n3 = num[b] * 3, n5 = num[c] * 5;
            num[i] = Math.min(a, Math.min(b, c));
            //note 这里不能用else if！相同的也要跳过
            if (num[i] == n2) a++;
            if (num[i] == n3) b++;
            if (num[i] == n5) c++;
        }
        return num[n - 1];
    }
}