package title.删除字符串两端相同字符后的最短长度1750;

public class test {
}

// method 自写，不会。。
//class Solution {
//    public int minimumLength(String s) {
//        int i = 0, n = s.length(), j = n - 1;
//        while (i < j) {
//            char c = s.charAt(i);
//            boolean cnt = false;
//            while (i + 1 < n && s.charAt(i + 1) == c) i++;
//            while (i < j && s.charAt(j) == c) {
//                j--;
//                cnt = true;
//            }
//            if (!cnt) break;
//        }
//        return n - i - (n - 1 - j);
//    }
//}

/**
 * 参考题解：ylb
 */
// method 双指针
class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            while (i + 1 < j && s.charAt(i) == s.charAt(i + 1)) {
                i++;
            }
            while (i < j - 1 && s.charAt(j) == s.charAt(j - 1)) {
                j--;
            }
            i++;
            j--;
        }
        return n - (i + 1) - (n - 1 - j);
    }
}