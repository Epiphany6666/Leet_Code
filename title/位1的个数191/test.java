package title.位1的个数191;

public class test {
}

//method 1
class Solution {
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }
}

//method 2
class Solution2 {
    public int hammingWeight(int n) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) cnt++;
            n >>>= 1;
        }
        return cnt;
    }
}

//method 3
class Solution3 {
    public int hammingWeight(int n) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) == 1) cnt++;
        }
        return cnt;
    }
}