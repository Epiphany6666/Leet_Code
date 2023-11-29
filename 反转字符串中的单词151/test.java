package title.反转字符串中的单词151;

import java.util.*;

public class test {
    public static void main(String[] args) {
        new Solution().reverseWords("the  sky   is blue");
    }
}

/**
 * String.jon():请注意，如果单个元素为 null，则添加“null”。形参：分隔符 – 用于分隔生成的 String 元素中的每个元素的字符序列 – 一个可迭代对象，其元素将连接在一起。返回值： 由 elements 参数组成的新字符串
 */

/*
//mind 无语，看错题目意思
class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        for (String str : strs) {
            StringBuilder sb = new StringBuilder(str);
            str = sb.reverse().toString();
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String str = strs[i];
            ans.append(str);
            if (i != s.leng
            6th() - 1) ans.append(" ");
        }
        return ans.toString();
    }
}*/

//mind 无语了，还有这种案例："  hello world  "
/*
class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        int l = 0, r = strs.length - 1;
        while (l < r) {
            String t = strs[l];
            strs[l] = strs[r];
            strs[r] = t;
            //note 居然又忘记。。。
            l++;r--;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            ans.append(strs[i]);
            if (i != strs.length - 1) ans.append(" ");
        }
        return ans.toString();
    }
}*/

//mind 虽然过时过了，但是要考虑的太多了。。。
/*
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        //note 1：特判开头是否为空格
        if (s.charAt(0) != ' ')sb.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && s.charAt(i) == s.charAt(i - 1)) {
//                i++;
                continue;
            }
            sb.append(s.charAt(i));
        }
        s = sb.toString();
        String[] strs = s.split(" ");
        int l = 0, r = strs.length - 1;
        while (l < r) {
            String t = strs[l];
            strs[l] = strs[r];
            strs[r] = t;
            l++;
            r--;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            ans.append(strs[i]);
            if (i != strs.length - 1) ans.append(" ");
        }
        return ans.toString();
    }
}*/

//method 1：双端队列
/*
class Solution {
    public String reverseWords(String s) {
        Deque<String> stack = new LinkedList<>();
        int len = s.length(), l = 0, r = len - 1;
        //去掉首位空格
        while (l < len && s.charAt(l) == ' ') l++;
        while (r >= 0 && s.charAt(r) == ' ') r--;

        StringBuffer word = new StringBuffer();
        while (l <= r) {
            if (word.length() != 0 || s.charAt(l) == ' ') {
                stack.push(word.toString());
                word.setLength(0);
                //note 这也能忘
//            } else {
            } else if (s.charAt(l) != ' '){
                word.append(s.charAt(l));
            }
        }
        return String.join(" ", stack);
    }
}*/

/**
 * s.trim()：
 * 返回一个字符串，其值为此字符串，并删除所有前导空格和尾随空格，其中空格定义为代码点小于或等于“U+0020”（空格字符）的任何字符。
 *
 * Collections.reverse()：反转指定列表中元素的顺序。
 */
/*
//method 2：使用语言特性
class Solution {
    public String reverseWords(String s) {
        s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}*/

//method 2：先翻转这个字符串，再翻转每个单词
/*
class Solution {
    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer(s);
        s = sb.reverse().toString();
        for (int start = 0; start < s.length(); start++) {
            StringBuffer word = new StringBuffer();
            char c = s.charAt(start);
            if (c != ' ') {
                int end = start;
                while (end < s.length() && s.charAt(end) != ' ') end++;

            }
        }
    }
}*/

/*
//method 双指针
class Solution {
    public String reverseWords(String s) {
        int j = s.length() - 1, i = j;
        StringBuilder ans = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;
            ans.append(s.substring(i + 1, j + 1) + " ");
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return ans.toString();
    }
}*/

//method 分割 + 倒序
/**
 * 我第一次知道，split方法，若两单词间有 x>1个空格，则在单词列表 str 中，此两单词间会多出 x−1 个 “空单词” （即 "" ）
 */
class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            String st = str[i];
            if (st == "") continue;
            ans.append(st + " ");
        }
        return ans.toString().trim();
    }
}