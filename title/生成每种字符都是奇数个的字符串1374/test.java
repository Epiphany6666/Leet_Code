package title.生成每种字符都是奇数个的字符串1374;

public class test {
}

/*
class Solution {
    public String generateTheString(int n) {
        StringBuffer sb = new StringBuffer();
        int ret = n % 2;
        int len = 0;
        if (ret == 1) len = n;
        else {
            len = n - 1;
            sb.append('q');
        }
        for (int i = 0; i < len; i++) {
            sb.append('i');
        }
        return sb.toString();
    }
}*/

class Solution {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        while (n % 2 == 0 && --n >= 0) sb.append('a');
        while (n-- > 0) sb.append('b');
        return sb.toString();
    }
}