package title.包含所有三种字符的子字符串的数目1358;

import java.util.HashSet;
import java.util.Set;

public class test {
}

//method 超时了。。。有可能前面都是ab，最后一个才是c。。。
/*
class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                set.add(s.charAt(j));
                if (set.size() >= 3) {
                    ans += s.length() - j;
                    break;
                }
            }
        }
        return ans;
    }
}*/


//method 2：滑动窗口
/*
class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] cnt = new int[3];
        int j = 0;
        int ans = 0;
//        for (int i = 0; i < n; ) {
        for (int i = 0; i < n && j < n; ) {
            char ch = s.charAt(j);
            cnt[ch - 'a']++;
            while (i < n && check(cnt)) {
                ans += n - j;
                //note 你这写的是什么鬼
//                cnt[ch - s.charAt(i)]--;
                cnt[s.charAt(i) - 'a']--;
                i++;
            }
            j++;
        }
        return ans;
    }

    private boolean check(int[] cnt) {
        for (int i : cnt) {
            if (i == 0) return false;
        }
        return true;
    }
}*/

//method 2.1-简化
//note 其实再简化一点，比如for循环里可以放j，因为j每次都需要++
class Solution {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        int i = 0;
        int[] cnt = new int[3];
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            cnt[ch - 'a']++;
            //note 并且这里还不需要判断i会出界
            while (cnt[0] != 0 && cnt[1] != 0 && cnt[2] != 0) {
                ans += s.length() - j;
                cnt[s.charAt(i) - 'a']--;
                i++;
            }
        }
        return ans;
    }
}