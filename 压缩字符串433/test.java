package title.压缩字符串433;

public class test {
    public static void main(String[] args) {
        new Solution().compress(new char[] {'a','a','b','b','c','c','c'});
    }
}

/*
class Solution {
    public int compress(char[] chars) {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            int cnt = 1;
            while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                i++;
                cnt++;
            }
            s.append(chars[i]);
            if (cnt != 1)
            s.append(cnt);
        }
//        int len = s.length();
//        chars = new char[len];
        int idx = 0;
        for (char c : s.toString().toCharArray()) {
            chars[idx++] = c;
        }
        return idx;
    }
}*/

//method 2：双指针
class Solution {
    public int compress(char[] chars) {
        int l = 0;
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            //note 从1开始
//            int cnt = 0;
            int cnt = 1;
            while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                i++;
                cnt++;
            }
            chars[l++] = chars[i];
            if (cnt > 1) {
                int start = l, end = start;
                while (cnt > 0) {
                    chars[l++] = (char)(cnt % 10 + '0');
                    cnt /= 10;
                    end++;
                }
                reverse(chars, start, end - 1);
            }
        }
        return l;
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char t = chars[start];
            chars[start] = chars[end];
            chars[end] = t;
            start++;
            end--;
        }
    }
}