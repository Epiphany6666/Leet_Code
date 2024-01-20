package title.加一66;

public class test {
}

//class Solution {
//    public int[] plusOne(int[] digits) {
//        int n = digits.length;
//        for (int i = n - 1; i >= 0; i++) {
//            if (digits[i] != 9) {
//                digits[i]++;
//                break;
//            } else {
//                digits[i] = 0;
//            }
//        }
//        return digits;
//    }
//}

//mind 还是要看题解，太神了。。。
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
             if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}