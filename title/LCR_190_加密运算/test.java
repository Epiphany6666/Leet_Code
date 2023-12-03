package title.LCR_190_加密运算;

public class test {
}

class Solution {
    public int encryptionCalculate(int a, int b) {
        while (b != 0) {
            //note 这里一定要加括号
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}