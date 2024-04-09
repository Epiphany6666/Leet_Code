package title.修改后的最大二进制字符串1702;

public class test {
}

/**
 * 参考题解：力扣官方题解
 */
// method 1：模拟 + 贪心
class Solution1 {
    public String maximumBinaryString(String binary) {
        int n = binary.length();
        char[] s = binary.toCharArray();
        int j = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '0') {
                while (j <= i || (j < n && s[j] == '1')) {
                    j++;
                }
                if (j < n) {
                    s[j] = '1';
                    s[i] = '1';
                    s[i + 1] = '0';
                }
            }
        }
        return new String(s);
    }
}

// method 2：直接构造
class Solution {
    public String maximumBinaryString(String binary) {
        int n = binary.length(), i = binary.indexOf('0');
        if (i < 0) {
            return binary;
        }
        int zero = 0;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            if (binary.charAt(j) == '0') {
                zero++;
            }
            sb.append('1');
        }
        sb.setCharAt(i + zero - 1, '0');
        return sb.toString();
    }
}