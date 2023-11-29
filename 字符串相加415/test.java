package title.字符串相加415;

public class test {
    public static void main(String[] args) {
        String num1 = "11";
        String num2 = "123";
        new Solution().addStrings(num1, num2);
    }
}

/*
class Solution {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int length = n1 > n2 ? n1 : n2;
        int carry = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int ch1, ch2;
            ch1 = i < n1 ? num1.charAt(n1 - i - 1) - '0' : 0;
            ch2 = i < n2 ? num2.charAt(n2 - i - 1) - '0' : 0;
            int sum = ch1 + ch2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        sb.reverse();
        return sb.toString();
    }
}*/

//简化
class Solution {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int carry = 0;
        StringBuffer sb = new StringBuffer();
        while(n1 > 0 || n2 > 0 || carry > 0) {
            int ch1, ch2;
            ch1 = n1 > 0 ? num1.charAt(n1 - 1) - '0' : 0;
            ch2 = n2 > 0 ? num2.charAt(n2 - 1) - '0' : 0;
            int sum = ch1 + ch2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            n1--;
            n2--;
        }
        sb.reverse();
        return sb.toString();
    }
}