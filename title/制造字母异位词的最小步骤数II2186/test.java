package title.制造字母异位词的最小步骤数II2186;

public class test {
}

class Solution1 {
    public int minSteps(String s, String t) {
        int[] cnt1 = new int[26], cnt2 = new int[26];
        for (char c : s.toCharArray()) {
            cnt1[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            cnt2[c - 'a']++;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += Math.abs(cnt1[i] - cnt2[i]);
        }
        return ans;
    }
}

//method 2：一个加一个减
class Solution {
    public int minSteps(String s, String t) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            cnt[c - 'a']--;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += Math.abs(cnt[i]);
        }
        return ans;
    }
}