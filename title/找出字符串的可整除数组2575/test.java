package title.找出字符串的可整除数组2575;

public class test {
}

// mind 没仔细看题
//class Solution {
//    public int[] divisibilityArray(String word, int m) {
//        int n = word.length();
//        int[] div = new int[n];
//        for (int i = 0; i < n; i++) {
//            if ((word.charAt(i) - '0') % m == 0) {
//                div[i] = 1;
//            } else {
//                div[i] = 0;
//            }
//        }
//        return div;
//    }
//}


//class Solution555 {
//    public int[] divisibilityArray(String word, int m) {
//        int n = word.length();
//        int[] div = new int[n];
//        long num = 0;
//        note 字符串的首位是左边的第一位而不是右边的第一位！！！
//        for (int i = n - 1; i >= 0; i--) {
//            num = (num * 10 + (word.charAt(i) - '0')) % m ;
//            if (num % m == 0) {
//                div[i] = 1;
//            }
//        }
//        return div;
//    }
//}

// method 自写
class Solution0 {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] div = new int[n];
        long num = 0;
        for (int i = 0; i < n; i++) {
            num = (num * 10 + (word.charAt(i) - '0')) % m ;
            if (num % m == 0) {
                div[i] = 1;
            }
        }
        return div;
    }
}

/**
 * 参考题解：灵神
 */
class Solution {
    public int[] divisibilityArray(String word, int m) {
        char[] s = word.toCharArray();
        int[] div = new int[s.length];
        // 需要是long类型
//        int num = 0;
        long num = 0;
        for (int i = 0; i < s.length; i++) {
            // note 不要忘记减去'0'
            num = (num * 10 + s[i] - '0') % m;
            if (num == 0) div[i] = 1;
        }
        return div;
    }
}