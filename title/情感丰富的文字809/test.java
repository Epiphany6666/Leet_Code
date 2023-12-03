package title.情感丰富的文字809;

import java.util.HashSet;
import java.util.Set;

public class test {
}

/*
class Solution {
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        int[] ch = new int[26];
        for (char c : s.toCharArray()) {
            ch[c - 'a']++;
        }
        for (String word : words) {
            Set<Character> set = new HashSet<>();
            word
        }
        return ans;
    }
}*/

/*
//note 题解秒啊，太妙了
class Solution {
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        char[] sc = s.toCharArray();
        for (String word : words) {
            ans += stretchyWord(sc, word.toCharArray()) ? 1 : 0;
        }
        return ans;
    }

    private boolean stretchyWord(char[] sc, char[] word) {
        int cp = 0, p1 = 0, p2 = 0;
        while ((cp = p1) < sc.length || p2 < word.length) {
            int cnt1 = 0, cnt2 = 0;
            while (p1 < sc.length && sc[p1] == sc[cp]) {
                p1++;
                cnt1++;
            }
            while (p2 < sc.length && sc[p2] == sc[cp]) {
                p2++;
                cnt2++;
            }

            if ((cnt1 != cnt2 && cnt1 < 3) || (cnt1 < cnt2)) return false;
        }
//        return true;
        return p1 == sc.length && p2 == word.length;
    }
}*/

class Solution {
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        char[] sc = s.toCharArray();
        for (String word : words) {
            ans += stretchyWord(sc, word.toCharArray()) ? 1 : 0;
        }
        return ans;
    }

    private boolean stretchyWord(char[] sc, char[] word) {
        int cp = 0, p1 = 0, p2 = 0;
        //note 这里是&&！
        while ((cp = p1) < sc.length && p2 < word.length) {
            int cnt1 = 0, cnt2 = 0;
            while (p1 < sc.length && sc[p1] == sc[cp]) {
                p1++;
                cnt1++;
            }
            //note cp指向的是sc中的单词！所以应该等于的是sc[cp]而不是word[cp]
            while (p2 < word.length && word[p2] == sc[cp]) {
                p2++;
                cnt2++;
            }

            if ((cnt1 != cnt2 && cnt1 < 3) || (cnt1 < cnt2)) return false;
        }
        //note 全部遍历完才能返回true！
        //return true;
        return p1 == sc.length && p2 == word.length;
    }
}