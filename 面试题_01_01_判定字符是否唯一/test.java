package title.面试题_01_01_判定字符是否唯一;

import java.util.HashSet;
import java.util.Set;

/**
 * 看到一个题解，好牛，真的牛，一个这么简单的题也能有6种解法
 */
public class test {
}

//method 1：哈希表
/*
class Solution {
    public boolean isUnique(String astr) {
        Set<Character> set = new HashSet<>();
        for (char c : astr.toCharArray()) {
//            if (set.add(c)) return false;
            if (!set.add(c)) return false;
        }
        return true;
    }
}*/

//method 2：位运算
/*class Solution {
    public boolean isUnique(String astr) {
        //note 添加：
        if (astr.length() > 26) return false;//如果长度超过了26，必为false
        int ans = 0;
        for (char c : astr.toCharArray()) {
            //即使再简单，也会犯错呐！
//            if ((ans & (c - 'a')) == 1) return false;
            //note 应该是不等于0！
//            if ((ans & (1 << (c - 'a'))) == 1) return false;
            if ((ans & (1 << (c - 'a'))) != 0) return false;
//            ans &= (c - 'a');
//            ans &= (1 << (c - 'a'));
            ans |= (1 << (c - 'a'));
        }
        return true;
    }
}*/

//method 3：数组
/*class Solution {
    public boolean isUnique(String astr) {
        int[] arr = new int[26];
        for (char c : astr.toCharArray()) {
            int x = c - 'a';
            if (arr[x] != 0) return false;
            arr[x]++;
        }
        return true;
    }
}*/

//method 4：两两比较


//method 5：使用String的indexOf方法
/**
 * string.indexOf(
 * 返回此字符串中第一次出现的指定字符的索引，从指定的索引开始搜索。
 * 如果值为 ch 的字符出现在此 String 对象表示的字符序列中，索引不小于 fromIndex，则返回第一次出现的此类字符的索引。
 * 如果此字符串中没有出现此类字符的位置 fromIndex，则返回 -1。
 */
/*class Solution {
    public boolean isUnique(String astr) {
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            if (astr.indexOf(c, i + 1) != -1) return false;
        }
        return true;
    }
}*/

//method 6：使用String的indexOf和lastIndexOf方法
class Solution {
    public boolean isUnique(String astr) {
        for (int i = 0; i < astr.length(); i++) {
            char ch = astr.charAt(i);
            if (astr.indexOf(ch) != astr.lastIndexOf(ch)) return false;
        }
        return true;
    }
}