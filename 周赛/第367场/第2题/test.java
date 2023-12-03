package 周赛.第367场.第2题;

public class test {
    public static void main(String[] args) {
        new Solution().shortestBeautifulSubstring("100011001", 3);
    }
}

/*
class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "";
        int len = s.length();
        int l = len - 1, r = len - 1;
        int cnt = 0;
        while (r >= 0) {
            while (r >= 0 && cnt <= k) cnt += ((Integer.parseInt(s, 2) >> r--) & 1);
            if (cnt < k) return "";
            if (ans == null || ans.length() < r - l) ans = s.substring(l, r);
            while (l < r && cnt >= k) cnt += ((Integer.parseInt(s, 2) >> l++) & 1) == 1 ? -1 : 0;
        }
        return ans;
    }
}*/

/*
class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "";
        int len = s.length();
        int l = 31, r = 31;
        int cnt = 0;
        while (r >= 0) {
            int num = Integer.parseInt(s, 2);
            while (r >= 0 && cnt <= k) cnt += ((num >> r--) & 1);
            if (cnt < k) return "";
            if (ans == "" || ans.length() < r - l) ans = s.substring(l, r);
            while (l < r && cnt >= k) cnt += ((Integer.parseInt(s, 2) >> l++) & 1) == 1 ? -1 : 0;
        }
        return ans;
    }
}*/

/*
class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int len = s.length();
        int num = Integer.parseInt(s, 2);
        int l =0, r = 0;
        int cnt = 0;
        String ans = "";
        while (r < len) {
            while (r < len && cnt < k) cnt += (s.charAt(r++) - '0');
            if (cnt < k) return "";
            if (ans == "" || ans.length() >= r - l) {
                if (ans.length() == r - l) {
                    ans = Integer.parseInt(ans, 2) > Integer.parseInt(s.substring(l, r), 2) ? s.substring(l, r) : ans;
                } else {
                    ans = s.substring(l, r);
                }
            }
            while (l < r && (cnt >= k || (s.charAt(l) - '0') == 0)) cnt -= (s.charAt(l--) - '0');
        }
        return ans;
    }
}*/

class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        // 1 的个数不足 k
        if (s.replaceAll("0", "").length() < k) {
            return "";
        }
        // 否则一定有解
        for (int size = k; ; size++) {
            String ans = "";
            for (int i = size; i <= s.length(); i++) {
                String t = s.substring(i - size, i);
                if ((ans.isEmpty() || t.compareTo(ans) < 0) && t.replaceAll("0", "").length() == k) {
                    ans = t;
                }
            }
            if (!ans.isEmpty()) {
                return ans;
            }
        }
    }
}