package title.考试的最大困扰度2024;

public class test {
}

//虽然没有很理解，但是大为震撼
class Solution {
    String s;
    int k, n;
    public int maxConsecutiveAnswers(String answerKey, int _k) {
        s = answerKey;
        k = _k;
        n = answerKey.length();
        return Math.max(getCnt('T'), getCnt('F'));
    }

    public int getCnt(char c) {
        int ans = 0;
        for (int i = 0, j = 0, cnt = 0; i < n; i++) {
            if (s.charAt(i) == c) cnt++;
            while (cnt > k) {
                if (s.charAt(j) == c) cnt--;
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}