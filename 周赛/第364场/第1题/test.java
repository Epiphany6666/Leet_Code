package 周赛.第364场.第1题;

import java.util.Arrays;

public class test {
}

class Solution {
    public String maximumOddBinaryNumber(String s) {
        int cnt = 0;
        char[] ch = new char[s.length()];
        for (char c : s.toCharArray()) {
            if (c == '1') cnt++;
        }
        if (cnt == 0) return s;
        if (cnt == 1) {
            Arrays.fill(ch, '0');
            ch[ch.length - 1] = '1';
            return new String(ch);
        }
        for (int i = 0; i < cnt - 1; i++) {
            ch[i] = '1';
        }
        for (int i = cnt - 1; i < ch.length - 1; i++) {
            ch[i] = '0';
        }
        ch[ch.length - 1] = '1';
        return new String(ch);
    }
}