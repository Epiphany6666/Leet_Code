package title.反转字符串中的单词151.overWrite01;

public class test {
}

//method 1：双指针
/*class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int i = s.length() - 1, j = i;
        StringBuffer ans = new StringBuffer();
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
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" ");
        StringBuffer ans = new StringBuffer();
        for (int i = strs.length - 1; i < 0; i--) {
            //note 这里分割出来的是x - 1个空字符串，而不是空格
//            if (strs[i] == "") continue;
            if (strs[i].equals("")) continue;
            ans.append(strs[i] + " ");
        }
        return ans.toString().trim();
    }
}