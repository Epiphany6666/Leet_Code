package title.删除字符使字符串变好1957;

public class test {
}

/*
class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        int[] cnt = new int[26];
        while (i < n && j < n) {
            char ch = s.charAt(j);
            */
//mind cnt也忘记--
/*while (++cnt[ch - 'a'] >= 3) {
                i++;
            }*//*

            while (i < n && ++cnt[ch - 'a'] >= 3) {
                cnt[s.charAt(i) - 'a']--;
                i++;
            }
            sb.append(j);
        }
        return sb.toString();
    }
}*/

//note 完全误解错题目意思了。。。题目说的是连续的啊。。。
/*
class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        int[] cnt = new int[26];
        while (i < n && j < n) {
            char ch = s.charAt(j);
            */
/*while (i < n && ++cnt[ch - 'a'] >= 3) {
                cnt[s.charAt(i) - 'a']--;
                i++;
            }*//*

            while (j < n && ++cnt[ch - 'a'] >= 3) {
                cnt[s.charAt(i) - 'a']--;
                j++;
            }
            sb.append(ch);
            j++;
        }
        return sb.toString();
    }
}*/

//method 上面都想复杂了。。。
class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length() - 2; i++) {
        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i + 1) == s.charAt(i + 2)) {
            if (i < s.length() - 2 && s.charAt(i) == s.charAt(i + 1) && s.charAt(i + 1) == s.charAt(i + 2)) {
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}