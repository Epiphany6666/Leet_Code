package title.重新格式化电话号码1694;

public class test {
}

// method 自写，不会。。。。服了
//class Solution {
//    public String reformatNumber(String number) {
//        StringBuilder sb = new StringBuilder();
//        for (char c : number.toCharArray()) {
//            if (c == ' ' || c == '-') continue;
//            sb.append(c);
//        }
//        int n = sb.length();
//        StringBuilder s = new StringBuilder();
//        for (int i = 0; i < n; ) {
//            if (i + 1 == n - 4) {
//                for (int j = 0; j < i + 2; j++) {
//                    s.append()
//                }
//            } else if (i + 1 <= n - 3) {
//                for (int j = i; j < i + 3; j++) {
//                    s.append(j);
//                    s.append("-");
//                }
//                i += 3;
//            } else
//        }
//    }
//}

/**
 *  参考题解：宫水三叶
 */
class Solution {
    public String reformatNumber(String number) {
        number = number.replace(" ", "").replace("-", "");
        int n = number.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i += 3) {
            if (sb.length() != 0) {
                sb.append("-");
            }
            if (i + 4 >= n) {
                if (i + 3 >= n) sb.append(number.substring(i));
                else sb.append(number.substring(i, i + 2)).append("-").append(number.substring(i + 2));
                break;
            }
            sb.append(number.substring(i, i + 3));
        }
        return sb.toString();
    }
}