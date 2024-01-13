package title.构造限制重复的字符串2182;

public class test {
    public static void main(String[] args) {
        new Solution().repeatLimitedString("aababab", 2);
    }
}

class Solution1 {
    public String repeatLimitedString(String s, int repeatLimit) {
        char[] map = new char[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        StringBuffer ans = new StringBuffer();
        for (char i = 'z'; i >= 'a'; i--) {
            for (int j = 0; j < map[i - 'a']; j++) {
                ans.append(i);
            }
        }

        int len = ans.length();
        int cnt = 1;
        // 双指针
        for (int left = 1, right = 2; left < len; left++) {
            if (ans.charAt(left - 1) != ans.charAt(left)) {
                cnt = 1;
            } else {
                cnt++;
                if (cnt > repeatLimit) {
                    right = Math.max(right, left + 1);
//                    note 这里不能这样写，否则会超时，因为上面 right = Math.max(right, left + 1); 已经判断过重复的地方了
//                    right = left + 1;
                    while (right < len && ans.charAt(right - 1) == ans.charAt(right)) {
                        right++;
                    }
                    if (right < len) {
                        char tmp = ans.charAt(left);
                        ans.setCharAt(left, ans.charAt(right));
                        ans.setCharAt(right, tmp);
                    } else {
                        // note 这里很巧妙
//                        ans = new StringBuffer(ans.substring(0, left));
                        ans.setLength(left);
                        break;
                    }
                }
            }
        }
        return ans.toString();
    }
}