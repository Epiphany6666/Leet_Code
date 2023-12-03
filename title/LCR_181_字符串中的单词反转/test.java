package title.LCR_181_字符串中的单词反转;

public class test {
}

//method 1：双指针
/*
class Solution {
    public String reverseMessage(String s) {
        s = s.trim();
        StringBuffer ans = new StringBuffer();
        int i = s.length() - 1, j = i;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;
            ans.append(s.substring(i + 1, j + 1) + " ");
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return ans.toString().trim();
    }
}*/

//method 2：分割 + 倒序
class Solution {
    public String reverseMessage(String s) {
        String[] strs = s.trim().split(" ");
        StringBuffer ans = new StringBuffer();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i].equals("")) continue;
            ans.append(strs[i] + " ");
        }
        return ans.toString().trim();
    }
}