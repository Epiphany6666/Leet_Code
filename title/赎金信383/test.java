package Leet_Code.赎金信383;

/**
 * 审题要审清楚啊，好多次都是写到一半结果发现题目都没看清楚。。
 */
public class test {
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] r = new int[26];
        int[] m = new int[26];
        for (char c : ransomNote.toCharArray()) {
            r[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
            //note 太粗心了！！！
//            r[c - 'a']++;
            m[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            //note 题目意思都没读懂，，，多审题啊。。。！！！
//            if (r[i] != 0 && m[i] == 0) return false;
//            if (r[i] != 0 && r[i] != 1) return false;
            if (r[i] > m[i]) return false;
        }
        return true;
    }
}

//method 宫叶写法：
class Solution2 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] r = new int[26];
        //note 注意这两个要反过来写
//        for (char c : ransomNote.toCharArray()) {
        for (char c : ransomNote.toCharArray()) {
            r[c - 'a']++;
        }
//        for (char c : magazine.toCharArray()) {
        for (char c : magazine.toCharArray()) {
            if (--r[c - 'a'] < 0) return false;
        }
        return true;
    }
}