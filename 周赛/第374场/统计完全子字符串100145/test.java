package 周赛.第374场.统计完全子字符串100145;

public class test {
}

class Solution {
    public int countCompleteSubstrings(String word, int k) {
        int n = word.length();
        int ans = 0;
        for (int i = 0; i < n; ) {
            int st = i;
            for (i++; i < n && Math.abs(word.charAt(i) - word.charAt(i - 1)) <=2; i++) {
                ans += f(word.substring(st, i), k);
            }
        }
        return ans;
    }

    private int f(String S, int k) {
        char[] s = S.toCharArray();
        int res = 0;
        for (int m = 1; m <= 26 && k * m <= s.length; m++) {
            int[] cnt = new int[26];
            for (int right = 0; right < s.length; right++) {
                cnt[s[right] - 'a']++;
                int left = right + 1 - k * m;
                if (left >= 0) {
                    boolean ok = true;
                    for (int i = 0; i < 26; i++) {
                        if (cnt[i] > 0 && cnt[i] != k) {
                            ok = false;
                            break;
                        }
                    }
                    if (ok) res++;
                    cnt[s[left] - 'a']--;
                }
            }
        }
        return res;
    }
}