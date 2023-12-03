package title.最小覆盖子串76;

public class test {
}

/**
 * 由于字符串的charAt方法，每次都需要去检查字符串是否越界，所以习惯的做法是先将字符串转化为字符数组！
 * 数组个数写成123可以，但习惯上写成2的幂次方，即128
 */
class Solution {
    public String minWindow(String s, String t) {
        int tLen = t.length();
        int sLen = s.length();
        int ans = Integer.MAX_VALUE;
        int distance = 0;

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        int[] winCnt = new int[128];
        int[] tCnt = new int[128];

        for (char c : charArrayT) {
            tCnt[c]++;
        }

        //note 左闭右开，开始为空区间
        int l = 0, r = 0;

        int begin = 0, end = 0;
        while (r < sLen) {
            /*
            int charS = charArrayS[r];
            while (winCnt[charS] < tCnt[charS]) {
                r++;
                winCnt[charS]++;
                if (winCnt[charS] == tCnt[charS]) {
                    distance++;
                }
                charS = charArrayS[r];
            }*/
            char charRight = charArrayS[r];
            if (winCnt[charRight] < tCnt[charRight])  {
                distance++;
            }
            winCnt[charRight]++;
            r++;

            /*int charT = charArrayS[l];
            while (winCnt[charT] >= tCnt[charT]) {
                l++;
                winCnt[charT]--;
                charT = charArrayS[l];
            }

            distance = Math.min(distance, r - l);*/

            while (distance == tLen) {
                if (r - l < ans) {
                    ans = r - l;
                    begin = l;
                }

                char charLeft = charArrayS[l];
                if (winCnt[charLeft] == tCnt[charLeft]) {
                    distance--;
                }
                winCnt[charLeft]--;
                l++;
            }
        }

        return ans == Integer.MAX_VALUE ? "" : s.substring(begin, begin + ans);
    }
}