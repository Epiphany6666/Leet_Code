package title.最大二进制奇数2864;

public class test {
}

// method：自写
class Solution0 {
    public String maximumOddBinaryNumber(String s) {
        int one = 0;
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c == '1') one++;
        }
        if (one == 0) {
            return s;
        } else if (one == 1) {
            cs[cs.length - 1] = '1';
            for (int i = 0; i < cs.length - 1; i++) {
                cs[i] = '0';
            }
            return new String(cs);
        } else {
            cs[cs.length - 1] = '1';
            one--;
            for (int i = 0; i < cs.length - 1; i++) {
                if (one-- > 0) {
                    cs[i] = '1';
                } else {
                    cs[i] = '0';
                }
            }
            return new String(cs);
        }
    }
}

/**
 * 参考题解：官网
 */
// note 查看提示：s中至少包含一个'1'
class Solution {
    public String maximumOddBinaryNumber(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt += s.charAt(i) - '0';
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < cnt - 1; i++) {
            sb.append('1');
        }
        for (int i = 0; i < s.length() - cnt; i++) {
            sb.append('0');
        }
        sb.append('1');
        return sb.toString();
    }
}