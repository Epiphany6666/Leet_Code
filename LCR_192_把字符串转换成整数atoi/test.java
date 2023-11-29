package title.LCR_192_把字符串转换成整数atoi;

public class test {
}

/*
class Solution {
    public int myAtoi(String str) {
        char[] charArray = str.trim().toCharArray();
        //note 越界问题
        if (charArray.length == 0) return 0;
        int i = 1, signed = 1;
        if (charArray[0] == '-') signed = -1;
        //note 示例 "+1"
//        else i = 0;
        else if (charArray[0] != '+') i = 0;
        int ans = 0, bndry = Integer.MAX_VALUE / 10;
        for (int j = i; j < charArray.length; j++) {
            if (charArray[j] > '9' || charArray[j] < '0') break;
            //note 整数的取值范围为 -32768～32767
            if (ans > bndry || (ans == bndry && charArray[j] > '7')) return signed == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            ans = ans * 10 + (charArray[j] - '0');
        }
        return signed * ans;
    }
}*/


//method 若不使用trim()，则可以将空间优化为O(1)
class Solution {
    public int myAtoi(String str) {
        char[] charArray = str.toCharArray();
        int i = 0, signed = 1;
        //note 还是要特判
        if (charArray.length == 0) return 0;
        while (charArray[i] == ' ') if (++i == charArray.length) return 0;
        if (charArray[i] == '-') signed = -1;
        if (charArray[i] == '+' || charArray[i] == '-') i++;
        int ans = 0, bndry = Integer.MAX_VALUE / 10;
        for (int j = i; j < charArray.length; j++) {
            if (charArray[j] > '9' || charArray[j] < '0') break;
            if (ans > bndry || (ans == bndry && charArray[j] > '7')) return signed == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            ans = ans * 10 + (charArray[j] - '0');
        }
        return signed * ans;
    }
}