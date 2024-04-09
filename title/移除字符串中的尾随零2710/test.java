package title.移除字符串中的尾随零2710;

public class test {
}
class Solution1 {
    public String removeTrailingZeros(String num) {
        int i = num.lastIndexOf('0');
        while (num.lastIndexOf('0') >= 0 && num.charAt(num.length() - 1) == '0') {
            i = num.lastIndexOf('0');
            num = num.substring(0, i);
        }
        return num;
    }
}

class Solution {
    public String removeTrailingZeros(String num) {
        int i = num.length();
        int j = 0;
        for (j = num.length() - 1; j >= 0; j--) {
            if (num.charAt(j) != '0') {
                break;
            }
        }
        return num.substring(0, j + 1);
    }
}